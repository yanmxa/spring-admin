package com.nood.hrm.security.user;

import com.nood.hrm.util.MD5Util;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
//        return MD5Util.encode((String)rawPassword);
        return MD5Util.md5b64((String)rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(MD5Util.md5b64((String)rawPassword));
    }
}
