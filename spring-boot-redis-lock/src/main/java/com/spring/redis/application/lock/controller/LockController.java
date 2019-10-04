package com.spring.redis.application.lock.controller;

import com.spring.redis.application.lock.service.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  分布式锁controller
 * </p>
 *
 * @package: com.spring.redis.application.lock.controller
 * @description:
 * @author: tao.zhang
 * @date: 22:10
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 */
@Controller
@RequestMapping("/lock")
public class LockController {

    @Autowired
    private LockService lockService;
    @RequestMapping(value = "/insertValue",method = RequestMethod.PUT)
    @ResponseBody
    public String insertValue(String key,String value){
        return lockService.insertValue(key, value);
    }
    @RequestMapping(value = "/updateValue",method = RequestMethod.PUT)
    @ResponseBody
    public String updateValue(String key,String value){
        return lockService.updateValue(key, value);
    }
}
