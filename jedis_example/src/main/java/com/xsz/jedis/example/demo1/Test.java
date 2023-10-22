package com.xsz.jedis.example.demo1;

import redis.clients.jedis.Jedis;

public class Test {
    public static void main(String[] args) {
        //实例化连接池
        MyRedisPool myRedisPool = new MyRedisPool();
        //获取Redis连接资源，并确保在使用后归还
        myRedisPool.execute(new CallJedis() {
            @Override
            public void call(Jedis jedis) {
                //执行Redis相关业务...
                jedis.set("name","Johnny");
                System.out.println(jedis.get("name"));
            }
        });
    }
}

/**
 * 这样子，我们通过自己封装的Jedis连接池来获取并归还连接，避免了自己获取连接然后忘记归还的情况。但是每次使用都需要提供一个回调类来执行Redis代码，略显麻烦。这同样可以使用Java8提供的新特性Lambda表达式来简化代码，如下
 *
 *  public static void main(String[] args) {
 *      MyRedisPool myRedisPool = new MyRedisPool();
 *      myRedisPool.execute(jedis -> {
 *          //Redis相关业务...
 *          jedis.set("name","Johnny");
 *          System.out.println(jedis.get("name"));
 *      });
 *  }
 */
