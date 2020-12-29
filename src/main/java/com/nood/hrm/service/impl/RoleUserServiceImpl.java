package com.nood.hrm.service.impl;

import com.nood.hrm.common.response.Response;
import com.nood.hrm.mapper.RoleUserMapper;
import com.nood.hrm.model.RoleUser;
import com.nood.hrm.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleUserServiceImpl implements RoleUserService {

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public Response<RoleUser> getRoleUserByUserId(String userId) {
        RoleUser roleUser = roleUserMapper.getRoleUserByUserId(userId);
        if (roleUser != null) {
            return Response.success(roleUser);
        } else {
            return Response.success();
        }
    }
}
