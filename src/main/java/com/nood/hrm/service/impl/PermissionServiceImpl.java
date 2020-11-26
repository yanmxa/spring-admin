package com.nood.hrm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.nood.hrm.base.response.Response;
import com.nood.hrm.mapper.PermissionMapper;
import com.nood.hrm.model.Permission;
import com.nood.hrm.service.PermissionService;
import com.nood.hrm.util.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;


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

}
