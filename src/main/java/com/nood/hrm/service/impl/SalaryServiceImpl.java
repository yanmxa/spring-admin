package com.nood.hrm.service.impl;

import com.nood.hrm.base.response.Response;
import com.nood.hrm.dto.SalaryItemDto;
import com.nood.hrm.mapper.SalaryMapper;
import com.nood.hrm.mapper.SalaryMetaMapper;
import com.nood.hrm.model.SalaryMeta;
import com.nood.hrm.service.SalaryService;
import com.nood.hrm.util.ExcelData;
import com.nood.hrm.util.ExcelUtil;
import com.nood.hrm.util.PinyinUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
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
import java.rmi.server.ExportException;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryMetaMapper salaryMetaMapper;

    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public Response<SalaryMeta> getAllMetaByPage(Integer offset, Integer limit) {

        return Response.success(
                salaryMetaMapper.countAll().intValue(),
                salaryMetaMapper.getAllMetaByPage(offset, limit));
    }

    @Override
    public Response<SalaryMeta> saveMeta(SalaryMeta salaryMeta) {

        int id = salaryMetaMapper.save(salaryMeta);

        updateSalaryStructure(null, salaryMeta);

        if (id < 0) return Response.failure();
        return Response.success();
    }

    @Override
    public SalaryMeta getById(Integer id) {
        return salaryMetaMapper.getById(id);
    }

    @Override
    public Response<SalaryMeta> updateMeta(SalaryMeta salaryMeta) {

        SalaryMeta originSalaryMeta = salaryMetaMapper.getById(salaryMeta.getId());
        if (!originSalaryMeta.getName().equals(salaryMeta.getName())) {
            String history = originSalaryMeta.getHistory();
            if (history == null) history = "";
            Set<String> historySet = Arrays.stream(history.split("  ")).collect(Collectors.toSet());
            if(!historySet.contains(originSalaryMeta.getName())) {
                history = originSalaryMeta.getName() + "  " + history;
                salaryMeta.setHistory(history);
            }
        }
        int count = salaryMetaMapper.updateSalaryMeta(salaryMeta);

        updateSalaryStructure(originSalaryMeta, salaryMeta);

        if (count < 0) Response.failure();
        return Response.success();
    }

    private void updateSalaryStructure(SalaryMeta originSalaryMeta, SalaryMeta salaryMeta) {
        String newName = PinyinUtil.hanziToPinyin(salaryMeta.getName(),"_");
        if (originSalaryMeta == null) {
            if (salaryMeta.getIsDecimal() == 1)
                salaryMapper.addDecimalColumn(newName, salaryMeta.getName());
            else
                salaryMapper.addVarcharColumn(newName, salaryMeta.getName());
        } else {
            // 修改原有字段的名字和commit : alter table <表名> change <字段名> <字段新名称> <字段的类型>
            String oldName = PinyinUtil.hanziToPinyin(originSalaryMeta.getName(),"_");
            if (salaryMeta.getIsDecimal() == 1)
                salaryMapper.update2DecimalColumn(oldName, newName, salaryMeta.getName());
            else
                salaryMapper.update2VarcharColumn(oldName, newName, salaryMeta.getName());
        }

    }

    @Override
    public void downLoadSalaryMeta(HttpServletResponse response) {
        List<SalaryMeta> salaryMetaList = salaryMetaMapper.getAllMeta();
        List<String> heads = salaryMetaList
                .parallelStream().filter(e -> e.getStatus() == 1).sorted((o1, o2) -> o1.getId().compareTo(o2.getId())).map(e -> e.getName()).collect(Collectors.toList());

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

//        return salaryMetaMapper.deleteMetaById(id);
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
                        if (index2Numeric.get(cellNum) == 1)
                            column2record.put(index2Column.get(cellNum), row.getCell(cellNum).getNumericCellValue());
                        else
                            column2record.put(index2Column.get(cellNum), row.getCell(cellNum).getStringCellValue());
                    }
//                    System.out.println(column2record);
                    salaryMapper.insertWithMap(column2record);
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
    public List<SalaryItemDto> getSalaryTableHead() {
        List<SalaryItemDto> headers = salaryMetaMapper.getAllMeta()
                .stream()
                .filter(e -> e.getStatus() == 1)
                .sorted((o1, o2) -> o1.getSort().compareTo(o2.getSort()))
                .map(e -> new SalaryItemDto(PinyinUtil.hanziToPinyin(e.getName(), "_"), e.getName()))
                .collect(Collectors.toList());
        return headers;
    }

    @Override
    public Response getSalaryTable(Integer offset, Integer limit) {

        int count = salaryMapper.countAll().intValue();
        List<String> columns = salaryMetaMapper.getAllMeta().stream()
                .map(e -> PinyinUtil.hanziToPinyin(e.getName(), "_"))
                .collect(Collectors.toList());
        List<Map<String, Object>> datas = salaryMapper.getAllSalaryByPage(offset, limit, columns);

        return Response.success(count, datas);
    }


    public int deleteMeta(Integer id, boolean deleteSalary) {
        if (deleteSalary) {
            SalaryMeta salaryMeta = salaryMetaMapper.getById(id);
            String salaryColumn = PinyinUtil.hanziToPinyin(salaryMeta.getName(), "_");
            salaryMapper.deleteColumn(salaryColumn);
        }
        return salaryMetaMapper.deleteMetaById(id);
    }
}
