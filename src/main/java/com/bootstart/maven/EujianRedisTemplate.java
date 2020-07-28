package com.bootstart.maven;

import org.springframework.cglib.core.internal.Function;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class EujianRedisTemplate {

    private JedisPool pool;

    public EujianRedisTemplate(JedisPool pool) {
        this.pool = pool;
    }

    public String getString(String key){
        String value = redisFun(jedis -> {
            return jedis.get(key);
        });
        return value;
    }

    public void setString (String key,String object){
        redisFun(jedis -> {
            jedis.set(key,object);
            return null;
        });
    }

    public <T>T redisFun (Function<Jedis,T> function){
        Jedis resource = pool.getResource();
        T apply = function.apply(resource);
        resource.close();
        return apply;
    }
}
