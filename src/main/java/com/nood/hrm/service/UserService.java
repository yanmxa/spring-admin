//package com.nood.hrm.service;
//
//import com.nood.hrm.common.response.Response;
//import com.nood.hrm.dto.UserDto;
//import com.nood.hrm.model.User;
//
//public interface UserService {
//
//    User getUser(String username);
//
//    Response<UserDto> getAllUserByPage(Integer offset, Integer limit, User user);
//
//    Response<User> save(User user, Integer roleId);
//
//    User getUserByPhone(String phone);
//
//    User getUserById(Long id);
//
//    Response<User> updateUser(UserDto userDto, Integer roleId);
//
//    int deleteUserById(Long id);
//
//    Response<User> getUserByFuzzyUsername(String username, Integer offset, Integer limit);
//
//    Response<User> changePassword(String username, String oldPassword, String newPassword);
//
//    User getUserByNo(String no);
//}
