package com.xsz.jedis.example.treeDemo2;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class TreeStorage {
    private Jedis jedis;
    private String treeKey;

    public TreeStorage(String host, int port, String treeKey) {
        this.jedis = new Jedis(host, port);
        this.treeKey = treeKey;
    }

    public void insertNode(String nodeId, String parentId, String data) {

        // 创建一个 Map 对象来存储键值对
        Map<String, String> hash = new HashMap<>();
        hash.put("id", nodeId);
        hash.put("parentId", parentId);
        hash.put("data", data);
        jedis.hmset(treeKey + ":" + nodeId, hash);
//        jedis.hsetall(treeKey + ":" + nodeId, hashBuilder.build());
    }

    public void updateNode(String nodeId, String data) {
        jedis.hset(treeKey + ":" + nodeId, "data", data);
    }

    public void deleteNode(String nodeId) {
        jedis.del(treeKey + ":" + nodeId);
    }

    public String getNodeData(String nodeId) {
        return jedis.hget(treeKey + ":" + nodeId, "data");
    }

    public static void main(String[] args) {
        TreeStorage treeStorage = new TreeStorage("localhost", 6379, "myTree");
        treeStorage.insertNode("1", "0", "root");
        treeStorage.insertNode("2", "1", "node2");
        treeStorage.insertNode("3", "1", "node3");
        treeStorage.updateNode("2", "new data");
        String data = treeStorage.getNodeData("2"); // 返回 "new data"
        System.out.println(data);
        treeStorage.deleteNode("3");
    }
}
