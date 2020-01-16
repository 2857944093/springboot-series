package com.czk.hope.util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author zhikang.chen
 * @description
 * @date 2019/12/22 17:08
 * redis操作工具类
 */
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate template;

    /**
     * 存入缓存
     * @param key
     * @param value
     */
    public void setMap(String key, String value) {
        template.opsForValue().set(key, value);
    }

    /**
     * 设置过期时间
     * @param key
     */
    public void expire(String key) {
        template.expire(key,1, TimeUnit.MINUTES);
    }

    /**
     * 根据key获取
     * @param key
     * @return value
     */
    public String getMap(String key) {
        return template.opsForValue().get(key);
    }

    /**
     * 删除指定key
     * @param key
     * @return
     */
    public boolean delMap(String key) {
        return template.delete(key);
    }
}
