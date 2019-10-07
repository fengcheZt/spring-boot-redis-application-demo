# Redis 分布式会话
## 什么是分布式会话？
集群模式下，在应用不多的情况下一般使用容器自带的session复制功能就能满足，当应用增多相对复杂的系统中，一般都会搭建以Redis等内存数据库为中心的session服务，session不再由容器管理，而是由session服务及内存数据库管理。
## 应用代码
该Demo主要使用Spring Session来实现
可以参考官方用例：https://docs.spring.io/spring-session/docs/current/reference/html5/guides/boot-redis.html
代码在application.yml中配置了
```
spring:
  session:
    store-type: redis
    redis:
      flush-mode: immediate
      namespace: "spring:session"
```
主要根据store-type的值指定session存储，官网给出解释：  
> Under the hood, Spring Boot applies configuration that is equivalent to manually adding @EnableRedisHttpSession annotation. This creates a Spring bean with the name of springSessionRepositoryFilter that implements Filter. The filter is in charge of replacing the HttpSession implementation to be backed by Spring Session.  
 
增加了这个配置后，就等同于在java配置文件中增加@EnableRedisHttpSession。
## 测试
1. 打开浏览器，访问首页：http://localhost:8080/demo/page/index
2. 最开始未登录，所以会跳转到登录页：http://localhost:8080/demo/page/login?redirect=true 然后点击登录按钮
3. 登录之后，跳转回首页，此时可以看到首页显示token信息。
4. 重启程序。不关闭浏览器，直接刷新首页，此时不跳转到登录页。测试成功！

## 参考
该项目参考xkcoding的spring-boot-demo学习项目，https://github.com/xkcoding/spring-boot-demo/tree/master/spring-boot-demo-session