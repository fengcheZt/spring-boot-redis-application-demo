package com.spring.redis.application.count.service.impl;

import com.spring.redis.application.count.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CountServiceImpl implements CountService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public long addOne(String key) {
        return redisTemplate.opsForValue().increment(key, 1);
    }

    @Override
    public String getCount(String key) {
        stringRedisTemplate.opsForValue().set("TEST_STRING","stringRedisTemplate");
        String result= stringRedisTemplate.opsForValue().get("TEST_STRING");
        System.out.println("字符串："+result);
//        String a=redisTemplate.opsForValue().get("test").toString();
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public String sendVerifyCode(String mobile) {
        Long increment = redisTemplate.opsForValue().increment(mobile, 1);
        if (increment == 1) {
            redisTemplate.expire(mobile, 60, TimeUnit.SECONDS);
        }
        if (increment > 1) {
            return "每分钟只能发一次短信";
        }
        return "验证码已发送";
    }
}
