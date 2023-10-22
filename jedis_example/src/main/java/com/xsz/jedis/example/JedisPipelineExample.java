package com.xsz.jedis.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

public class JedisPipelineExample {

    public static void main(String[] args) {
        // 创建Jedis对象并连接到Redis服务器
        Jedis jedis = new Jedis("localhost", 6379);

        // 创建pipeline对象
        Pipeline p = jedis.pipelined();

        // 向Redis服务器发送SET命令，将多个键值对存储到pipeline中
        for (int i = 0; i < 100; i++) {
            p.set(String.format("key%d", i), String.format("value%d", i));
        }

        // 执行pipeline中的命令并获取结果
        p.sync();

        // 从Redis服务器获取存储的键值对并输出结果
        for (int i = 0; i < 100; i++) {
            Response<String> response = p.get(String.format("key%d", i));
            System.out.println(String.format("key%d: %s", i, response.get()));
        }

        // 关闭pipeline和Jedis连接
        p.close();
        jedis.close();
    }
}