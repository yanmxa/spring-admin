package com.nood.hrm.service.impl;

import com.nood.hrm.common.response.Response;
import com.nood.hrm.dto.UserDto;
import com.nood.hrm.mapper.RoleMapper;
import com.nood.hrm.mapper.RoleUserMapper;
import com.nood.hrm.mapper.UserMapper;
import com.nood.hrm.model.RoleUser;
import com.nood.hrm.model.User;
import com.nood.hrm.security.SpringSecurityConfig;
import com.nood.hrm.security.data.DataPermission;
import com.nood.hrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private SpringSecurityConfig securityConfig;

    @Override
    public User getUser(String username) {
        User user = null;
        if ("admin".equals(username)) user = userMapper.getUserByName(username);
        else user = userMapper.getUserByNo(username);
//        return userMapper.getUserByName(username);
        return user;
    }

    @Override
    @DataPermission(departmentAlias = "d", userAlias = "u")
    public Response<UserDto> getAllUserByPage(Integer offset, Integer limit, User user) {
//        List<UserDto> userDtos = userMapper.getAllUserByPage(offset, limit)
//                .stream()
//                .map(user -> {
//                    RoleUser roleUser = roleUserMapper.getRoleUserByUserId(user.getId().intValue());
//                    String roleName = roleMapper.getById(roleUser.getRoleId()).getName();
//                    UserDto userDto = (UserDto) user;
//                    userDto.setRoleName(roleName);
//                    return userDto;
//                })
//                .collect(Collectors.toList());


        List<UserDto> userDtos = userMapper.getAllUserDtoByPage(offset, limit, user);

        return Response.success(userMapper.countAllUsers().intValue(), userDtos);
    }

    @Override
    public Response<User> save(User user, Integer roleId) {

        User origionUser = getUserByNo(user.getNo());
        if (origionUser != null) return Response.failure("用户编号" + user.getNo() + "已经存在！");

//        User user = userService.getUserByPhone(userDto.getTelephone());
//        if (user != null && !user.getId().equals(userDto.getId())) {
//            return Response.failure(ResponseCode.PHONE_REPEAT.getCode(), ResponseCode.PHONE_REPEAT.getMessage());
//        }
        user.setStatus(1);
//        securityConfig.encoder().encode(User.defaultPassword);
        user.setPassword(securityConfig.encoder().encode(User.defaultPassword));
        userMapper.save(user);

        if (roleId != null) {
            RoleUser roleUser = new RoleUser();
            roleUser.setRoleId(roleId);
            roleUser.setUserId(user.getId().intValue());
            roleUserMapper.save(roleUser);
        }

        return Response.success("保存成功，默认密码为：" + User.defaultPassword);
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

//        User user = null;
//        user = userService.getUserByPhone(userDto.getTelephone());
//        if (user != null && !user.getId().equals(userDto.getId())) {
//            return Response.failure(ResponseCode.PHONE_REPEAT.getCode(), ResponseCode.PHONE_REPEAT.getMessage());
//        }

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
            return Response.failure(1, "用户不存在");
        }
        if (!securityConfig.encoder().matches(oldPassword, user.getPassword())) {
            return Response.failure(1,"旧密码错误");
        }
        userMapper.changePassword(user.getId(), securityConfig.encoder().encode(newPassword));
        return Response.success();

    }

    @Override
    public User getUserByNo(String no) {
        return userMapper.getUserByNo(no);
    }
}
