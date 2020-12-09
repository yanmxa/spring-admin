package com.nood.hrm.mapper;

import com.nood.hrm.model.RolePermission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionMapper {

    @Delete("delete from sys_role_permission where permissionId = #{permissionId}")
    int delete(RolePermission rolePermission);

    int save(@Param("roleId")Integer id, @Param("permissionIds") List<Long> permissionIds);

    @Delete("delete from sys_role_permission where roleId = #{roleId}")
    int deleteRolePermission(Integer roleId);

    @Select("select * from sys_role_permission where roleId = #{roleId}")
    List<RolePermission> getPermissionByRoleId(String roleId);
}
