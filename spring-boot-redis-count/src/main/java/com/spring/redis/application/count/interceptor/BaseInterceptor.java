package com.spring.redis.application.count.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseInterceptor extends HandlerInterceptorAdapter {
    public void sendMsg(HttpServletRequest request, HttpServletResponse response, int code, String msg, String data) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        //封装成返回给前端的固定格式
        ResponseMessage responseMessage = new ResponseMessage(code, msg, data);
        String jsonObject = JSONObject.toJSONString(responseMessage);
        PrintWriter out=null;
        try {
            out=response.getWriter();
            out.append(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }

        }
    }
}
