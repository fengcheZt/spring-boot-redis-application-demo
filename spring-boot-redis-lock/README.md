# Redis 分布式锁
## 为什么要用分布式锁
什么是计数器，如电商网站商品的浏览量、视频网站视频的播放数等。为了保证数据实时效，每次浏览都得给+1，并发量高时如果每次都请求数据库操作无疑是种挑战和压力。Redis提供的incr命令来实现计数器功能，内存操作，性能非常好，非常适用于这些计数场景。

## 应用
该应用提供插入和更新功能，插入一个值，然后启动两个应用实例，同时更新一个值，看看发生什么。
```
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
```