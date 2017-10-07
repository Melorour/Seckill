# Springboot秒杀Demo

## 开发环境
- IntelliJ IDEA 2017 2.5
- Maven 3.3.9
- JDK 1.8.0_141
- MariaDB 10.2.8
- Redis 4.0.1

## 项目技术
- SpringBoot 1.5.7
- Thymeleaf 
- Mybatis
- Druid 1.1.3
- log4j2
- Jedis 2.9.0

## 项目资源
- Source Code:[Seckill-master.zip](https://github.com/redinw/Seckill/archive/master.zip)
- Export Package:[]
	>- 打包好的jar，在JDK配置好前提下，下载后双击运行。
	>- 浏览器地址栏输入：http://localhost:8080/seckill/list ,即可访问。

## 项目结构
```
├─java
│  └─org.redin.seckill
│     │  SeckillApplication.java
│     ├─config
│     │      Beans.java
│     ├─dao
│     │  │  SeckillMapper.java
│     │  │  SuccessKilledMapper.java
│     │  └─cache
│     │          RedisDao.java
│     ├─dto
│     │      Exposer.java
│     │      SeckillExecution.java
│     ├─enums
│     │      SeckillStateEnum.java 
│     ├─exception
│     │      RepeatKillException.java
│     │      SeckillClosedException.java
│     │      SeckillException.java  
│     ├─po
│     │      Seckill.java
│     │      SuccessKilled.java
│     ├─service
│     │  │  ISeckillService.java
│     │  │  
│     │  └─impl
│     │          SeckillServiceImpl.java   
│     ├─vo
│     │      SeckillResult.java
│     └─web
│            SeckillController.java
└─resources
    │  application.properties
    │  log4j2.xml
    ├─mapper
    │      SeckillMapper.xml
    │      SuccessKilledMapper.xml
    ├─sql
    │      procedure.sql
    │      schema.sql
    ├─static
    └─templates
            detail.html
            list.html
```
## 项目导入(IDEA)
- Import Project，找到解压后的Source Code
- Import project from external model -> Maven -> next...

## 其他
- [Spring-Boot干货系列](http://tengj.top/categories/springMVC%E5%B9%B2%E8%B4%A7%E7%B3%BB%E5%88%97/)
- [Druid Spring Boot Starter](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter)