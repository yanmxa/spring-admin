package com.nood.hrm.mapper;

import com.nood.hrm.model.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    @Select("select * from sys_role t")
    List<Role> getAllUser();

    @Select("select count(*) from sys_role t")
    Long countAllRole();

    @Select("select * from sys_role order by id limit #{startPosition}, #{limit}")
    List<Role> getAllRoleByPage(@Param("startPosition") Integer offset, @Param("limit") Integer limit);

    @Select("select count(*) from sys_role t where t.name like '%${name}%'")
    Long countRoleByFuzzyRoleName(@Param("name") String roleName);

    @Select("select * from sys_role t where t.name like '%${name}%' order by t.id limit #{startPosition}, #{limit}")
    List<Role> getRoleByFuzzyRoleNameWithPage(@Param("name") String roleName,
                                              @Param("startPosition") Integer offset,
                                              @Param("limit") Integer limit);


    @Options(useGeneratedKeys = true, keyProperty = "id")  // 这个注释会将生成的ID传入到role上面
    @Insert("insert into sys_role(name, description, createTime, updateTime) values(#{name}, #{description}, now(), now())")
    int save(Role role);

    int saveRole(Role role);

    @Select("select * from hrm.sys_role t where t.id = #{id}")
    Role getById(Integer id);

    int update(Role role);

    @Delete("delete from sys_role where id = #{id}")
    int deleteById(Integer id);

    @Select("select r.* from sys_role r " +
            "inner join sys_role_user ru on ru.roleId = r.id " +
            "left join sys_user u on u.id = ru.userId " +
            "where u.id = #{id}")
    List<Role> getRoleByUserId(Long id);
}
