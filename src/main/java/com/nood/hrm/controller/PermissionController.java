package com.nood.hrm.controller;

import com.alibaba.fastjson.JSONArray;

import com.nood.hrm.common.logger.aop.Log;
import com.nood.hrm.common.response.Response;
import com.nood.hrm.common.response.ResponseCode;
import com.nood.hrm.dto.MenuDto;
import com.nood.hrm.dto.RoleDto;
import com.nood.hrm.model.Permission;
import com.nood.hrm.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("permission")
@Slf4j
@Api(tags = "系统：权限管理")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;


    @GetMapping("/build")
    @ResponseBody
    @ApiOperation(value = "根据角色id获取菜单列表")
    public Response<List<MenuDto>> buildTreeByRoleId(String roleId) {


        List<MenuDto> menus = permissionService.buildMenu(roleId);

        return Response.success(ResponseCode.SUCCESS, menus);
    }

//    @GetMapping("/build")
//    @ResponseBody
//    public Response<List<MenuDto>> buildTreeByPermissionId(String id) {
//
//        List<MenuDto> menus = permissionService.buildMenuByPermissionId(id);
//
//        return Response.success(ResponseCode.SUCCESS, menus);
//    }



    @RequestMapping(value = "/listAllPermission", method = RequestMethod.GET)
    @ResponseBody
//    @PreAuthorize("hasAuthority('sys:menu:query')")
    @ApiOperation(value = "获取所有权限值", notes = "获取所有菜单的权限值")//描述
    public Response<JSONArray> listAllPermission() {
        return permissionService.listAllPermission();
    }


    @RequestMapping(value = "/listAllPermissionByRoleId", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取角色权限", notes = "根据角色Id去查询拥有的权限")//描述
    public Response<Permission> listAllPermissionByRoleId(RoleDto roleDto) {
        return permissionService.listByRoleId(roleDto.getId().intValue());
    }


    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取菜单", notes = "获取用户所属角色下能显示的菜单")//描述
//    @ApiImplicitParam(name = "userId", value = "userId", required = true, dataType = "Long")
    public Response<Permission> getMenu(String userId) {
        return permissionService.getMenu(userId);
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
    @ApiOperation(value = "保存添加权限")//描述
    @Log("添加权限")
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
    @ApiOperation(value = "更新权限")//描述
    @Log("更新权限")
    public Response<Permission> updatePermission(@RequestBody Permission permission) {
        return permissionService.updatePermission(permission);
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    @ApiOperation(value = "删除权限")//描述
    @Log("删除权限")
    public Response<Permission> deletePermission(Permission permission) {
        return permissionService.deleteById(permission.getId());
    }


}
