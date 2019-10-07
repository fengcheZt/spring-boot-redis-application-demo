# Redis 计数器
## 什么情况下使用Redis作计数器？
什么是计数器，如电商网站商品的浏览量、视频网站视频的播放数等。为了保证数据实时效，每次浏览都得给+1，并发量高时如果每次都请求数据库操作无疑是种挑战和压力。Redis提供的incr命令来实现计数器功能，内存操作，性能非常好，非常适用于这些计数场景。

## 三个小列子
1. 简单加一  
`redisTemplate.opsForValue().increment(key, 1)`  
2. 短信验证码请求次数限制，加一后，设置过期时间
```
    Long increment = redisTemplate.opsForValue().increment(mobile, 1);
    if (increment == 1) {
        redisTemplate.expire(mobile, 60, TimeUnit.SECONDS);
    }
    if (increment > 1) {
        return "每分钟只能发一次短信";
    }
    return "验证码已发送";
```
3. Ip访问次数限制，代码与短信验证大同小异，主要放到拦截器中实现
```
    String ip = getRemoteHost(request);
    String key = ip + request.getRequestURI() + request.getSession().getId();
    Long increment = redisTemplate.opsForValue().increment(key, 1);
    if (increment == 1) {
        redisTemplate.expire(key, 60, TimeUnit.SECONDS);
    }
    if (increment > 5) {
        sendMsg(request, response, -1, "次数限制", request.getRequestURI());
        return false;
    }
    return true;
```