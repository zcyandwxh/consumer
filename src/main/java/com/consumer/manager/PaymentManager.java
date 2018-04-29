package com.consumer.manager;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/29 
 * @since V1.0
 *  
 */
public interface PaymentManager {

    /**
     * 插入结算单
     * @param paymentNo
     * @return
     */
    Integer insertIntoPayment(String paymentNo);
}
