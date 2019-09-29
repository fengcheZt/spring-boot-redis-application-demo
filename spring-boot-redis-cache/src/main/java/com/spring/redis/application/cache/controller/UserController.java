package com.spring.redis.application.cache.controller;

import com.spring.redis.application.cache.entity.User;
import com.spring.redis.application.cache.service.UserService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "UserController", description = "redis测试缓存Controller")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("保存用户信息")
    @RequestMapping(value = "inserOrUpdate", method = RequestMethod.GET)
    @ResponseBody
    public User insertOrUpdate(@RequestBody User user){
        final User user1 = userService.saveOrUpdate(user);
        return user1;
    }
    @ApiOperation("获取用户信息")
    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@RequestBody Long userId){
        final User user1 = userService.get(userId);
        return user1;
    }
}
