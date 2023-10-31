package com.xsz.jedis.example.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class RedisClientHashUtil {

    private static final Logger log = LoggerFactory.getLogger(RedisClientStringUtil.class);


    /**
     * 通过key 和 field 获取指定的 value
     * 返回值：对应的value值
     * @param key
     * @return
     */
    public static String hget(String key, String field) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.hget(key, field);
        } catch (Exception e){
            log.error("hget命令操作失败，参数key：{}，参数field：{}", key, field,e);
        }
        return null;
    }

    /**
     * 通过key给field设置指定的值,如果key不存在,则先创建
     * 返回值：如果字段是哈希表中的一个新建字段，并且值设置成功，返回 1 ;如果哈希表中域字段已经存在且旧值已被新值覆盖，返回 0 。
     * @param key
     * @return
     */
    public static Long hset(String key, String field, String value) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.hset(key, field, value);
        } catch (Exception e){
            log.error("hset命令操作失败，参数key：{}，参数field：{}，参数value：{}", key, field, value,e);
        }
        return 0L;
    }


    /**
     * 通过key和field判断是否有指定的value存在
     * 返回值：true/false
     * @param key
     * @return
     */
    public static Boolean hexists(String key, String field) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.hexists(key, field);
        } catch (Exception e){
            log.error("hexists命令操作失败，参数key：{}，参数field：{}", key, field,e);
        }
        return false;
    }


    /**
     * 通过key返回field的数量
     * 返回值：field的数量
     * @param key
     * @return
     */
    public static Long hlen(String key) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.hlen(key);
        } catch (Exception e){
            log.error("hlen命令操作失败，参数key：{}", key,e);
        }
        return 0L;
    }


    /**
     * 通过key 删除指定的 field
     * 返回值：删除的数量
     * @param key
     * @return
     */
    public static Long hdel(String key, String... fields) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.hdel(key, fields);
        } catch (Exception e){
            log.error("hdel命令操作失败，参数key：{}，参数fields：{}", key, fields.toString(),e);
        }
        return 0L;
    }


    /**
     * 通过key返回所有的field
     * 返回值：field集合
     * @param key
     * @return
     */
    public static Set<String> hkeys(String key) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.hkeys(key);
        } catch (Exception e){
            log.error("hkeys命令操作失败，参数key：{}", key,e);
        }
        return null;
    }


    /**
     * 通过key获取所有的field和value
     * 返回值：map对象
     * @param key
     * @return
     */
    public static Map<String, String> hgetAll(String key) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.hgetAll(key);
        } catch (Exception e){
            log.error("hgetAll命令操作失败，参数key：{}", key,e);
        }
        return null;
    }
}