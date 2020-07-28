package com.bootstart.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableConfigurationProperties(EujianProperties.class)
public class AutoConfig {

    @Autowired
    private EujianProperties eujianProperties;

    @Bean
    public JedisPool jedisPool (){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool pool = new JedisPool(config, eujianProperties.getHost(), eujianProperties.getPort(), eujianProperties.getTimeout(), eujianProperties.getPassword());
        return pool;
    }


    @Bean
    public EujianRedisTemplate eujianJedis (JedisPool jedisPool){
        return new EujianRedisTemplate(jedisPool);
    }

}
