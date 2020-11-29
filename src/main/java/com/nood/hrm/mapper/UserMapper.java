package com.nood.hrm.mapper;

import com.nood.hrm.model.User;
import oracle.jrockit.jfr.events.Bits;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from sys_user t where t.username = #{username}")
    User getUserByName(String username);

    @Select("select count(*) from sys_user t")
    Long countAllUsers();

    @Select("select * from sys_user t order by t.id limit #{startPosition}, #{limit}")
    List<User> getAllUserByPage(@Param("startPosition") Integer startPosition, @Param("limit") Integer limit);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into sys_user(username, password, nickname, headImgUrl, phone, telephone, email, birthday, sex, status, createTime, updateTime) values(#{username}, #{password}, #{nickname}, #{headImgUrl}, #{phone}, #{telephone}, #{email}, #{birthday}, #{sex}, #{status}, now(), now())")
    int save(User user);

    @Select("select * from sys_user t where t.telephone = #{phone}")
    User getUserByPhone(String phone);

    @Select("select * from sys_user t where t.id = #{id}")
    User getUserById(Long id);

    int updateUser(User user);

    @Delete("delete from sys_user where id = #{userId}")
    int deleteByUserId(int userId);

    @Select("select count(*) from sys_user t where t.username like '%${username}%'")
    Long countUserByFuzzyUsername(@Param("username") String username);

    @Select("select * from sys_user t where t.username like '%${username}%' order by t.id limit #{startPosition}, #{limit}")
    List<User> getUserByFuzzyUsernameWithPage(@Param("username") String username,
                                              @Param("startPosition") Integer offset,
                                              @Param("limit") Integer limit);

    @Update("update sys_user t set t.password = #{password} where t.id = #{id}")
    int changePassword(Long id, String password);
}
