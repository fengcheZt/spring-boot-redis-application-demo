# Redis 排行榜
## 排行榜功能是什么？
大多互联网网站都有排行榜功能的，如京东的月度销量榜单、商品按时间的上新排行榜等。Redis提供的有序集合（sorted set）数据类构能实现各种复杂的排行榜应用。
## 应用代码
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