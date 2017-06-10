package com.htf.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.htf.domain.User;
import com.htf.model.RedisModel;
import com.htf.service.IRedisService;

/**
 * Created by Administrator on 2017/3/1 16:00.
 */
@Service
public class RedisServiceImpl extends IRedisService<RedisModel> {
    private static final String REDIS_KEY = "TEST_REDIS_KEY";

    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
    
    @Cacheable(value = "usercache")  
    public User getUser(String userCacha,String name){  
//        LogCore.BASE.debug("invoke persistent:{},{}", no, name);  
        return new User();  
    }  

}
