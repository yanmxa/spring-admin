package com.nood.hrm.mapper;

import com.nood.hrm.base.response.Response;
import com.nood.hrm.model.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {

    @Select("select * from sys_permission t")
    List<Permission> findAll();

    @Select("select p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId where rp.roleId = #{roleId} order by p.sort")
    List<Permission> listByRoleId(@Param("roleId") Integer i);

    @Select("select sp.* from sys_role_user sru " +
            "inner join sys_role_permission srp on sru.roleId = srp.roleId " +
            "left join sys_permission sp on srp.permissionId = sp.id " +
            "where sru.userId = #{userId}")
    List<Permission> listByUserId(Long userId);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into sys_permission(parentId, name, css, href, type, permission, sort) values(#{parentId}, #{name}, #{css}, #{href}, #{type}, #{permission}, #{sort})")
    int save(Permission permission);

    @Select("select * from sys_permission t where t.id = #{id}")
    Permission getById(Integer id);

    int update(Permission permission);

    @Delete("delete from sys_permission where id = #{id}")
    int deleteById(Integer id);

    @Delete("delete from sys_permission where parentId = #{parentId}")
    int deleteByParentId(@Param("parentId") Integer id);
}
