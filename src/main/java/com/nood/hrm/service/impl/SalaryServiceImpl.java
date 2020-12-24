package com.nood.hrm.service.impl;

import com.nood.hrm.common.response.Response;
import com.nood.hrm.dto.SalaryCustomDto;
import com.nood.hrm.dto.SalaryMetaDto;
import com.nood.hrm.mapper.*;
import com.nood.hrm.model.Department;
import com.nood.hrm.model.Role;
import com.nood.hrm.model.SalaryMeta;
import com.nood.hrm.model.User;
import com.nood.hrm.security.user.LoginUser;
import com.nood.hrm.service.SalaryService;
import com.nood.hrm.util.ExcelData;
import com.nood.hrm.util.ExcelUtil;
import com.nood.hrm.util.PinyinUtil;
import com.nood.hrm.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.nood.hrm.security.data.DataScope.*;


@Service
@Transactional
@Slf4j
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryMetaMapper salaryMetaMapper;

    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private RoleDepartmentMapper roleDepartmentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Response<SalaryMeta> getAllMetaByPage(Integer offset, Integer limit) {

        // 更新序号为最新的一年，确保每年都能生成一张新表
        SalaryMeta salaryMeta = salaryMetaMapper.getMetaByName(new SalaryCustomDto().getNoChinese());
        String year = (new SimpleDateFormat("yyyy")).format(new Date());
        if (Integer.parseInt(year) > Integer.parseInt(salaryMeta.getVersion())) {
            salaryMeta.setVersion(year);
            updateMeta(salaryMeta);
        }

        return Response.success(
                salaryMetaMapper.countAll().intValue(),
                salaryMetaMapper.getAllMetaByPage(offset, limit));
    }

    @Override
    public Response<SalaryMeta> saveMeta(SalaryMeta salaryMeta) {

        boolean isCreateNewTable = Integer.parseInt(salaryMeta.getVersion()) > salaryMetaMapper.getLatestVersion();
        int id = salaryMetaMapper.save(salaryMeta);

        // 获取最新的表名称，新表则逐个插入，旧表则直接插入新值即可
        String tableName = getLatestSalaryTableName();
        if (isCreateNewTable) {
            salaryMapper.createSalaryTable(tableName);
            List<SalaryMeta> latestSalaryMetaList = getLatestSalaryMetaList();
            latestSalaryMetaList.forEach(e -> {
                e.setTableName(tableName);
                updateSalaryStructure(null, e);
            });
        } else {
            salaryMeta.setTableName(tableName);
            updateSalaryStructure(null, salaryMeta);
        }

        if (id < 0) return Response.failure();
        return Response.success();
    }

    @Override
    public SalaryMeta getById(Integer id) {
        return salaryMetaMapper.getById(id);
    }

    @Override
    public Response<SalaryMeta> updateMeta(SalaryMeta salaryMeta) {

        // 记录下是否要创建新表
        boolean isCreateNewTable = Integer.parseInt(salaryMeta.getVersion()) > salaryMetaMapper.getLatestVersion();
        SalaryMeta originSalaryMeta = salaryMetaMapper.getById(salaryMeta.getId());

        // 将更改信息写进salaryMeta, 并更新salaryMeta表
        loadSalaryMetaHistory(originSalaryMeta, salaryMeta);
        salaryMetaMapper.updateSalaryMeta(salaryMeta);

        // 获取最新的表名称，新表则逐个插入，旧表则直接更新结构
        String tableName = getLatestSalaryTableName();
        if (isCreateNewTable) {
            salaryMapper.createSalaryTable(tableName);
            List<SalaryMeta> latestSalaryMetaList = getLatestSalaryMetaList();
            latestSalaryMetaList.forEach(e -> {
                e.setTableName(tableName);
//                System.out.println(e);
                updateSalaryStructure(null, e);
            });
        } else {
            salaryMeta.setTableName(tableName);
            updateSalaryStructure(originSalaryMeta, salaryMeta);
        }

        return Response.success();
    }

    /**
     * 获取最新版本的薪水数据
     * @return
     */
    private List<SalaryMeta> getLatestSalaryMetaList() {

        Map<String, SalaryMeta> name2Salary = new HashMap<>();

        for (SalaryMeta salaryMeta :  salaryMetaMapper.getAllMeta()) {
            if (salaryMeta.getStatus() != 1) continue;
            if (name2Salary.containsKey(salaryMeta.getName())) {
                String newVersion = salaryMeta.getVersion();
                String oldVersion = name2Salary.get(salaryMeta.getName()).getVersion();
                if (Integer.parseInt(newVersion) > Integer.parseInt(oldVersion)) {
                    name2Salary.put(salaryMeta.getName(), salaryMeta);
                }
            } else {
                name2Salary.put(salaryMeta.getName(), salaryMeta);
            }
        }
        List<SalaryMeta> latestSalaryMetaList = name2Salary.values().stream()
                .filter(e -> e.getStatus() == 1)
                .sorted((o1, o2) -> o1.getSort().compareTo(o1.getSort()))
                .collect(Collectors.toList());
        return latestSalaryMetaList;
    }

    private void loadSalaryMetaHistory(SalaryMeta originSalaryMeta, SalaryMeta salaryMeta) {
        if (!originSalaryMeta.getName().equals(salaryMeta.getName())) {
            String history = originSalaryMeta.getHistory();
            if (history == null) history = "";
            Set<String> historySet = Arrays.stream(history.split("  ")).collect(Collectors.toSet());
            if(!historySet.contains(originSalaryMeta.getName())) {
                history = originSalaryMeta.getName() + "  " + history;
                salaryMeta.setHistory(history);
            }
        }
    }
    private void updateSalaryStructure(SalaryMeta originSalaryMeta, SalaryMeta salaryMeta) {
        String newName = PinyinUtil.hanziToPinyin(salaryMeta.getName(),"_");
        if (originSalaryMeta == null) {
            if (salaryMeta.getIsDecimal() == 1)
                salaryMapper.addDecimalColumn(newName, salaryMeta.getName(), salaryMeta.getTableName());
            else
                salaryMapper.addVarcharColumn(newName, salaryMeta.getName(), salaryMeta.getTableName());
        } else {
            // 修改原有字段的名字和commit : alter table <表名> change <字段名> <字段新名称> <字段的类型>
            String oldName = PinyinUtil.hanziToPinyin(originSalaryMeta.getName(),"_");
            if (salaryMeta.getIsDecimal() == 1)
                salaryMapper.update2DecimalColumn(oldName, newName, salaryMeta.getName(), salaryMeta.getTableName());
            else
                salaryMapper.update2VarcharColumn(oldName, newName, salaryMeta.getName(), salaryMeta.getTableName());
        }

    }

    @Override
    public void downLoadSalaryMeta(HttpServletResponse response) {

        List<String> heads = getLatestSalaryMetaList().stream()
                .sorted((o1, o2) -> o1.getSort().compareTo(o2.getSort()))
                .map(e -> e.getName())
                .collect(Collectors.toList());

        ExcelData excelData = new ExcelData();
        excelData.setHeads(heads);
        excelData.setFileName("salary.xlsx");

        try {
            ExcelUtil.exportExcel(response, excelData);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int deleteMetaBy(Integer id) {

        return deleteMeta(id, true);

    }

    @Override
    public Response<SalaryMeta> getMetaByFuzzyName(String name, Integer offset, Integer limit) {
        return Response.success(
                salaryMetaMapper.countMetaByFuzzyName(name).intValue(),
                salaryMetaMapper.getMetaByFuzzyNameWithPage(name, offset, limit));
    }

    @Override
    public Response updateSalary(MultipartFile file) {
        InputStream input = null;
        Workbook wb = null;
        String latestSalaryTableName = getLatestSalaryTableName();
        try {
            input=file.getInputStream();
            String fileName=file.getOriginalFilename();
            if(fileName.endsWith(".xls")){     //Excel&nbsp;2003
                wb = new HSSFWorkbook(input);
            }else if(fileName.endsWith(".xlsx")){    // Excel 2007/2010
                wb = new XSSFWorkbook(input);
            }
            Sheet sheet = wb.getSheetAt(0);
            Row head = sheet.getRow(0);

            Map<String, Object> column2record = new HashMap<>();
            Map<Integer, String> index2Column = new HashMap<>();
            Map<Integer, Integer> index2Numeric = new HashMap<>();

            for(int cellNum = 0; cellNum < head.getLastCellNum(); cellNum++){
                String originKey = head.getCell(cellNum).getStringCellValue();
                String columnKey = PinyinUtil.hanziToPinyin(originKey, "_");
                SalaryMeta salaryMeta = salaryMetaMapper.getMetaByName(originKey);

                index2Column.put(cellNum, columnKey);
                index2Numeric.put(cellNum, salaryMeta.getIsDecimal());
            }

            //读取行
            for(int rowNum=1;rowNum < sheet.getLastRowNum()+1; rowNum++){
                Row row = sheet.getRow(rowNum);
                if(row!=null) {
                    for(int cellNum = 0;cellNum < row.getLastCellNum();cellNum++){
                        if (index2Numeric.get(cellNum) == 1) {
                            column2record.put(index2Column.get(cellNum), row.getCell(cellNum).getNumericCellValue());
                        } else {
                            row.getCell(cellNum).setCellType(Cell.CELL_TYPE_STRING);
                            column2record.put(index2Column.get(cellNum), row.getCell(cellNum).getStringCellValue());
                        }
                    }
//                    System.out.println(column2record);
                    salaryMapper.insertWithMap(column2record, latestSalaryTableName);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Response.success();
    }

    @Override
    public List<SalaryMetaDto> getSalaryTableHead() {
        SalaryCustomDto salaryCustomDto = new SalaryCustomDto();
        List<SalaryMetaDto> headers = getLatestSalaryMetaList().stream()
                .sorted((o1, o2) -> o1.getSort().compareTo(o2.getSort()))
                .map(e -> {
                    SalaryMetaDto salaryMetaDto = new SalaryMetaDto(PinyinUtil.hanziToPinyin(e.getName(), "_"), e.getName());

                    if (salaryMetaDto.getField().equals(salaryCustomDto.employeeNameAlias)) {
                        salaryMetaDto.setFixed("left");
                    }
                    if (salaryMetaDto.getField().equals(salaryCustomDto.actualIncomeAlisa)) {
                        salaryMetaDto.setFixed("right");
                    }

                    return salaryMetaDto;
                })
                .collect(Collectors.toList());
        return headers;
    }

    @Override
    public Response getSalaryTable(Integer offset, Integer limit, SalaryCustomDto salaryCustomDto) {

        // 1.1 根据salaryConditionDto先筛选出一批数据
        List<Map<String, Object>> salaryByFuzzyName = getSalaryGroupByNo(salaryCustomDto);

        // 1.2 从loginUser中获取 DepartmentSet 过滤后，排序，返回一个List
//        Set<String> departmentNameSet = getDepartmentNamePermission();
        Set<String> departmentNoSet = getDepartmentNoPermission();

        List<Map<String, Object>> salaryByFilter = salaryByFuzzyName.stream()
                .filter(recordMap -> {
                    if (departmentNoSet.size() > 0) {
                        String userNo = recordMap.get(salaryCustomDto.getEmployeeNoAlias()).toString();
                        User user = userMapper.getUserByNo(userNo);
                        Department department = departmentMapper.getDeptById(user.getDepartmentId());
                        return departmentNoSet.contains(department.getNo());
                    } else {
//                        System.out.println(" NO " + SecurityUtil.getCurrentUser().getNo() + " - " + recordMap.get(salaryCustomDto.getEmployeeNoAlias()));
                        return SecurityUtil.getCurrentUser().getNo().equals(recordMap.get(salaryCustomDto.getEmployeeNoAlias()));
                    }
                })
                .sorted((o1, o2) -> {
                    Integer s1 = Integer.valueOf(o1.getOrDefault(salaryCustomDto.employeeNoAlias, "0").toString());
                    Integer s2 = Integer.valueOf(o2.getOrDefault(salaryCustomDto.employeeNoAlias, "0").toString());
                    return s1.compareTo(s2);
                })
                .collect(Collectors.toList());

        // 则添加平均工资的记录项
        appendAverageRecord(salaryByFilter, salaryCustomDto);
//        Collections.sort(salaryByFilter, new Comparator<Map<String, Object>>() {
//            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
//                Integer n1 = Integer.valueOf(o1.get(salaryCustomDto.employeeNoAlias).toString()) ;
//                Integer n2 = Integer.valueOf(o2.get(salaryCustomDto.employeeNoAlias).toString()) ;
//                return n1.compareTo(n2);
//            }
//        });

        // 1.3 根据List分页输出
        int count = salaryByFilter.size();
        int fromIndex = offset;
        int toIndex = (count > offset + limit) ? offset + limit : count;
        Response response = Response.success(count, salaryByFilter.subList(fromIndex, toIndex));

         return response;
    }

    /**
     * 添加平均项
     * @param salaryByFilter
     * @param salaryCustomDto
     */
    private void appendAverageRecord(List<Map<String,Object>> salaryByFilter, SalaryCustomDto salaryCustomDto) {
        if (salaryByFilter.size() > 0) {
            String tableName = getSalaryTableName(salaryCustomDto.getYear());
            if (Integer.parseInt(salaryCustomDto.getYear()) > salaryMetaMapper.getLatestVersion()) {
                tableName = getLatestSalaryTableName();
            }
            List<Map<String, Object>> onePerson = salaryMapper.getSalaryByNoAndYearAndMonth(
                    salaryCustomDto,
                    (String) salaryByFilter.get(0).get(salaryCustomDto.getEmployeeNoAlias()),
                    tableName);

            Set<String> monthSet = onePerson.stream().map(e -> e.get(salaryCustomDto.getDateAlias()).toString().split("-")[1]).collect(Collectors.toSet());
            Set<String> decimalColumns = getDecimalColumns();

            Map<String, Object> averageRecord = new HashMap<>();
            averageRecord.put(salaryCustomDto.getEmployeeNameAlias(), "平均工资");

            Set<String> departmentSet = new HashSet<>();
            salaryByFilter.forEach(record -> {
                for (String column : record.keySet()) {
                    if (decimalColumns.contains(column)) {
                        BigDecimal currentValue = (BigDecimal) record.getOrDefault(column, new BigDecimal(0.0));
                        BigDecimal originalValue = (BigDecimal) averageRecord.getOrDefault(column, new BigDecimal(0.0));
                        averageRecord.put(column, originalValue.add(currentValue));
                    }
                    departmentSet.add(record.get(salaryCustomDto.getDepartmentNameAlias()).toString());
                }
            });

            for (String col : averageRecord.keySet()) {
                if (decimalColumns.contains(col)) {
                    BigDecimal originalValue = (BigDecimal) averageRecord.getOrDefault(col, new BigDecimal(0.0));
                    averageRecord.put(col, originalValue.divide(new BigDecimal(salaryByFilter.size())));
                }
            }

            averageRecord.put(salaryCustomDto.getDepartmentNameAlias(), String.join(",", departmentSet));
            averageRecord.put(salaryCustomDto.getDateAlias(), String.join(",", monthSet));
            salaryByFilter.add(averageRecord);
        }
    }

    /**
     * 获取员工薪资数据，并根据年月-员工好聚合
     * @param salaryCustomDto
     * @return
     */
    private List<Map<String,Object>> getSalaryGroupByNo(SalaryCustomDto salaryCustomDto) {
        List<Map<String,Object>> salaryByFuzzyName = null;

        List<String> columns = getActiveColumns();
        String tableName = getSalaryTableName(salaryCustomDto.getYear());
        if (Integer.parseInt(salaryCustomDto.getYear()) > salaryMetaMapper.getLatestVersion()) {
            tableName = getLatestSalaryTableName();
        }

        if (salaryCustomDto.getMonth() != null && !"".equals(salaryCustomDto.getMonth())) {
            // 精准查询条件，根据年月查询
            salaryCustomDto.setDate(salaryCustomDto.getYear()+"-"+salaryCustomDto.getMonth());
            salaryByFuzzyName = salaryMapper.getSalaryByFuzzyNameAndYearAndMonth(columns, salaryCustomDto, tableName);
        } else {
            // 如果没有输入月份，则按照月份聚合年度数据
            salaryByFuzzyName = salaryMapper.getSalaryByFuzzyNameAndYear(columns, salaryCustomDto, tableName);
            List<Map<String,Object>> aggregationRecords = aggregationByYear(salaryCustomDto, columns, salaryByFuzzyName);
            salaryByFuzzyName = aggregationRecords;
        }

        return salaryByFuzzyName;
    }

    /**
     * 根据年份对每个用户的数据进行聚合
     * @param salaryCustomDto
     * @param columns
     * @param salaryByFuzzyName
     */
    private List<Map<String,Object>> aggregationByYear(SalaryCustomDto salaryCustomDto, List<String> columns, List<Map<String,Object>> salaryByFuzzyName) {
        String year = salaryCustomDto.getYear();
        String employeeNo = salaryCustomDto.getEmployeeNoAlias();
        String salaryDate = salaryCustomDto.getDateAlias();    // 设置月份为年
        Set<String> decimalColumns = getDecimalColumns();

        // 员工工号 与 记录建立哈希表，根据员工工号进行聚合
        Map<String, Map<String, Object>>  employeeNo2RecordMap = new HashMap<>();
        for (Map<String, Object> record : salaryByFuzzyName) {

            String no = record.get(employeeNo).toString();

            if (employeeNo2RecordMap.containsKey(no)) {
                Map<String, Object> originalRecord = employeeNo2RecordMap.get(no);
                decimalColumnsAdd(originalRecord, record, decimalColumns);

            } else {
                employeeNo2RecordMap.put(no, record);

            }
            Map<String, Object> realRecord = employeeNo2RecordMap.get(no);
            realRecord.put(salaryDate, year);
        }

        List<Map<String, Object>> aggregationRecords = employeeNo2RecordMap.values().stream().collect(Collectors.toList());

        return aggregationRecords;
    }

    /**
     * 将数值型的工资项聚合到originalRecord
     * @param originalRecord
     * @param record
     * @param decimalColumns
     */
    private void decimalColumnsAdd(Map<String,Object> originalRecord, Map<String,Object> record, Set<String> decimalColumns) {
        for (String column : decimalColumns) {
            java.math.BigDecimal originalValue = (java.math.BigDecimal) originalRecord.get(column);
            java.math.BigDecimal currentValue = (java.math.BigDecimal) record.get(column);
            originalRecord.put(column, originalValue.add(currentValue));
        }
    }

    private Set<String> getDecimalColumns() {
        Set<String> columns = salaryMetaMapper.getAllMeta()
                .stream()
                .filter(e -> (e.getStatus() == 1) && (e.getIsDecimal() == 1)) // 只过滤有效数据
                .map(e -> PinyinUtil.hanziToPinyin(e.getName(), "_"))
                .collect(Collectors.toSet());
//        if (columns != null && columns.size() > 0) columns.add(0, "id");
        return columns;
    }

    private List<String> getActiveColumns() {
        List<String> columns = salaryMetaMapper.getAllMeta()
                .stream()
                .filter(e -> e.getStatus() == 1) // 只过滤有效数据
                .map(e -> PinyinUtil.hanziToPinyin(e.getName(), "_"))
                .collect(Collectors.toList());
        if (columns != null && columns.size() > 0) columns.add(0, "id");
        return columns;
    }

    /**
     * 根据登录用户获取其部门可以查看的数据范围，为空时表示只可以查看自己的数据
     * @return
     */
//    private Set<String> getDepartmentNamePermission() {
//        List<Department> departmentList = new ArrayList<>();
//        LoginUser loginUser = SecurityUtil.getCurrentUser();
//
//        for (Role role : loginUser.getRoles()) {
//
//            String dataScopeCode = role.getDataScope();
//            if (ALL.getCode().equals(dataScopeCode)) {
//
//                departmentList = departmentMapper.getFuzzyDept(new Department());
//
//            } else if (CUSTOM.getCode().equals(dataScopeCode)) {
//
//                departmentList = roleDepartmentMapper.getDepartmentByRoleId(role.getId());
//
//            } else if (DEPT.getCode().equals(dataScopeCode)) {
//
//                departmentList.add(departmentMapper.getDeptById(loginUser.getDepartmentId()));
//
//            } else if (DEPT_AND_CHILD.getCode().equals(dataScopeCode)) {
//
//                departmentList = departmentMapper.selectChildrenDeptById(loginUser.getDepartmentId());
//
//            } else {
////                DataScope.SELF.getCode().equals(dataScopeCode)
//            }
//
//        }
//
//        return departmentList.stream().map(e -> e.getDeptName()).collect(Collectors.toSet());
//    }

    private Set<String> getDepartmentNoPermission() {

        List<Department> departmentList = new ArrayList<>();
        LoginUser loginUser = SecurityUtil.getCurrentUser();

        for (Role role : loginUser.getRoles()) {

            String dataScopeCode = role.getDataScope();
            if (ALL.getCode().equals(dataScopeCode)) {

                departmentList = departmentMapper.getFuzzyDept(new Department());

            } else if (CUSTOM.getCode().equals(dataScopeCode)) {

                departmentList = roleDepartmentMapper.getDepartmentByRoleId(role.getId());

            } else if (DEPT.getCode().equals(dataScopeCode)) {

                departmentList.add(departmentMapper.getDeptById(loginUser.getDepartmentId()));

            } else if (DEPT_AND_CHILD.getCode().equals(dataScopeCode)) {

                departmentList = departmentMapper.selectChildrenDeptById(loginUser.getDepartmentId());

            } else {
//                DataScope.SELF.getCode().equals(dataScopeCode)
            }

        }
        return departmentList.stream().map(e -> e.getNo()).collect(Collectors.toSet());
    }


    @Override
    public int deleteSalaryById(long id) {
        SalaryMeta salaryMeta = salaryMetaMapper.getById((int) id);
        return salaryMapper.deleteById(id, getSalaryTableName(salaryMeta.getVersion()));
    }

    public int deleteMeta(Integer id, boolean deleteSalary) {
        if (deleteSalary) {
            SalaryMeta salaryMeta = salaryMetaMapper.getById(id);
            String salaryColumn = PinyinUtil.hanziToPinyin(salaryMeta.getName(), "_");

            salaryMapper.deleteColumn(salaryColumn, getSalaryTableName(salaryMeta.getVersion()));
        }
        return salaryMetaMapper.deleteMetaById(id);
    }



    private String getLatestSalaryTableName() {
        Integer latestVersion = salaryMetaMapper.getLatestVersion();
        return getSalaryTableName(latestVersion.toString());
    }

    private String getSalaryTableName(String version) {
        return "salary_" + version;
    }

}
