package com.consumer.manager.impl;

import com.consumer.manager.PaymentManager;
import com.consumer.mapper.ext.PaymentExtMapper;
import com.consumer.model.Employee;
import com.consumer.model.Payment;
import com.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/29 
 * @since V1.0
 *  
 */
@Component
public class PaymentManagerImpl implements PaymentManager{
    @Autowired
    private PaymentExtMapper paymentExtMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public Integer insertIntoPayment(String paymentNo) {
        Payment payment = new Payment();
        payment.setPaymentNo(paymentNo);
        Employee employee = redisUtil.getUser();
        payment.setBuyerId(employee.getId());
        return paymentExtMapper.insertSelective(payment);
    }
}
