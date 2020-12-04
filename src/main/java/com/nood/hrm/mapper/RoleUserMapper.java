package com.nood.hrm.mapper;

import com.nood.hrm.model.RoleUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleUserMapper {

//    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into sys_role_user(userId, roleId) values(#{userId}, #{roleId})")
    int save(RoleUser roleUser);

    @Select("select * from sys_role_user t where t.userId = #{userId}")
    RoleUser getRoleUserByUserId(Integer userId);


    int updateRoleUser(RoleUser roleUser);

    @Delete("delete from sys_role_user where userId = #{userId}")
    int deleteByUserId(int userId);

    @Select("select * from sys_role_user t where t.roleId = #{roleId}")
    List<RoleUser> listAllRoleUserByRoleId(Integer id);
}
