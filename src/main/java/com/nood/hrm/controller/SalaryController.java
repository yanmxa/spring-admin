package com.nood.hrm.controller;

import com.nood.hrm.base.request.TableRequest;
import com.nood.hrm.base.response.Response;
import com.nood.hrm.dto.SalaryConditionDto;
import com.nood.hrm.dto.SalaryMetaDto;
import com.nood.hrm.model.SalaryMeta;
import com.nood.hrm.service.SalaryService;
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
    public Response<SalaryMeta> saveMeta(SalaryMeta salaryMeta) {
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
    public Response<SalaryMeta> updateMeta(SalaryMeta salaryMeta) {
        return salaryService.updateMeta(salaryMeta);
    }

    final String pattern = "yyyy-MM-dd";
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(pattern), true));
    }


    @RequestMapping(value = "/downloadSalaryMeta", method = RequestMethod.GET)
    @ResponseBody
    public void downloadSalaryMeta(HttpServletResponse response) {
        salaryService.downLoadSalaryMeta(response);
    }

//
//    @PostMapping(value = "/edit")
//    @ResponseBody
//    public Response<User> updateUser(UserDto userDto, Integer roleId) {
//        User user = null;
//        user = userService.getUserByPhone(userDto.getTelephone());
//        if (user != null && !user.getId().equals(userDto.getId())) {
//            return Response.failure(ResponseCode.PHONE_REPEAT.getCode(), ResponseCode.PHONE_REPEAT.getMessage());
//        }
//        return userService.updateUser(userDto, roleId);
//    }
//
    @GetMapping(value = "/deleteMeta")
    @ResponseBody
    public Response deleteMeta(SalaryMeta salaryMeta) {
//        int count = salaryService.deleteMeta(salaryMeta, true);
        int count = salaryService.deleteMetaBy(salaryMeta.getId());
        if (count > 0) return Response.success();
        else return Response.failure();
    }

    @RequestMapping(value = "/deleteByIdList", method = RequestMethod.POST)
    @ResponseBody
    public Response DeleteMetaByIdList(@RequestParam("idList") List<Integer> idList) {
        for (Integer id : idList) {
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
    public Response getSalaryTable(TableRequest tableRequest, SalaryConditionDto salaryConditionDto) {
        tableRequest.countOffset();
        return salaryService.getSalaryTable(tableRequest.getOffset(), tableRequest.getLimit(), salaryConditionDto);
    }

    @RequestMapping(value = "/deleteSalaryByIdList", method = RequestMethod.POST)
    @ResponseBody
    public Response DeleteSalaryByIdList(@RequestParam("idList") List<Integer> idList) {
        for (Integer id : idList) {
            int count = salaryService.deleteSalaryById(id.longValue());
            if (count < 0) return Response.failure("删除失败");
        }
        return Response.success();
    }

}
