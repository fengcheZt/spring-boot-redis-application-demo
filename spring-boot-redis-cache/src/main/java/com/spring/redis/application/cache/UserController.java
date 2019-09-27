package com.spring.redis.application.cache;

import com.spring.redis.application.cache.entity.User;
import com.spring.redis.application.cache.service.UserService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Api(tags = "UserController", description = "redis测试缓存Controller")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @ApiOperation("保存用户信息")
    @RequestMapping("inserOrUpdate")
    @ResponseBody
    public User insertOrUpdate(@RequestBody User user){
        final User user1 = userService.saveOrUpdate(user);
        return user1;
    }
}
