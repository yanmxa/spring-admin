package com.nood.hrm.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.nood.hrm.base.response.Response;
import com.nood.hrm.mapper.PermissionMapper;
import com.nood.hrm.mapper.RolePermissionMapper;
import com.nood.hrm.model.Permission;
import com.nood.hrm.service.PermissionService;
import com.nood.hrm.util.TreeUtil;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;


    @Override
    public Response<JSONArray> listAllPermission() {
        log.info(getClass().getName() + ".listAllPermission()");
        List<Permission> permissions = permissionMapper.findAll();

        JSONArray array = new JSONArray();
        log.info(getClass().getName() + ".setPermissionsTree(?,?,?)");
        TreeUtil.setPermissionsTree(0, permissions, array);
        return Response.success(array);
    }

    @Override
    public Response<Permission> listByRoleId(int i) {
        return Response.success(0, permissionMapper.listByRoleId(i));
    }

    @Override
    public Response getMenu(Long userId) {
        List<Permission> permissionList = permissionMapper.listByUserId(userId);
        List<Permission> permissions = permissionList.stream()
                .filter(permission -> permission.getType().equals(1))
                .collect(Collectors.toList());
        JSONArray array = new JSONArray();
        TreeUtil.setPermissionsTree(0, permissions, array);
        return Response.success(array);
    }

    @Override
    public Response<Permission> getAllMenu() {

        return Response.success(0, permissionMapper.findAll());
    }

    @Override
    public Response<Permission> save(Permission permission) {
        return (permissionMapper.save(permission) > 0) ? Response.success() : Response.failure();
    }

    @Override
    public Permission getPermissionById(Integer id) {
        Permission permission = permissionMapper.getById(id);
        return permission;
    }

    @Override
    public Response<Permission> updatePermission(Permission permission) {
        return (permissionMapper.update(permission) > 0) ? Response.success() : Response.failure() ;
    }

    @Override
    public Response<Permission> deleteById(Integer id) {
        permissionMapper.deleteById(id);
        permissionMapper.deleteByParentId(id);
        return Response.success();
    }

}
