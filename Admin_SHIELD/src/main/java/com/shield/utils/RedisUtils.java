package com.shield.utils;


import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;

@Component
public class RedisUtils {

    @Resource
    private JedisUtils jedisUtils;

    private byte[] getKey(String key){
        return key.getBytes();
    }
    private byte[] getValue(Object value){
        return SerializationUtils.serialize(value);
    }
    private Object getDesValue(byte[] value){
        return SerializationUtils.deserialize(value);
    }
    public void set(String key,Object value){
        jedisUtils.set(getKey(key),getValue(value));
    }
    public Object get(String key){
        byte[] value = jedisUtils.get(getKey(key));
        return getDesValue(value);
    }

    public void setExpire(String key,Object value){
        jedisUtils.set(getKey(key),getValue(value));
        jedisUtils.expire(getKey(key),ConstuntUtils.SESSION_TIMEOUT);
    }
}
