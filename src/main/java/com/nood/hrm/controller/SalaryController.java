package com.nood.hrm.controller;

import com.nood.hrm.common.logger.aop.Log;
import com.nood.hrm.common.request.TableRequest;
import com.nood.hrm.common.response.Response;
import com.nood.hrm.dto.SalaryCustomDto;
import com.nood.hrm.dto.SalaryMetaDto;
import com.nood.hrm.model.SalaryMeta;
import com.nood.hrm.service.SalaryService;
import com.nood.hrm.util.PinyinUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("salary")
@Slf4j
@Api(tags = "系统：薪酬管理")
public class SalaryController {

    @Qualifier("salaryServiceImpl")
    @Autowired
    private SalaryService salaryService;

    @GetMapping("/listMeta")
    @ResponseBody
    public Response<SalaryMeta> getMetaDataList(TableRequest tableRequest) {
        tableRequest.countOffset();
        return salaryService.getAllMetaByPage(tableRequest.getOffset(), tableRequest.getLimit());
    }

    @GetMapping(value = "/addMeta")
//    @PreAuthorize("hasAuthority('sys:user:add')")
    public String addMeta(Model model) {
        model.addAttribute("salaryMeta", new SalaryMeta());

        return "salary/salaryMeta-add";
    }

    @PostMapping(value = "/addMeta")
    @ResponseBody
//    @PreAuthorize("hasAuthority('sys:user:add')")
    @ApiOperation(value="添加字段")
    @Log("添加字段")
    public Response<SalaryMeta> saveMeta(SalaryMeta salaryMeta) {
        if (cannotUpdate(salaryMeta)) return Response.failure("该字段不可添加、更新及删除!");
        return salaryService.saveMeta(salaryMeta);
    }

    @GetMapping(value = "/editMeta")
    public String editMeta(Model model, SalaryMeta salaryMeta) {
        model.addAttribute(salaryService.getById(salaryMeta.getId()));
        return "salary/salaryMeta-add";
    }

    @PostMapping(value = "/updateMeta")
    @ResponseBody
//    @PreAuthorize("hasAuthority('sys:user:add')")
    @ApiOperation(value="更新字段")
    @Log("更新字段")
    public Response<SalaryMeta> updateMeta(SalaryMeta salaryMeta) {
        if (cannotUpdate(salaryMeta)) return Response.failure("该字段不可添加、更新及删除!");
        return salaryService.updateMeta(salaryMeta);
    }

    final String pattern = "yyyy-MM-dd";
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(pattern), true));
    }


    @RequestMapping(value = "/downloadSalaryMeta", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="下载薪酬数据模板")
    @Log("下载薪酬数据模板")
    public void downloadSalaryMeta(HttpServletResponse response) {
        salaryService.downLoadSalaryMeta(response);
    }

    @GetMapping(value = "/deleteMeta")
    @ResponseBody
    @ApiOperation(value="删除薪酬字段")
    @Log("删除薪酬字段")
    public Response deleteMeta(SalaryMeta salaryMeta) {

        if (cannotUpdate(salaryMeta.getId())) return Response.failure("该字段不可添加、更新及删除!");

        int count = salaryService.deleteMetaBy(salaryMeta.getId());
        if (count > 0) return Response.success();
        else return Response.failure();
    }

    @RequestMapping(value = "/deleteByIdList", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="批量删除薪酬字段")
    @Log("批量删除薪酬字段")
    public Response DeleteMetaByIdList(@RequestParam("idList") List<Integer> idList) {
        for (Integer id : idList) {

            if (cannotUpdate(id)) return Response.failure("该字段不可添加、更新及删除!");

            int count = salaryService.deleteMetaBy(id);
            if (count < 0) return Response.failure("删除失败");
        }
        return Response.success();
    }

    @GetMapping("/findSalaryMetaByFuzzyName")
    @ResponseBody
    public Response<SalaryMeta> findMetaByFuzzyName(TableRequest tableRequest, String name) {
        tableRequest.countOffset();
        return salaryService.getMetaByFuzzyName(name, tableRequest.getOffset(), tableRequest.getLimit());
    }


    @RequestMapping(value = "/upload", method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Response uploadExcel(@RequestParam("file") MultipartFile file) {
        return salaryService.updateSalary(file);
    }

    @RequestMapping(value = "/tableHead", method = RequestMethod.GET)
    @ResponseBody
    public List<SalaryMetaDto> getSalaryTableHead() {
        return salaryService.getSalaryTableHead();
    }





    @GetMapping(value = "/salaryTable")
    @ResponseBody
//    @PreAuthorize("hasAuthority('biz:salary:query')")
    public Response getSalaryTable(TableRequest tableRequest, SalaryCustomDto salaryCustomDto) {
        tableRequest.countOffset();
        return salaryService.getSalaryTable(tableRequest.getOffset(), tableRequest.getLimit(), salaryCustomDto);
    }

    @RequestMapping(value = "/deleteSalaryByIdList", method = RequestMethod.POST)
    @ResponseBody
//    @PreAuthorize("hasAuthority('biz:salary:del')")
    public Response DeleteSalaryByIdList(@RequestParam("idList") List<Integer> idList) {
        for (Integer id : idList) {
            int count = salaryService.deleteSalaryById(id.longValue());
            if (count < 0) return Response.failure("删除失败");
        }
        return Response.success();
    }


    private boolean cannotUpdate(SalaryMeta salaryMeta) {
        String columnName = PinyinUtil.hanziToPinyin(salaryMeta.getName(), "_");
        SalaryCustomDto salaryCustomDto = new SalaryCustomDto();

        if (columnName.equals(salaryCustomDto.departmentNameAlias) ||
                columnName.equals(salaryCustomDto.dateAlias) ||
                columnName.equals(salaryCustomDto.employeeNameAlias) ||
                columnName.equals(salaryCustomDto.employeeNoAlias) ||
                columnName.equals(salaryCustomDto.noAlias) ||
                columnName.equals(salaryCustomDto.actualIncomeAlisa)) {
            return true;
        }
        return false;
    }

    private boolean cannotUpdate(Integer metaId) {
        SalaryMeta salaryMeta = salaryService.getById(metaId);
        return cannotUpdate(salaryMeta);
    }

}
