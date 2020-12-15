package com.nood.hrm.service;

import com.nood.hrm.common.response.Response;
import com.nood.hrm.model.RoleUser;

public interface RoleUserService {
    Response<RoleUser> getRoleUserByUserId(Integer userId);
}
