package com.zeroscc.ruralcredit.modules.common.redis.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zeroscc.ruralcredit.modules.common.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author bool
 */
@Service
public class RedisServiceImpl implements RedisService {

    /**
     * 锁相关内容
     */
    private static final String lock = "locked";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 删除一个或多个缓存
     * @param key
     */
    @Override
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                List<?> objects = CollectionUtils.arrayToList(key);
                //转换成字符串
                Stream<String> stringStream = objects.stream().map(Object::toString);
                redisTemplate.delete(Arrays.toString(stringStream.toArray(String[]::new)));
            }
        }
    }

    @Override
    public JSONObject getJson(String key) {
        String json = this.get(key);

        if(!StringUtils.isBlank(json)){
            return JSON.parseObject(json);
        }

        return null;
    }

    @Override
    public String getString(String key) {
        return get(key);
    }


    /**
     * 获得一个锁
     *
     * @param key
     * @return
     */
    @Override
    public boolean tryLock(String key, Long ms) {
        // 获得一个50毫秒的锁
        return redisTemplate.opsForValue().setIfAbsent(key, lock, ms, TimeUnit.MILLISECONDS);
    }

    /**
     * 获取缓存内容
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    /**
     * 设置缓存值
     *
     * @param key
     * @param data
     * @return
     */
    @Override
    public boolean set(String key, String data) {
        try {
            redisTemplate.opsForValue().set(key, data);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 设置缓存
     *
     * @param key
     * @param value
     * @param time
     * @return
     */
    @Override
    public boolean set(String key, String value, Long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                this.set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
