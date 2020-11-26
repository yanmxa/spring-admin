package com.nood.hrm.controller;

import com.nood.hrm.base.request.TableRequest;
import com.nood.hrm.base.response.Response;
import com.nood.hrm.dto.RoleDto;
import com.nood.hrm.model.Role;
import com.nood.hrm.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("role")
@Slf4j
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
    public Response<Role> saveRole(@RequestBody RoleDto roleDto) {
        log.info(roleDto.getId() + " " + roleDto.getName()+ " - " + roleDto.getDescription() + " " + roleDto.getPermissionIds());
        return roleService.save(roleDto);
    }

    @GetMapping(value = "/edit")
    public String editRole(Model model, Role role) {
        model.addAttribute("role", roleService.getRoleById(role.getId()));
        return "role/role-edit";
    }

    @PostMapping(value = "/edit")
    @ResponseBody
    public Response updateRole(@RequestBody RoleDto roleDto) {
        return roleService.update(roleDto);
    }

    @GetMapping(value = "/delete")
    @ResponseBody
//    @PreAuthorize("hasAuthority('sys:role:del')")
//    @ApiOperation(value = "删除角色信息", notes = "删除角色信息")//描述
    public Response<Role> deleteRole(RoleDto roleDto) {
        log.info("role id " + roleDto.getId());
        return roleService.delete(roleDto.getId());
    }


}
