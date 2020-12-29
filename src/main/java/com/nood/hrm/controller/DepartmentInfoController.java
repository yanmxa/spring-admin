package com.nood.hrm.controller;

import com.nood.hrm.common.logger.aop.Log;
import com.nood.hrm.common.response.Response;
import com.nood.hrm.common.response.ResponseCode;
import com.nood.hrm.dto.DepartmentDto;
import com.nood.hrm.model.Department;
import com.nood.hrm.model.DeptInfo;
import com.nood.hrm.service.DepartmentInfoService;
import com.nood.hrm.util.UserConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("department")
@Api(tags = "系统：部门管理")
public class DepartmentInfoController {

    @Autowired
    private DepartmentInfoService departmentInfoService;

    @GetMapping(value = "/list")
    @ResponseBody
    @ApiOperation(value = "部门列表")
//    @PreAuthorize("hasAnyAuthority('dept:edit')")
    @Log("查询部门")
    public Response getDeptAll(){
        List<DeptInfo> deptAll = departmentInfoService.getDeptAll();
//        System.out.println(deptAll);
        return Response.success(deptAll.size(), deptAll);
    }


    @GetMapping("/build")
    @ResponseBody
    @ApiOperation(value = "绘制部门树")
//    @PreAuthorize("hasAnyAuthority('dept:add','dept:edit')")
    @Log("绘制部门树")
    public Response buildDeptAll(DepartmentDto departmentDto){
        List<DepartmentDto> deptAll =departmentInfoService.buildDeptAll();
        Response response = Response.success(ResponseCode.SUCCESS, deptAll);
        return response;
    }
//
    @GetMapping("/add")
    @ApiOperation(value = "添加部门页面")
//    @PreAuthorize("hasAnyAuthority('dept:add')")
    public String addDepartment(Model model){
        model.addAttribute("deptInfo",new DeptInfo());
        return "/dept/dept-add";
    }

    @PostMapping("/add")
    @ResponseBody
    @ApiOperation(value = "添加部门")
//    @PreAuthorize("hasAnyAuthority('dept:add')")
    @Log("添加部门")
    public Response<DeptInfo> saveDepartment(@RequestBody DeptInfo dept) {
        if (UserConstants.DEPT_NAME_NOT_UNIQUE.equals( departmentInfoService.checkDeptNameUnique(dept))) {
            return Response.failure("新增岗位'" + dept.getDeptName() + "'失败，岗位名称已存在");
        }
        return departmentInfoService.insertDept(dept);
    }

    @GetMapping(value = "/edit")
    @ApiOperation(value = "修改部门页面")
//    @PreAuthorize("hasAnyAuthority('dept:edit')")
    public String editDepartment(Model model, DeptInfo dept) {
        model.addAttribute("deptInfo", departmentInfoService.getDeptById(dept.getDeptId()));
        return "dept/dept-edit";
    }

    @PutMapping(value = "/save")
    @ResponseBody
    @ApiOperation(value = "修改部门")
//    @PreAuthorize("hasAnyAuthority('dept:edit')")
    @Log("修改部门")
    public Response updateDepartment(@RequestBody DeptInfo dept) {
        if (UserConstants.DEPT_NAME_NOT_UNIQUE.equals( departmentInfoService.checkDeptNameUnique(dept))) {
            return Response.failure("更新岗位'" + dept.getDeptName() + "'失败，岗位名称已存在");
        } else if (dept.getDeptParentId().equals(dept.getDeptId())) {
            return Response.failure("修改部门'" + dept.getDeptName() + "'失败，上级部门不能是自己");
        } else if (dept.getState().equals(UserConstants.DEPT_DISABLE)
                && departmentInfoService.selectNormalChildrenDeptById(dept.getDeptId()) > 0) {
            return Response.failure("该部门包含未停用的子部门！");
        }
        int i= departmentInfoService.updateDept(dept);
        if (i > 0) return Response.success("修改成功！");
        else return Response.failure("修改失败！");
    }

    /**
     * 用户状态修改
     */
    @Log("修改部门状态")
    @PutMapping("/changeStatus")
    @ResponseBody
    @ApiOperation(value = "修改部门状态")
//    @PreAuthorize("hasAnyAuthority('dept:edit')")
    public Response changeStatus(@RequestBody DeptInfo department) {
        int count = departmentInfoService.changeStatus(department);
//        return Result.judge(deptService.changeStatus(myDept),"修改");
        if (count > 0) return Response.success();
        else return Response.failure();
//        return Response.success();
    }



    @DeleteMapping(value = "/delete")
    @ResponseBody
    @ApiOperation(value = "删除部门")
//    @PreAuthorize("hasAnyAuthority('dept:del')")
    @Log("删除部门")
    public Response<Department> deleteDepartment(String deptId) {

        DeptInfo deptInfo = departmentInfoService.getDeptById(deptId);
        if (departmentInfoService.selectDeptCount(deptInfo.getDeptId()) > 1){
            return Response.failure("存在下级部门,不允许删除");
        }
        if (departmentInfoService.checkDeptExistUser(deptInfo.getDeptId())) {
            return Response.failure("部门存在用户,不允许删除");
        }
        int i = departmentInfoService.deleteDeptById(deptId);
        return Response.judge(i);
    }

    /**
     * 加载角色部门（数据权限）列表树
     */
    @GetMapping("/build/{roleId}")
    @ResponseBody
//    @ApiOperation(value = "通过id绘制部门树")
//    @PreAuthorize("hasAnyAuthority('role:add','role:edit')")
//    @MyLog("通过id绘制部门树")
    public Response deptTreeData(@PathVariable Integer roleId) {
        List<DepartmentDto> departmentDtos = departmentInfoService.roleDeptTreeData(roleId);
        return Response.success(ResponseCode.SUCCESS, departmentDtos);
    }


//    @RequestMapping("/findSelective")
//    @ResponseBody
//    public Response<DepartmentDto> findSelective(
//            @RequestParam(value="page", defaultValue="1")int pageNum,
//            @RequestParam(value="limit", defaultValue="5") int limit,
//            @RequestParam(value="departmentName", defaultValue="") String departmentName) throws Exception {
//
//        Department department = new Department();
//        department.setDeptName(departmentName);
//
//        List<DepartmentDto> departmentDtoList = departmentService.getDeptAll(department).stream().map(e -> {
//            DepartmentDto departmentDto = new DepartmentDto();
//            departmentDto.setId(e.getId());
//            departmentDto.setTitle(e.getDeptName());
//            return departmentDto;
//        }).collect(Collectors.toList());
//
////        //模糊查询，有多少个条件就接收多少个字段
////        Department department = new Department();
////        department.setId(departmentId);
////
////        //pageNum:起始页面  pageSize:每页的大小
////        PageHelper.startPage(pageNum,limit);
////        //查找条件，一定要紧跟在startPage后
////        list = departmentService.findSelective(department);
////        PageInfo pageResult = new PageInfo(list);
////
////        //设置前台需要的数据
////        DepartmentPages departmentPages = new DepartmentPages();
////        departmentPages.setCode(0);
////        departmentPages.setMsg("");
////        departmentPages.setCount((int) pageResult.getTotal());
////        departmentPages.setData(pageResult.getList());
////
////        return departmentPages;
//    }

}
