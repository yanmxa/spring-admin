package com.nood.hrm.service;

import com.alibaba.fastjson.JSONArray;
import com.nood.hrm.base.response.Response;
import com.nood.hrm.model.Permission;

public interface PermissionService {
    Response<JSONArray> listAllPermission();

    Response<Permission> listByRoleId(int i);

    Response<Permission> getMenu(Long userId);

    Response<Permission> getAllMenu();

    Response<Permission> save(Permission permission);

    Permission getPermissionById(Integer id);

    Response<Permission> updatePermission(Permission permission);

    Response<Permission> deleteById(Integer id);
}
