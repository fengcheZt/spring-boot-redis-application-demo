package com.spring.redis.application.count.interceptor;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

public class CounterInterceptor extends BaseInterceptor {
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = getRemoteHost(request);
        String key = ip + request.getRequestURI() + request.getSession().getId();
        Long increment = redisTemplate.opsForValue().increment(key, 1);
        if (increment == 1) {
            redisTemplate.expire(key, 60, TimeUnit.SECONDS);
        }
        if (increment > 5) {
            sendMsg(request, response, -1, "次数限制", request.getRequestURI());
            return false;
        }
        return true;
    }

    public String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip=request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }
}
