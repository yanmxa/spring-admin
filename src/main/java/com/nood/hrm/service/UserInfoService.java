package com.nood.hrm.service;

import com.nood.hrm.common.response.Response;
import com.nood.hrm.dto.UserDto;
import com.nood.hrm.model.Permission;
import com.nood.hrm.model.Role;
import com.nood.hrm.model.User;
import com.nood.hrm.model.UserInfo;

import java.util.List;

public interface UserInfoService {

    UserInfo getUser(String username);

    Response<UserInfo> getAllUserByPage(Integer offset, Integer limit, UserInfo user);

    Response<UserInfo> save(UserInfo userInfo, Integer roleId);

//    User getUserByPhone(String phone);

    UserInfo getUserById(String id);

    Response<UserInfo> updateUser(UserInfo userDto, Integer roleId);

    int deleteUserById(String id);

    Response<UserInfo> getUserByFuzzyUsername(String username, Integer offset, Integer limit);

    Response<User> changePassword(String userid, String oldPassword, String newPassword);

//    User getUserByNo(String no);

    List<Permission> getPermissionByUserId(String userId);

    Role getRoleByUserId(String userId);

    UserInfo getUserByName(String userId);

}
