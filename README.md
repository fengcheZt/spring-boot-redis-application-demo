# Spring Boot + Redis 应用场景实例

## 初衷
学习最好的巩固方式，就是不断的实践，使用。此Demo就是以此目的结合Spring Boot，加深Redis的学习。
## 什么是Redis?
1. 非关系型NoSql数据库
2. Redis数据操作主要在内存中进行，因此效率极高
3. 主要以key，value的形式存储数据，还支持很多其他数据结构，如字符串（string）,散列（hashs）,列表（lists）,集合（set），有序集合（sorted sets）等等。
4. 原子性，Redis单个操作都是要么全部成功，要么全部失败，这样保证单个操作的线程安全，多个操作也可以使用事务控制。
## 项目列表及简介
``` lua
spring-boot-redis-application-demo
├── spring-boot-redis-cache -- redis缓存应用
├── spring-boot-redis-count -- redis计数器
├── spring-boot-redis-lock -- redis实现分布式锁
├── spring-boot-redis-rank -- 使用redis的sorted set实现排序
└── spring-boot-redis-session -- redis实现分布式会话
```