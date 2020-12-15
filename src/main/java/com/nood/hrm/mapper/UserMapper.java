package com.nood.hrm.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nood.hrm.dto.UserDto;
import com.nood.hrm.model.User;
import com.nood.hrm.security.user.LoginUser;
import oracle.jrockit.jfr.events.Bits;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
    @Insert("insert into sys_user(no, departmentId, username, password, nickname, headImgUrl, phone, telephone, email, birthday, sex, status, createTime, updateTime) " +
            "values(#{no}, #{departmentId}, #{username}, #{password}, #{nickname}, #{headImgUrl}, #{phone}, #{telephone}, #{email}, #{birthday}, #{sex}, #{status}, now(), now())")
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
    int changePassword(@Param("id") Long id, @Param("password") String password);



    @Select("select u.id, d.deptName, u.telephone, u.username, u.no, u.sex, u.status, r.name from sys_user u " +
            "left join sys_role_user ru on u.id = ru.userId " +
            "left join sys_department d on u.departmentId = d.id " +
            "inner join sys_role r on ru.roleId = r.id " +
            "where 1=1 ${user.params.dataScope} order by u.id limit #{startPosition}, #{limit}")
    @Results(id="userDtoMap", value = {
            @Result(property = "id", column = "id", id=true),
            @Result(property = "departmentId", column = "departmentId"),
            @Result(property = "username", column = "username"),
            @Result(property = "telephone", column = "telephone"),
            @Result(property = "no", column = "no"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "status", column = "status"),
            @Result(property = "departmentName", column = "deptName"),
            @Result(property = "roleName", column = "name")
    })
    List<UserDto> getAllUserDtoByPage(@Param("startPosition") Integer startPosition, @Param("limit") Integer limit,
                                      @Param("user") User user);

    @Select("select * from sys_user t where t.no = #{no}")
    User getUserByNo(String no);
}
