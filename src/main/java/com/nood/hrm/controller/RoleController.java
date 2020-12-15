package com.nood.hrm.controller;

import com.nood.hrm.common.logger.aop.Log;
import com.nood.hrm.common.request.TableRequest;
import com.nood.hrm.common.response.Response;
import com.nood.hrm.dto.RoleDto;
import com.nood.hrm.model.Role;
import com.nood.hrm.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("role")
@Slf4j
@Api(tags = "系统：角色管理")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    @ResponseBody
    public Response<Role> getAll() {

        log.info("RoleController.getAll()");
        return roleService.getAllRole();
    }


    @GetMapping("/list")
    @ResponseBody
    public Response<Role> list(TableRequest tableRequest) {

        tableRequest.countOffset();
        return roleService.getAllRoleByPage(tableRequest.getOffset(), tableRequest.getLimit());
    }

    @GetMapping("/findRoleByFuzzyRoleName")
    @ResponseBody
    @ApiOperation(value = "角色名称模糊查询")//描述
    @Log("角色名称模糊查询")
    public Response<Role> findRoleByFuzzyRoleName(TableRequest tableRequest, @RequestParam("roleName") String name) {

        tableRequest.countOffset();
        return roleService.getRoleByFuzzyRoleName(name, tableRequest.getOffset(), tableRequest.getLimit());
    }

    @GetMapping(value = "/add")
    public String addRole(Model model) {
        model.addAttribute("role",new Role());
        return "role/role-add";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    @ApiOperation(value = "保存角色")//描述
    @Log("保存角色")
    public Response<Role> saveRole(@RequestBody RoleDto roleDto) {
        log.info(roleDto.getId() + " " + roleDto.getName()+ " - " + roleDto.getDescription() + " " + roleDto.getPermissionIds());
        return roleService.save(roleDto);
    }

    @GetMapping(value = "/edit")
    public String editRole(Model model, Role role) {
        model.addAttribute("role", roleService.getRoleById(role.getId()));
        return "role/role-edit";
    }

    @PostMapping(value = "/update")
    @ResponseBody
    @ApiOperation(value = "更新角色")//描述
    @Log("更新角色")
    public Response updateRole(@RequestBody RoleDto roleDto) {
        return roleService.update(roleDto);
    }

    @GetMapping(value = "/delete")
    @ResponseBody
//    @PreAuthorize("hasAuthority('sys:role:del')")
    @ApiOperation(value = "删除角色信息", notes = "删除角色信息")//描述
    @Log("删除角色")
    public Response<Role> deleteRole(RoleDto roleDto) {
        return roleService.delete(roleDto.getId());
    }

    @GetMapping(value = "/dataScope")
    public String dataScope(Model model, RoleDto roleDto) {
        model.addAttribute("role", roleService.getRoleById(roleDto.getId()));
        return "role/role-dataScope";
    }

    @PutMapping(value = "/authDataScope")
    @ResponseBody
    @ApiOperation(value = "修改角色数据权限")
    @Log("修改角色权限")
    public Response uthDataScope(@RequestBody RoleDto roleDto) {

        return roleService.authDataScope(roleDto);
    }

}
