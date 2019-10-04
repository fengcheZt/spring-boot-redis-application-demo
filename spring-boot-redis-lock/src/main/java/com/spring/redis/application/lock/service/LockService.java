package com.spring.redis.application.lock.service;

/**
 * <p>
 *  分布式锁service
 * </p>
 *
 * @package: com.spring.redis.application.lock.service
 * @description:
 * @author: tao.zhang
 * @date: 2019/10/3
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 */
public interface LockService {
    String insertValue(String key,String value);
    String updateValue(String key,String value);
    boolean tryLock();
}
