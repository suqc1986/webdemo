package com.suqc.utils;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache implements Cache {
    private final String id;

    private static JedisConnectionFactory jedisConnectionFactory;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public RedisCache(final String id){
        if(id == null){
            throw new IllegalArgumentException("cache instances require an id");
        }
        this.id = id;
    }
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        System.out.println(">>>>>>>    putObject(Object key, Object value)    >>>>>>>key:"+key+"/value:"+value);
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            connection.set(serializer.serialize(key),serializer.serialize(value));
        } catch (SerializationException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public Object getObject(Object key) {
        System.out.println("<<<<<<<<<     getObject(Object key)     <<<<<<<<key:"+key);
        Object result = null;
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            result = serializer.deserialize(connection.get(serializer.serialize(key)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.close();
            }
        }
        return result;
    }

    @Override
    public Object removeObject(Object key) {
        System.out.println("xxxxxxx   removeObject(Object key)    xxxxxxxx   key:"+key);
        JedisConnection connection = null;
        Object result = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            result = connection.expireAt(serializer.serialize(key),0);
        } catch (SerializationException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.close();
            }
        }
        return result;
    }

    @Override
    public void clear() {
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            connection.flushDb();
            connection.flushAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public int getSize() {
        int size = 0;
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            size = Integer.valueOf(connection.dbSize().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.close();
            }
        }
        return size;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }
}
