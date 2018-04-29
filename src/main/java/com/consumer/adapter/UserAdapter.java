package com.consumer.adapter;


import com.consumer.biz.BizResult;
import com.consumer.model.User;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/2/10 
 * @since V1.0
 *  
 */
public interface UserAdapter {
    BizResult<Integer> login(User user);
}
