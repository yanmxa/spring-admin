package com.nood.hrm.service;

import com.nood.hrm.common.response.Response;
import com.nood.hrm.dto.RoleDto;
import com.nood.hrm.model.Role;


public interface RoleService {

    Response<Role> getAllRole();

    Response<Role> getAllRoleByPage(Integer offset, Integer limit);

    Response<Role> getRoleByFuzzyRoleName(String name, Integer offset, Integer limit);

    Response<Role> save(RoleDto roleDto);

    Role getRoleById(Integer roleId);

    Response<Role> update(RoleDto roleDto);

    Response<Role> delete(Integer id);

    Response authDataScope(RoleDto roleDto);
}
