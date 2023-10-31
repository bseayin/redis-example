package com.xsz.jedis.example.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisClientListUtil {

    private static final Logger log = LoggerFactory.getLogger(RedisClientStringUtil.class);


    /**
     * 过key向list头部添加字符串
     * 返回值：执行 LPUSH 命令后，列表的长度
     * @param key
     * @return
     */
    public static Long lpush(String key, String... strs) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.lpush(key, strs);
        } catch (Exception e){
            log.error("lpush命令操作失败，参数key：{}，参数strs：{}", key, strs.toString(),e);
        }
        return null;
    }


    /**
     * 通过key向list尾部添加字符串
     * 返回值：执行 RPUSH 命令后，列表的长度
     * @param key
     * @return
     */
    public static Long rpush(String key, String... strs) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.rpush(key, strs);
        } catch (Exception e){
            log.error("rpush命令操作失败，参数key：{}，参数strs：{}", key, strs.toString(),e);
        }
        return null;
    }

    /**
     * 通过key设置list指定下标位置的value 如果下标超过list里面value的个数则报错
     * 返回值：操作成功返回 ok ，否则返回错误信息
     * @param key
     * @return
     */
    public static String lset(String key, Long index, String value) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.lset(key, index, value);
        } catch (Exception e){
            log.error("lset命令操作失败，参数key：{}，参数index：{}，参数value：{}", key, index, value,e);
        }
        return null;
    }


    /**
     * 通过key从对应的list中删除指定的count个 和 value相同的元素
     * 返回值：返回被删除的个数
     * @param key
     * @return
     */
    public static Long lrem(String key, long count, String value) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.lrem(key, count, value);
        } catch (Exception e){
            log.error("lrem命令操作失败，参数key：{}，参数count：{}，参数value：{}", key, count, value,e);
        }
        return null;
    }



    /**
     * 通过key保留list中从strat下标开始到end下标结束的value值
     * 返回值：操作成功返回 ok ，否则返回错误信息
     * @param key
     * @return
     */
    public static String ltrim(String key, long start, long end) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.ltrim(key, start, end);
        } catch (Exception e){
            log.error("ltrim命令操作失败，参数key：{}，参数start：{}，参数end：{}", key, start, end,e);
        }
        return null;
    }


    /**
     * 通过key从list的头部删除一个value,并返回该value
     * 返回值：value值
     * @param key
     * @return
     */
    public static String lpop(String key) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.lpop(key);
        } catch (Exception e){
            log.error("lpop命令操作失败，参数key：{}", key,e);
        }
        return null;
    }

    /**
     * 通过key从list尾部删除一个value,并返回该元素
     * 返回值：value值
     * @param key
     * @return
     */
    public static String rpop(String key) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.rpop(key);
        } catch (Exception e){
            log.error("rpop命令操作失败，参数key：{}", key,e);
        }
        return null;
    }


    /**
     * 通过key获取list中指定下标位置的value
     * 返回值：value值
     * @param key
     * @return
     */
    public static String lindex(String key, long index){
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.lindex(key, index);
        } catch (Exception e){
            log.error("lindex命令操作失败，参数key：{}，参数index：{}", key, index,e);
        }
        return null;
    }


    /**
     * 通过key返回list的长度
     * 返回值：value值
     * @param key
     * @return
     */
    public static Long llen(String key) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.llen(key);
        } catch (Exception e){
            log.error("llen命令操作失败，参数key：{}", key,e);
        }
        return null;
    }


    /**
     * 通过key获取list指定下标位置的value 如果start 为 0 end 为 -1 则返回全部的list中的value
     * 返回值：value值
     * @param key
     * @return
     */
    public static List<String> lrange(String key, long start, long end) {
        try (Jedis jedis = RedisPoolUtils.getJedis()) {
            return jedis.lrange(key, start, end);
        } catch (Exception e){
            log.error("lrange命令操作失败，参数key：{}，参数start：{}，参数end：{}", key, start, end,e);
        }
        return null;
    }

}
