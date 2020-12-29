package com.nood.hrm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.nood.hrm.common.response.Response;
import com.nood.hrm.dto.MenuDto;
import com.nood.hrm.mapper.PermissionMapper;
import com.nood.hrm.mapper.RolePermissionMapper;
import com.nood.hrm.model.Permission;
import com.nood.hrm.service.PermissionService;
import com.nood.hrm.util.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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
    public Response getMenu(String userId) {

        List<Permission> permissionList = permissionMapper.listByUserId(userId);

        permissionList.sort((o1, o2) -> o1.getSort().compareTo(o2.getSort()));

        List<Permission> permissions = permissionList.stream()
                .filter(permission -> permission.getType().equals(1))
                .collect(Collectors.toList());
        JSONArray array = new JSONArray();
        TreeUtil.setPermissionsTree(0, permissions, array);
        return Response.success(array);
    }

    @Override
    public Response<Permission> getAllMenu() {
        List<Permission> allPermissions = permissionMapper.findAll();
        allPermissions.sort((o1, o2) -> o1.getSort().compareTo(o2.getSort()));
        return Response.success(0,allPermissions);
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


    @Override
    public List<MenuDto> buildMenu(String roleId) {

        if (roleId == null || roleId == "") return permissionMapper.buildAllMenu();

        Set<Integer> permissionIds = rolePermissionMapper.getPermissionByRoleId(roleId)
                .stream()
                .map(e -> e.getPermissionId())
                .collect(Collectors.toSet());

        return permissionMapper.buildAllMenu()
                .stream()
                .map(e -> {
                    if (permissionIds.contains(e.getId())) e.setCheckArr("1");
                    return e;
                }).collect(Collectors.toList());
    }

    @Override
    public List<MenuDto> buildMenuByPermissionId(String id) {

        Map<Integer, Integer> id2ParentId = new HashMap<>();
        List<Permission> permissions = permissionMapper.findAll();
        Set<Integer> checkedId = new HashSet<>();
        permissions.forEach(e -> id2ParentId.put(e.getId(), e.getParentId()));

        Integer bottomId = Integer.parseInt(id);
        checkedId.add(bottomId);
        while (id2ParentId.containsKey(bottomId)) {
            bottomId = id2ParentId.get(bottomId);
            checkedId.add(bottomId);
        }

        return permissionMapper.buildAllMenu()
                .stream()
                .map(e -> {
                    if (checkedId.contains(e.getId())) e.setCheckArr("1");
                    return e;
                }).collect(Collectors.toList());
    }

}
