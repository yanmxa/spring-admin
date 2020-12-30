package com.nood.hrm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.nood.hrm.common.response.Response;
import com.nood.hrm.mapper.*;
import com.nood.hrm.model.*;
import com.nood.hrm.security.SpringSecurityConfig;
import com.nood.hrm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
@DS("user")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private DeptInfoMapper deptInfoMapper;


    @Autowired
    private SpringSecurityConfig securityConfig;

    @DS("user")
    @Override
    public UserInfo getUser(String userId) {
        UserInfo user = userInfoMapper.getUserById(userId);
        return user;
    }

    @Override
    @DS("master")
    public List<Permission> getPermissionByUserId(String userId) {
        List<Permission> permissionList = new ArrayList<>();
        Role role = getRoleByUserId(userId);

            List<RolePermission> rolePermissions = rolePermissionMapper.getPermissionByRoleId(role.getId().toString());
            for (RolePermission rolePermission : rolePermissions) {
                Permission permission = permissionMapper.getById(rolePermission.getPermissionId());
                permissionList.add(permission);
            }

        return permissionList;
    }

    @Override
    @DS("master")
    public Role getRoleByUserId(String userId) {
//        Set<Integer> roleIdSet = roleUserMapper.getRoleUserByUserId(userId).stream().map(e -> e.getRoleId()).collect(Collectors.toSet());
        RoleUser roleUser = roleUserMapper.getRoleUserByUserId(userId);
//        List<Role> roleList = new ArrayList<>();
////        roleIdSet.forEach(roleId -> {
////            Role role = roleMapper.getById(roleId);
////            roleList.add(role);
////        });
//        roleList.add();
        if (roleUser == null) return roleMapper.getById(8);
        return roleMapper.getById(roleUser.getRoleId());
    }

    @DS("user")
    @Override
    public UserInfo getUserByName(String name) {
        return userInfoMapper.getUserByName(name);
    }

    @Override
    @DS("user")
//    @DataPermission(departmentAlias = "d", userAlias = "u")
    public Response<UserInfo> getAllUserByPage(Integer offset, Integer limit, UserInfo user) {
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


        List<UserInfo> userDtos = userInfoMapper.getAllUserInfoByPage(offset, limit, user);
        userDtos.forEach(userInfo -> {
            Role role = getRoleByUserId(userInfo.getUserid());
            if (role != null) userInfo.setRoleName( role.getName());
            userInfo.setDeptName( getDeptNameByDeptId(userInfo.getDeptId()));
        });


        return Response.success(userInfoMapper.countAllUsers().intValue(), userDtos);
    }

    private String getDeptNameByDeptId(String deptId) {
        DeptInfo deptInfo = deptInfoMapper.getDeptById(deptId);
        if (deptInfo == null) return "无";
        return deptInfo.getDeptName();
    }

    @Override
    public Response<UserInfo> save(UserInfo user, Integer roleId) {

        UserInfo origionUser = getUserById(user.getUserid());
        if (origionUser != null) return Response.failure("用户编号" + user.getUserid() + "已经存在！");

//        User user = userService.getUserByPhone(userDto.getTelephone());
//        if (user != null && !user.getId().equals(userDto.getId())) {
//            return Response.failure(ResponseCode.PHONE_REPEAT.getCode(), ResponseCode.PHONE_REPEAT.getMessage());
//        }
//        user.setStatus(1);
//        securityConfig.encoder().encode(User.defaultPassword);
        user.setPassword(securityConfig.encoder().encode(User.defaultPassword));
        userInfoMapper.save(user);

        if (roleId != null) {
            RoleUser roleUser = new RoleUser();
            roleUser.setRoleId(roleId);
            roleUser.setUserId(user.getUserid());
            updateRoleUser(roleUser);
        }

        return Response.success("保存成功，默认密码为：" + User.defaultPassword);
    }

//    @Override
//    public User getUserByPhone(String phone) {
//
//        return userMapper.getUserByPhone(phone);
//    }

    @Override
    public UserInfo getUserById(String id) {
        return userInfoMapper.getUserById(id);
    }

    @Override
    public Response<UserInfo> updateUser(UserInfo userInfo, Integer roleId) {

//        User user = null;
//        user = userService.getUserByPhone(userDto.getTelephone());
//        if (user != null && !user.getId().equals(userDto.getId())) {
//            return Response.failure(ResponseCode.PHONE_REPEAT.getCode(), ResponseCode.PHONE_REPEAT.getMessage());
//        }

        if (roleId == null) {
            return Response.failure("roleId can not be empty!");
        }

        // user
        userInfoMapper.updateUser(userInfo);

        // user - role
        RoleUser roleUser = new RoleUser();
        roleUser.setRoleId(roleId);
        roleUser.setUserId(userInfo.getUserid());
//        System.out.println(userInfo);
//        System.out.println(roleUser);

        updateRoleUser(roleUser);

        return Response.success();
    }

    @DS("master")
    private void updateRoleUser(RoleUser roleUser) {
        if (roleUserMapper.getRoleUserByUserId(roleUser.getUserId()) != null) {
            roleUserMapper.updateRoleUser(roleUser);
        } else {
            roleUserMapper.save(roleUser);
        }
    }

    @Override
    public int deleteUserById(String id) {
        deleteRoleUserByUserId(id);
        return userInfoMapper.deleteByUserId(id);
    }

    @DS("master")
    private int deleteRoleUserByUserId(String id) {
        return roleUserMapper.deleteByUserId(id);
    }

    @Override
    public Response<UserInfo> getUserByFuzzyUsername(String username, Integer offset, Integer limit) {
        return Response.success(
                userInfoMapper.countUserByFuzzyUsername(username).intValue(),
                userInfoMapper.getUserByFuzzyUsernameWithPage(username, offset, limit));
    }

    @Override
    @DS("user")
    public Response changePassword(String userid, String oldPassword, String newPassword) {
        UserInfo user = userInfoMapper.getUserById(userid);
        if (user == null) {
            return Response.failure("用户不存在");
        }
        if (!securityConfig.encoder().matches(oldPassword, user.getPassword())) {
            return Response.failure("旧密码错误");
        }
        user.setPassword(securityConfig.encoder().encode(newPassword));
        userInfoMapper.updateUser(user);
        return Response.success();

    }


}
