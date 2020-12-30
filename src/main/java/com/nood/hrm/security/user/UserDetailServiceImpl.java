package com.nood.hrm.security.user;

import com.nood.hrm.model.Role;
import com.nood.hrm.model.UserInfo;
import com.nood.hrm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        // actually the username is the userNo
//        User user = userService.getUser(userId);

        UserInfo userInfo = userInfoService.getUserById(userId);
        if ("admin".equals(userId)) userInfo = userInfoService.getUserByName(userId);

//        if ("admin".equals(userId)) userInfo = userInfoService.getUser(userId);


        if (userInfo == null) {
            throw new UsernameNotFoundException("工号 " + userId + " 不存在！");
        }
//        else if (userInfo == User.Status.DISABLED){
//            throw new LockedException("用户被锁定, 请联系管理员");
//        }

        //        BeanUtils.copyProperties(user, loginUser);

        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(userInfo.getUserid());
        loginUser.setUserName(userInfo.getNameCn());
        loginUser.setPassword(userInfo.getPassword());
        loginUser.setDepartmentId(userInfo.getDeptId());

        loginUser.setPermissions(userInfoService.getPermissionByUserId(loginUser.getUserId()));

        List<Role> roles = new ArrayList<>();
        Role role = userInfoService.getRoleByUserId(loginUser.getUserId());
        if (role != null) roles.add(role);
        loginUser.setRoles(roles);

        return loginUser;
    }

}
