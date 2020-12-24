package com.shield.shiro;

import com.shield.utils.ConstuntUtils;
import com.shield.utils.JedisUtils;
import org.apache.shiro.ShiroException;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.apache.shiro.util.Initializable;

import java.util.concurrent.ConcurrentHashMap;

public class RedisCacheManager implements CacheManager, Initializable, Destroyable {

    public String prefix= ConstuntUtils.prefix;
    public JedisUtils jedisUtils;
    private final ConcurrentHashMap<String, Cache> caches=new ConcurrentHashMap<String,Cache>();
    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        Cache cache=caches.get(name);
        if (cache == null){
            cache=new RedisCache(jedisUtils,prefix);
            caches.put(name,cache);
        }
        return cache;
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void init() throws ShiroException {

    }

    public JedisUtils getJedisUtils() {
        return jedisUtils;
    }

    public void setJedisUtils(JedisUtils jedisUtils) {
        this.jedisUtils = jedisUtils;
    }
}
