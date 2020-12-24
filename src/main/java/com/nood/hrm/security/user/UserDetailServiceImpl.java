package com.nood.hrm.security.user;

import com.nood.hrm.mapper.PermissionMapper;
import com.nood.hrm.mapper.RoleMapper;
import com.nood.hrm.model.User;
import com.nood.hrm.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // actually the username is the userNo
        User user = userService.getUser(username);

        if (user == null) {
            throw new UsernameNotFoundException("工号 " + username + " 不存在！");
        } else if (user.getStatus() == User.Status.DISABLED){
            throw new LockedException("用户被锁定, 请联系管理员");
        }

        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(user, loginUser);

        loginUser.setPermissions(permissionMapper.listByUserId(user.getId()));
        loginUser.setRoles(roleMapper.getRoleByUserId(user.getId()));

        return loginUser;
    }

}
