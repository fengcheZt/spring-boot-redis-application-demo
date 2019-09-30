package com.spring.redis.application.count.service;

public interface CountService {
    long addOne(String key);
    String getCount(String key);
}
