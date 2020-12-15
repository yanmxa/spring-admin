package com.nood.hrm.service.impl;

import com.nood.hrm.common.response.Response;
import com.nood.hrm.common.response.ResponseCode;
import com.nood.hrm.dto.RoleDto;
import com.nood.hrm.mapper.RoleDepartmentMapper;
import com.nood.hrm.mapper.RoleMapper;
import com.nood.hrm.mapper.RolePermissionMapper;
import com.nood.hrm.mapper.RoleUserMapper;
import com.nood.hrm.model.Role;
import com.nood.hrm.model.RoleUser;
import com.nood.hrm.service.RoleService;
import com.nood.hrm.util.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Autowired
    private RoleDepartmentMapper roleDepartmentMapper;

    @Override
    public Response<Role> getAllRole() {
        return Response.success(100, roleMapper.getAllUser());
    }

    @Override
    public Response<Role> getAllRoleByPage(Integer offset, Integer limit) {

        return Response.success(
                roleMapper.countAllRole().intValue(),
                roleMapper.getAllRoleByPage(offset, limit));
    }

    @Override
    public Response<Role> getRoleByFuzzyRoleName(String name, Integer offset, Integer limit) {
        return Response.success(
                roleMapper.countRoleByFuzzyRoleName(name).intValue(),
                roleMapper.getRoleByFuzzyRoleNameWithPage(name, offset, limit));
    }

    @Override
    public Response<Role> save(RoleDto roleDto) {
        // 1. 保存角色
        roleMapper.save(roleDto);
        List<Long> permissionIds = roleDto.getPermissionIds();

        // 2. 保存角色对应的权限
        if (!CollectionUtils.isEmpty(permissionIds)) {
            rolePermissionMapper.save(roleDto.getId(), permissionIds);
        }

        return Response.success();
    }

    @Override
    public Role getRoleById(Integer roleId) {
        return roleMapper.getById(roleId);
    }

    @Override
    public Response<Role> update(RoleDto roleDto) {
        List<Long> permissionIds = roleDto.getPermissionIds();
//        permissionIds.remove(0);

        // 1. 更新角色权限之前要删除该角色之前的所有权限
        rolePermissionMapper.deleteRolePermission(roleDto.getId());
        // 2. 添加新的权限
        if (!CollectionUtils.isEmpty(roleDto.getPermissionIds())) {
            rolePermissionMapper.save(roleDto.getId(), roleDto.getPermissionIds());
        }

        // 3. 更新role表
        Integer roleId = roleMapper.update(roleDto);
        return Response.judge(roleId);
    }

    @Override
    public Response<Role> delete(Integer id) {
        // 1. 没有关联user表，则级联删除role_permission, permission
        // 级联是cascade主表删除从表数据删除, restrict删除主表数据，从表数据报错，set null会设置成空值
        List<RoleUser> roleUsers = roleUserMapper.listAllRoleUserByRoleId(id);
        if (roleUsers.size() <= 0) {
            roleMapper.deleteById(id);
            return Response.success("the role has not any users");
        }

        // 2. 删除role数据
        return Response.failure(ResponseCode.USERNAME_REPEAT.USER_ROLE_NO_CLEAR.getCode(),ResponseCode.USERNAME_REPEAT.USER_ROLE_NO_CLEAR.getMessage());

    }

    @Override
    public Response authDataScope(RoleDto roleDto) {
        if (roleDto.getDataScope().equals(UserConstants.DATA_SCOPE_CUSTOM)){
            List<Integer> departmentIds = roleDto.getDepartmentIds();
//            departmentIds.remove(0L);
            roleDepartmentMapper.deleteRoleDeptByRoleId(roleDto.getId());
            if (!CollectionUtils.isEmpty(departmentIds)) {
                roleDepartmentMapper.save(roleDto.getId(), departmentIds);
            }
            roleMapper.update(roleDto);
        }else {
            roleMapper.update(roleDto);
            roleDepartmentMapper.deleteRoleDeptByRoleId(roleDto.getId());
        }
        return Response.success("更新成功");
    }

}
