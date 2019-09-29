package com.spring.redis.application.rank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RankConfig {
    @Bean(value = "selfRedisTemplate")
    public RedisTemplate<String, String> stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate redis = new StringRedisTemplate();
        redis.setConnectionFactory(redisConnectionFactory);

        // 设置redis的String/Value的默认序列化方式
        DefaultSerializer stringRedisSerializer = new DefaultSerializer();
        redis.setKeySerializer(stringRedisSerializer);
        redis.setValueSerializer(stringRedisSerializer);
        redis.setHashKeySerializer(stringRedisSerializer);
        redis.setHashValueSerializer(stringRedisSerializer);

        redis.afterPropertiesSet();
        return redis;
    }
}
