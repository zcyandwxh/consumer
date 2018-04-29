package com.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.consumer.bean.dto.ProductDTO;
import com.consumer.model.Employee;
import com.consumer.model.Product;
import com.consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 *   
 * <p>Redis工具类</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/2/6 
 * @since V1.0
 *  
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    private static String SESSIONIDKEY = "sessionIdKey";

    private static String PRODUCT = "product";

    /**
     * 从缓存获得用户
     * @.return
     */
    public Employee getUser(){
        ValueOperations<Object, Object> value = redisTemplate.opsForValue();
        String sessionId = getSessionId();
        String o = (String) value.get(sessionId);
        Employee employee = JSON.parseObject(o, Employee.class);
        return employee;
    }

    /**
     * 设置用户进入缓存
     * @param var0
     */
    public void set(String var0){
        String key = getSessionId();
        ValueOperations<Object, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, var0, 60, TimeUnit.MINUTES);
    }

    /**
     * 根据商品id 和 数量设置到redis中
     * @param id
     * @param num
     */
    public void setProduct(Long id, Integer num){
        ValueOperations<Object, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(id, num, 60, TimeUnit.MINUTES);
    }

    /**
     * 设置sessionid
     */
    private String setSessionId(){

        return null;
    }

    /**
     * 获取sessionid
     * @return
     */
    private String getSessionId(){
        ValueOperations<Object, Object> valueOperations = redisTemplate.opsForValue();
//        Object key = SESSIONIDKEY;
//        String sessionIDKey = (String) valueOperations.get(key);
//        if (StringUtils.isEmpty(sessionIDKey)) {
            return WebUtil.getSession();
//        }
//        return sessionIDKey.toString();
    }

    /**
     * 从缓存删除用户
     */
    public void delete() {
        redisTemplate.delete(getSessionId());
       // redisTemplate.delete();
    }
}
