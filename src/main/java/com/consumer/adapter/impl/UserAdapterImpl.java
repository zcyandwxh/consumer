//package com.consumer.adapter.impl;
//
//import com.biz.BizResult;
//import com.consumer.adapter.UserAdapter;
//import com.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *   
// * <p>描述</p>
// *
// * @author: 彗星（huixing@maihaoche.com）
// * @date: 2018/2/10 
// * @since V1.0
// *  
// */
//@Service
//public class UserAdapterImpl implements UserAdapter {
//
//    @Autowired
//    private UserService userService;
//
//    public BizResult<Integer> login(User user) {
//        BizResult<Integer> bizResult = userService.login(user);
//        return bizResult;
//    }
//
//}
