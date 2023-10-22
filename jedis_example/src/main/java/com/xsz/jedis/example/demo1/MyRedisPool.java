package com.xsz.jedis.example.demo1;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class MyRedisPool {
    private JedisPool jedisPool;
    //实例化连接池
    public MyRedisPool() {
        this.jedisPool = new JedisPool();
    }
    //获取Redis连接资源，并确保在使用后归还
    public void execute(CallJedis caller){
        try(Jedis jedis = jedisPool.getResource()){
            caller.call(jedis);
        }
    }
}
