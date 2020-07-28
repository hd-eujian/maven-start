package com.bootstart.maven;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class EujianRedisTemplate {

    private JedisPool pool;

    public EujianRedisTemplate(JedisPool pool) {
        this.pool = pool;
    }

    public String getString(String key){
        Jedis resource = pool.getResource();
        String o = resource.get(key);
        return o;
    }

    public void setString (String key,String object){
        Jedis resource = pool.getResource();
        resource.set(key,object);
    }

}
