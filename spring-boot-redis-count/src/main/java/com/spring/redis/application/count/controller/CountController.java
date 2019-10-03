package com.spring.redis.application.count.controller;

import com.spring.redis.application.count.service.CountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "CountController",description = "计数器")
@Controller
@RequestMapping("/count")
public class CountController {
    @Autowired
    private CountService countService;

    @ApiOperation("计数器加一")
    @RequestMapping(value = "/addOne",method = RequestMethod.POST)
    @ResponseBody
    public long addOne(String key){
       return countService.addOne(key);
    }

    @ApiOperation("获得计数器的值")
    @RequestMapping(value = "/getCount",method = RequestMethod.GET)
    @ResponseBody
    public String getCount(String key){
        return countService.getCount(key);
    }

    @ApiOperation("短信验证码请求次数限制")
    @RequestMapping(value = "/sendVerifyCode",method = RequestMethod.GET)
    @ResponseBody
    public String sendVerifyCode(String mobile){
        return countService.sendVerifyCode(mobile);
    }
}
