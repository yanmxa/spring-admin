package com.nood.hrm.security.auth;

import com.alibaba.druid.support.json.JSONUtils;
import com.nood.hrm.common.response.Response;
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
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtils.toJSONString(Response.failure(e.getMessage())));
        response.getWriter().flush();
    }

//    @Override
//    public void handle(
//            HttpServletRequest httpServletRequest,
//            HttpServletResponse httpServletResponse,
//            AccessDeniedException e) throws IOException, ServletException {
//
//        httpServletResponse.setStatus(httpServletResponse.SC_FORBIDDEN);
//        httpServletResponse.setCharacterEncoding("utf-8");
//        httpServletResponse.sendRedirect("/error/403.html");
//    }
}
