package com.nood.hrm.util;


import com.nood.hrm.common.response.ResponseCode;
import com.nood.hrm.security.user.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class SecurityUtil {

    /**
     * 获取系统用户名称
     *
     * @return 系统用户名称
     */
    public static String getCurrentUsername() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new CustomException(ResponseCode.FAIL.getCode(), "当前登录状态过期");
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
    /**
     * 取得当前用户登录IP, 如果当前用户未登录则返回空字符串.
     * 无用
     */
    public static String getCurrentUserIp() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new CustomException(ResponseCode.FAIL.getCode(), "当前登录状态过期");
        }
        Object details = authentication.getDetails();
        if (!(details instanceof WebAuthenticationDetails)) {
            return "";
        }
        WebAuthenticationDetails webDetails = (WebAuthenticationDetails) details;
        return webDetails.getRemoteAddress();
    }

    /**
     * 获取系统用户
     *
     * @return 系统用户名称
     */
    public static LoginUser getCurrentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new CustomException(ResponseCode.FAIL.getCode(), "当前登录状态过期");
        }
        LoginUser userDetails = (LoginUser) authentication.getPrincipal();
        return userDetails;
    }

}
