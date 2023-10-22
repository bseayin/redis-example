package com.xsz.jedis.example.demo1;

import redis.clients.jedis.Jedis;

public interface CallJedis {
    void call(Jedis jedis);
}
