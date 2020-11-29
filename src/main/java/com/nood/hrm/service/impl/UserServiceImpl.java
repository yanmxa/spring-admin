package com.nood.hrm.service.impl;

import com.nood.hrm.base.response.Response;
import com.nood.hrm.dto.UserDto;
import com.nood.hrm.mapper.RoleUserMapper;
import com.nood.hrm.mapper.UserMapper;
import com.nood.hrm.model.RoleUser;
import com.nood.hrm.model.User;
import com.nood.hrm.security.SpringSecurityConfig;
import com.nood.hrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public User getUser(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public Response<User> getAllUserByPage(Integer offset, Integer limit) {
        return Response.success(
                userMapper.countAllUsers().intValue(),
                userMapper.getAllUserByPage(offset, limit));
    }

    @Override
    public Response<User> save(User user, Integer roleId) {
        if (roleId != null) {

            userMapper.save(user);

            RoleUser roleUser = new RoleUser();
            roleUser.setRoleId(roleId);
            roleUser.setUserId(user.getId().intValue());
            roleUserMapper.save(roleUser);

            return Response.success();
        }

        return Response.failure();
    }

    @Override
    public User getUserByPhone(String phone) {

        return userMapper.getUserByPhone(phone);
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public Response<User> updateUser(UserDto userDto, Integer roleId) {

        if (roleId == null) {
            return Response.failure("roleId can not be empty!");
        }

        // user
        userMapper.updateUser(userDto);

        // user - role
        RoleUser roleUser = new RoleUser();
        roleUser.setRoleId(roleId);
        roleUser.setUserId(userDto.getId().intValue());

        if (roleUserMapper.getRoleUserByUserId(roleUser.getUserId()) != null) {
            roleUserMapper.updateRoleUser(roleUser);
        } else {
            roleUserMapper.save(roleUser);
        }
        return Response.success();

    }

    @Override
    public int deleteUserById(Long id) {

        roleUserMapper.deleteByUserId(id.intValue());

        return userMapper.deleteByUserId(id.intValue());
    }

    @Override
    public Response<User> getUserByFuzzyUsername(String username, Integer offset, Integer limit) {
        return Response.success(
                userMapper.countUserByFuzzyUsername(username).intValue(),
                userMapper.getUserByFuzzyUsernameWithPage(username, offset, limit));
    }

    @Override
    public Response<User> changePassword(String username, String oldPassword, String newPassword) {
        User user = userMapper.getUserByName(username);
        if (user == null) {
            return Response.failure("用户不存在");
        }
        if (!new BCryptPasswordEncoder().encode(oldPassword).equals(user.getPassword())) {
            return Response.failure("旧密码错误");
        }
        userMapper.changePassword(user.getId(), new BCryptPasswordEncoder().encode(newPassword));
        return Response.success();
    }
}
