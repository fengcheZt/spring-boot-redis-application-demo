package com.spring.redis.application.lock.service.impl;

import com.spring.redis.application.lock.service.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  分布式锁service实现
 * </p>
 *
 * @package: com.spring.redis.application.lock.service.impl
 * @description:
 * @author: tao.zhang
 * @date: 2019/10/3
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 */
@Service
public class LockServiceImpl implements LockService {

    @Autowired
    private RedisTemplate redisTemplate;

    private final String LOCKVALUE = "lockvalue";
    @Override
    public String insertValue(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
        return "插入成功";
    }

    @Override
    public String updateValue(String key, String value) {
        //存在key返回false,表示被锁，不存在key则设置key返回true
        Boolean success=redisTemplate.opsForValue().setIfAbsent(key+"123", LOCKVALUE, 60, TimeUnit.SECONDS);
        if (success) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "更新失败";
            }
            redisTemplate.opsForValue().set(key,value);
            return "更新成功";
        }else{
            return "数据被锁";
        }

    }

    @Override
    public boolean tryLock() {
        return false;
    }
}
