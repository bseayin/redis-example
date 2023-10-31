package com.xsz.jedis.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Set;
public class RedisClientSetUtil {

    private static final Logger log = LoggerFactory.getLogger(RedisClientStringUtil.class);


    /**
     * 通过key向指定的set中添加value
     * 返回值：添加成功的个数
     * @param key
     * @return
     */
    public static Long sadd(String key, String... members)  {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.sadd(key, members);
        } catch (Exception e){
            log.error("sadd命令操作失败，参数key：{}，参数members：{}", key, members.toString(),e);
        }
        return null;
    }

    /**
     * 通过key删除set中对应的value值
     * 返回值：删除成功的个数
     * @param key
     * @return
     */
    public static Long srem(String key, String... members)  {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.srem(key, members);
        } catch (Exception e){
            log.error("srem命令操作失败，参数key：{}，参数members：{}", key, members.toString(),e);
        }
        return null;
    }

    /**
     * 通过key获取set中value的个数
     * 返回值：value的个数
     * @param key
     * @return
     */
    public static Long scard(String key) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.scard(key);
        } catch (Exception e){
            log.error("scard命令操作失败，参数key：{}", key,e);
        }
        return 0L;
    }


    /**
     * 通过key判断value是否是set中的元素
     * 返回值：true/false
     * @param key
     * @return
     */
    public static Boolean sismember(String key, String member) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.sismember(key, member);
        } catch (Exception e){
            log.error("sismember命令操作失败，参数key：{}，参数member：{}", key, member,e);
        }
        return false;
    }


    /**
     * 通过key获取set中所有的value
     * 返回值：所有的value
     * @param key
     * @return
     */
    public static Set<String> smembers(String key) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.smembers(key);
        } catch (Exception e){
            log.error("smembers命令操作失败，参数key：{}", key,e);
        }
        return null;
    }

}
