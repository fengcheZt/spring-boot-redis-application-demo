package com.spring.redis.application.session.interceptor;

import com.spring.redis.application.session.constants.Consts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute(Consts.SESSION_KEY) != null) {
            return true;
        }
        // 跳转到登录页
        String url = "/page/login?redirect=true";
        response.sendRedirect(request.getContextPath() + url);
        return false;
    }
}
