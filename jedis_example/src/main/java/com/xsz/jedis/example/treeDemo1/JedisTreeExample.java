package com.xsz.jedis.example.treeDemo1;

import redis.clients.jedis.Jedis;
//import redis.clients.jedis.SetParams;

import java.util.Set;

public class JedisTreeExample {
    public static void main(String[] args) {
        // 创建 Jedis 连接
        Jedis jedis = new Jedis("localhost", 6379);

        // 存储根节点
        jedis.set("root", "root_id");

        // 存储其他节点
        jedis.set("node1", "node1_id");
        jedis.set("node1_1", "node1_1_id");
        jedis.set("node1_2", "node1_2_id");
        jedis.set("node2", "node2_id");
        jedis.set("node2_1", "node2_1_id");

        // 存储子节点关系
        jedis.sadd("node1_children", "node1_1_id", "node1_2_id");
        jedis.sadd("node2_children", "node2_1_id");

        // 查询子节点关系
        Set<String> node1Children = jedis.smembers("node1_children");
        System.out.println("Node 1 children: " + node1Children);

        // 关闭 Jedis 连接
        jedis.close();
    }
}
