package com.xsz.jedis.example.pool;

import com.xsz.jedis.example.util.RedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //获取 jedis 客户端
        Jedis jedis = RedisPoolUtils.getJedis();

        System.out.println("清空数据："+jedis.flushDB());
        System.out.println("判断某个键是否存在："+jedis.exists("username"));
        System.out.println("新增<'username','xmr'>的键值对："+jedis.set("username", "xmr"));
        System.out.println(jedis.exists("username"));
        System.out.println("新增<'password','password'>的键值对："+jedis.set("password", "123"));
        System.out.print("系统中所有的键如下：");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("删除键password:"+jedis.del("password"));
        System.out.println("判断键password是否存在："+jedis.exists("password"));
        System.out.println("设置键username的过期时间为5s:"+jedis.expire("username", 8L));
        TimeUnit.SECONDS.sleep(1);
        System.out.println("查看键username的剩余生存时间："+jedis.ttl("username"));
        System.out.println("移除键username的生存时间："+jedis.persist("username"));
        System.out.println("查看键username的剩余生存时间："+jedis.ttl("username"));
        System.out.println("查看键username所存储的值的类型："+jedis.type("username"));
        RedisPoolUtils.close(jedis);
    }
}
