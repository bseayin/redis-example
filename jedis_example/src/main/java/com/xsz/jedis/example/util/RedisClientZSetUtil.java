package com.xsz.jedis.example.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Set;
public class RedisClientZSetUtil {

    private static final Logger log = LoggerFactory.getLogger(RedisClientStringUtil.class);

    /**
     * 通过key向zset中添加value,score,其中score就是用来排序的 如果该value已经存在则根据score更新元素
     * 返回值：被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员
     * @param key
     * @return
     */
    public static Long zadd(String key, double score, String member) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.zadd(key, score, member);
        } catch (Exception e){
            log.error("zadd命令操作失败，参数key：{}，参数score：{}，参数member：{}", key, score, member,e);
        }
        return null;
    }


    /**
     * 通过key删除在zset中指定的value
     * 返回值：删除个数
     * @param key
     * @return
     */
    public static Long zrem(String key, String... members) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.zrem(key, members);
        } catch (Exception e){
            log.error("zrem命令操作失败，参数key：{}，参数members：{}", key, members.toString(),e);
        }
        return null;
    }


    /**
     * 通过key增加该zset中value的score的值
     * 返回值：member 成员的新分数值
     * @param key
     * @return
     */
    public static Double zincrby(String key, double score, String member) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.zincrby(key, score, member);
        } catch (Exception e){
            log.error("zincrby命令操作失败，参数key：{}，参数score：{}，参数member：{}", key, score, member,e);
        }
        return null;
    }

    /**
     * 通过key返回zset中value的排名 下标从小到大排序
     * 返回值：返回 member 的排名
     * @param key
     * @return
     */
    public static Long zrank(String key, String member) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.zrank(key, member);
        } catch (Exception e){
            log.error("zrank命令操作失败，参数key：{}，参数member：{}", key, member,e);
        }
        return null;
    }


    /**
     * 通过key将获取score从start到end中zset的value socre从大到小排序 当start为0 end为-1时返回全部
     * 返回值：返回 member 集合
     * @param key
     * @return
     */
    public static Set<String> zrevrange(String key, long start, long end) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.zrevrange(key, start, end);
        } catch (Exception e){
            log.error("zrevrange命令操作失败，参数key：{}，参数start：{}，参数end：{}", key, start, end,e);
        }
        return null;
    }

    /**
     * 返回指定区间内zset中value的数量
     * 返回值：返回 member 集合
     * @param key
     * @return
     */
    public static Long zcount(String key, String min, String max)  {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.zcount(key, min, max);
        } catch (Exception e){
            log.error("zcount命令操作失败，参数key：{}，参数min：{}，参数max：{}", key, min, max,e);
        }
        return null;
    }


    /**
     * 通过key返回zset中的value个数
     * 返回值：返回 member 集合
     * @param key
     * @return
     */
    public static Long zcard(String key)  {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.zcard(key);
        } catch (Exception e){
            log.error("zcard命令操作失败，参数key：{}", key,e);
        }
        return null;
    }


    /**
     * 返回满足pattern表达式的所有key keys(*) 返回所有的key
     * 返回值：返回 key 集合
     * @param pattern
     * @return
     */
    public static Set<String> keys(String pattern) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.keys(pattern);
        } catch (Exception e){
            log.error("keys命令操作失败，参数pattern：{}", pattern,e);
        }
        return null;
    }

    /**
     * 通过key判断值得类型
     * 返回值：值的类型
     * @param key
     * @return
     */
    public static String type(String key) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.type(key);
        } catch (Exception e){
            log.error("type命令操作失败，参数key：{}", key,e);
        }
        return null;
    }

}
