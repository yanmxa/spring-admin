package com.nood.hrm.security.user;

import com.nood.hrm.mapper.PermissionMapper;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getUser(username);
        if (user == null) {
            throw new AuthenticationCredentialsNotFoundException("username " + username + " is not exist");
        } else if (user.getStatus() == User.Status.DISABLED){
            throw new LockedException("用户被锁定, 请联系管理员");
        }

        LoginUser loginUser = new LoginUser();

        BeanUtils.copyProperties(user, loginUser);
        loginUser.setPermissions(permissionMapper.listByUserId(user.getId()));


        return loginUser;
    }

}
