package com.czk.hope.util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhikang.chen
 * @description
 * @date 2019/12/22 17:08
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
     * 根据key获取
     * @param key
     * @return
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
