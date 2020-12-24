package com.shield.shiro;

import com.shield.utils.ConstuntUtils;
import com.shield.utils.JedisUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RedisSessionDao extends AbstractSessionDAO {

    @Resource
    private JedisUtils jedisUtils;
    //用户的session key
    private String shiro_session_prefix = ConstuntUtils.shiro_session_prefix;

    private byte[] getKey(String key) {
        return (shiro_session_prefix + key).getBytes();
    }

    //保存方法
    private void saveSession(Session session) {
        if (session != null && session.getId() != null) {
            byte[] key = getKey(session.getId().toString());
            //序列化
            byte[] value = SerializationUtils.serialize(session);
            jedisUtils.set(key, value);
            //设置超时时间
            jedisUtils.expire(key, ConstuntUtils.SESSION_TIMEOUT);
        }
    }

    /**
     * 新增
     *
     * @param session
     * @return
     */
    @Override
    protected Serializable doCreate(Session session) {
        //序列化 获取sessionID
        Serializable sessionId = generateSessionId(session);
        //将Shiro的session和框架的sessionId进行绑定
        assignSessionId(session, sessionId);
        //调用上边的保存方法 框架的sessionId替换Shiro的sessionId
        saveSession(session);
        return sessionId;
    }

    /**
     * 查
     *
     * @param sessionId
     * @return
     */
    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            return null;
        }
        //获取key值
        byte[] key = getKey(sessionId.toString());
        //通过key 获取value
        byte[] value = jedisUtils.get(key);
        //反序列化
        return (Session) SerializationUtils.deserialize(value);
    }

    /**
     * 修改
     *
     * @param session
     * @throws UnknownSessionException
     */
    @Override
    public void update(Session session) throws UnknownSessionException {
        saveSession(session);
    }


    /**
     * 删除
     *
     * @param session
     */
    @Override
    public void delete(Session session) {
        if (session == null || session.getId() == null) {
            return;
        }
        //获取key值
        byte[] key = getKey(session.getId().toString());
        jedisUtils.del(key);
    }

    /**
     * 获取存活的session信息
     *
     * @return
     */
    @Override
    public Collection<Session> getActiveSessions() {
        //获取所有的key值
        Set<byte[]> keys = jedisUtils.keys(shiro_session_prefix);
        //hashset可以过滤重复数据
        Set<Session> sessions = new HashSet<>();
        if (CollectionUtils.isEmpty(keys)) {
            return sessions;
        }
        for (byte[] key : keys) {
            //反序列化为session对象
            Session session = (Session) SerializationUtils.deserialize(jedisUtils.get(key));
            //放入session集合中
            sessions.add(session);
        }
        return sessions;
    }
}
