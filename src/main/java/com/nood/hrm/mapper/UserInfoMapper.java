package com.nood.hrm.mapper;

import com.nood.hrm.dto.UserDto;
import com.nood.hrm.model.User;
import com.nood.hrm.model.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {

    @Select("select * from SD_UserInfo t where t.NameCn = #{NameCn}")
    UserInfo getUserByName(String NameCn);

    @Select("select * from apps.SD_UserInfo t where t.Userid = #{userId}")
    UserInfo getUserById(String userId);

    @Select("select count(1) from SD_UserInfo t")
    Long countAllUsers();

//    @Select("select * from sys_user t order by t.id limit #{startPosition}, #{limit}")
//    List<User> getAllUserByPage(@Param("startPosition") Integer startPosition, @Param("limit") Integer limit);


    @Options(useGeneratedKeys = true, keyProperty = "Userid")
    @Insert("insert into SD_UserInfo(Userid, DeptId, DeptName, NameCn, Password, NamePy, Gender, Education, OfficeTel, OfficeLocation, Title) " +
            "values(#{Userid}, #{DeptId}, #{DeptName}, #{NameCn}, #{Password}, #{NamePy}, #{Gender}, #{Education}, #{OfficeTel}, #{OfficeLocation}, #{Title})")
    int save(UserInfo user);

//    @Select("select * from sys_user t where t.telephone = #{phone}")
//    User getUserByPhone(String phone);

//    @Select("select * from sys_user t where t.id = #{id}")
//    User getUserById(Long id);

    int updateUser(UserInfo userInfo);

    @Delete("delete from SD_UserInfo where Userid = #{userId}")
    int deleteByUserId(String userId);

    @Select("select count(1) from SD_UserInfo t where t.NameCn like '%${username}%'")
    Long countUserByFuzzyUsername(@Param("username") String username);

    @Select("select * from SD_UserInfo t where t.NameCn like '%${username}%' order by t.Userid limit #{startPosition}, #{limit}")
    List<UserInfo> getUserByFuzzyUsernameWithPage(@Param("username") String username,
                                              @Param("startPosition") Integer offset,
                                              @Param("limit") Integer limit);

//    @Update("update sys_user t set t.password = #{password} where t.id = #{id}")
//    int changePassword(@Param("id") Long id, @Param("password") String password);



//    @Select("select u.id, d.deptName, u.telephone, u.username, u.no, u.sex, u.status, r.name from sys_user u " +
//            "left join sys_role_user ru on u.id = ru.userId " +
//            "left join sys_department d on u.departmentId = d.id " +
//            "inner join sys_role r on ru.roleId = r.id " +
//            "where 1=1 ${user.params.dataScope} order by u.id limit #{startPosition}, #{limit}")
//    @Results(id="userDtoMap", value = {
//            @Result(property = "id", column = "id", id=true),
//            @Result(property = "departmentId", column = "departmentId"),
//            @Result(property = "username", column = "username"),
//            @Result(property = "telephone", column = "telephone"),
//            @Result(property = "no", column = "no"),
//            @Result(property = "sex", column = "sex"),
//            @Result(property = "status", column = "status"),
//            @Result(property = "departmentName", column = "deptName"),
//            @Result(property = "roleName", column = "name")
//    })
    @Select("select * from SD_UserInfo order by Userid limit #{startPosition}, #{limit}")
    List<UserInfo> getAllUserInfoByPage(@Param("startPosition") Integer startPosition, @Param("limit") Integer limit,
                                       @Param("user") UserInfo user);

//    @Select("select * from sys_user t where t.no = #{no}")
//    User getUserByNo(String no);

    @Select("select * from SD_UserInfo t where t.DeptId = #{DeptId}")
    List<UserInfo> getUserByDeptId(String DeptId);
}
