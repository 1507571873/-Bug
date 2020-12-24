package com.shield.shiro;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shield.utils.ConstuntUtils;
import com.shield.utils.JedisUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.util.SerializationUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RedisCache<K, V> implements Cache<K, V> {

    private JedisUtils jedisUtils;
    private String prefix;

    public RedisCache(JedisUtils jedisUtils, String prefix) {
        this.jedisUtils = jedisUtils;
        this.prefix = prefix;
    }

    private byte[] getkey(K key) {
        if (key instanceof String) {
            return (prefix + key).getBytes();
        } else {
            Object obj = key;
            JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(obj));
            String userName = jsonObject.getJSONObject("primaryPrincipal").getString("userName");
            return (prefix + userName).getBytes();
        }

    }

    @Override
    public V get(K k) throws CacheException {
        try {
            if (k == null) {
                return null;
            }
            byte[] value = jedisUtils.get(getkey(k));
            return (V) SerializationUtils.deserialize(value);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    @Override
    public V put(K k, V v) throws CacheException {
        try {
            byte[] key = getkey(k);
            jedisUtils.set(key, SerializationUtils.serialize(v));
            jedisUtils.expire(key, ConstuntUtils.SESSION_TIMEOUT);
            return v;
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    @Override
    public V remove(K k) throws CacheException {
        V prev = get(k);
        jedisUtils.del(getkey(k));
        return prev;
    }

    @Override
    public void clear() throws CacheException {
        Set<byte[]> keys = jedisUtils.keys(prefix);
        for (byte[] key : keys) {
            jedisUtils.del(key);
        }
    }

    @Override
    public int size() {
        return jedisUtils.keys(prefix).size();
    }

    @Override
    public Set<K> keys() {
        Set<byte[]> keys = jedisUtils.keys(prefix);
        Set<K> setKs = new HashSet<>();
        for (byte[] key : keys) {
            setKs.add((K) SerializationUtils.deserialize(key));
        }
        return setKs;
    }

    @Override
    public Collection<V> values() {
        Set<byte[]> values = jedisUtils.values(prefix);
        Set<V> setKs = new HashSet<>();
        for (byte[] value : values) {
            setKs.add((V) SerializationUtils.deserialize(value));
        }
        return setKs;
    }

}
