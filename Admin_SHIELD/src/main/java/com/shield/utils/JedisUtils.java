package com.shield.utils;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;


public class JedisUtils {
    @Resource
    private JedisPool jedisPool;

    private Jedis getResource(){
        return jedisPool.getResource();
    }
        //此处用的byte[]是因为存到数据库中是二进制的流文件
    //新增
    public byte[] set(byte[] key,byte[] value){
        Jedis jedis=getResource();
        try {
            jedis.set(key,value);
            return value;
        }finally {
            jedis.close();
        }
    }

    //设置超时时间
    public void expire(byte[] key,int t){
        Jedis jedis=getResource();
        try {
            jedis.expire(key,t);
        }finally {
            jedis.close();
        }
    }

    //读
    public byte[] get(byte[] key){
        Jedis jedis=getResource();
        try {
            return jedis.get(key);
        }finally {
            jedis.close();
        }
    }

    //删除
    public void del(byte[] key){
        Jedis jedis=getResource();
        try {
            jedis.del(key);
        }finally {
            jedis.close();
        }
    }


    //获取活跃的session
    public Set<byte[]> keys(String shiro_session_prefix){
        Jedis jedis=getResource();
        try {
            return jedis.keys((shiro_session_prefix + "*").getBytes());
        }finally {
            jedis.close();
        }
    }

    public Set<byte[]> values(String shiro_session_prefix){
        Jedis jedis=getResource();
        try {
            Set<byte[]> keys = jedis.keys((shiro_session_prefix + "*").getBytes());
            Set<byte[]> values = new HashSet<>();
            for (byte[] key:keys){
                values.add(get(key));
            }
            return values;
        }finally {
            jedis.close();
        }
    }
}
