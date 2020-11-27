package com.nood.hrm.controller;

import com.alibaba.fastjson.JSONArray;

import com.nood.hrm.base.response.Response;
import com.nood.hrm.dto.RoleDto;
import com.nood.hrm.model.Permission;
import com.nood.hrm.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("permission")
@Slf4j
public class PermissionController {
    @Autowired
    private PermissionService permissionService;


    @RequestMapping(value = "/listAllPermission", method = RequestMethod.GET)
    @ResponseBody
//    @PreAuthorize("hasAuthority('sys:menu:query')")
//    @ApiOperation(value = "获取所有权限值", notes = "获取所有菜单的权限值")//描述
    public Response<JSONArray> listAllPermission() {
        return permissionService.listAllPermission();
    }


    @RequestMapping(value = "/listAllPermissionByRoleId", method = RequestMethod.GET)
    @ResponseBody
//    @ApiOperation(value = "获取角色权限", notes = "根据角色Id去查询拥有的权限")//描述
    public Response<Permission> listAllPermissionByRoleId(RoleDto roleDto) {
        log.info(getClass().getName() + " : param =  " + roleDto);
        return permissionService.listByRoleId(roleDto.getId().intValue());
    }


    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    @ResponseBody
//    @ApiOperation(value = "获取菜单", notes = "获取用户所属角色下能显示的菜单")//描述
//    @ApiImplicitParam(name = "userId", value = "userId", required = true, dataType = "Long")
    public Response<Permission> getMenu(Long userId) {
//        System.out.println("========" + userId);
//        Long tempUserId = 1L;
        return permissionService.getMenu(1L);
    }

    @GetMapping(value = "/menuAll")
    @ResponseBody
    public Response getAllMenu() {
        return permissionService.getAllMenu();
    }

    @GetMapping(value = "/add")
    public String addPermission(Model model) {
        model.addAttribute("permission", new Permission());
        return "permission/permission-add";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public Response<Permission> savePermission(@RequestBody Permission permission) {
        return permissionService.save(permission);
    }

    @GetMapping(value = "/edit")
    public String editPermission(Model model, Permission permission) {
        model.addAttribute("permission", permissionService.getPermissionById(permission.getId()));
        return "permission/permission-add";
    }

    @PostMapping(value = "/edit")
    @ResponseBody
    public Response<Permission> updatePermission(@RequestBody Permission permission) {
        return permissionService.updatePermission(permission);
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public Response<Permission> deletePermission(Permission permission) {
        return permissionService.deleteById(permission.getId());
    }


}
