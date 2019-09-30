package com.spring.redis.application.count.service.impl;

import com.spring.redis.application.count.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService {

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public long addOne(String key) {
        return redisTemplate.opsForValue().increment(key, 1);
    }

    @Override
    public String getCount(String key) {


        String a=redisTemplate.opsForValue().get("test") + "";
        return redisTemplate.opsForValue().get(key) + "";
    }
}
