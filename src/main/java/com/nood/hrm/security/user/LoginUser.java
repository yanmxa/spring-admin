package com.nood.hrm.security.user;

import com.nood.hrm.model.Permission;
import com.nood.hrm.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class LoginUser extends User implements UserDetails {

    private List<Permission> permissions;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions.parallelStream()
                .filter(p -> !StringUtils.isEmpty(p.getPermission()))
                .map(p -> new SimpleGrantedAuthority(p.getPermission()))
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return getStatus() != Status.LOCKED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
