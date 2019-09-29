package com.spring.redis.application.count.controller;

import com.spring.redis.application.count.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/count")
public class CountController {
    @Autowired
    private CountService countService;

    @RequestMapping("/addOne")
    public void addOne(){}
}
