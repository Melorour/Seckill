package org.redin.seckill.config;

import org.redin.seckill.dao.cache.RedisDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Redinw
 * Description:
 */
@Configuration
public class Beans {

    @Bean
    public RedisDao redisDao(@Value("${spring.redis.host}") String ip, @Value("${spring.redis.port}") Integer port){
        return new RedisDao(ip,port);
    }
}