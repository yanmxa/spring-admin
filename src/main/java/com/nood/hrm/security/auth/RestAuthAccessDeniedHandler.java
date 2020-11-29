package com.nood.hrm.security.auth;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            AccessDeniedException e) throws IOException, ServletException {

        httpServletResponse.setStatus(httpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.sendRedirect("/403.html");
    }
}
