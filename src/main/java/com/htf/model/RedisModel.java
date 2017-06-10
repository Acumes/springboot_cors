package com.htf.model;

import java.io.Serializable;

/**
 */
public class RedisModel<T> implements Serializable {
	
    private String redisKey;//redis中的key
    private String Value;
    private T object;
    
    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}
	
    
}