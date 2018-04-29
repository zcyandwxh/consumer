package com.consumer.manager;

import com.consumer.model.PaymentRelation;

import java.util.List;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/29 
 * @since V1.0
 *  
 */
public interface PaymentRelationManager {

    /**
     * 插入结算单信息
     * @return
     */
    void insertIntoPaymentRelation(List<PaymentRelation> paymentRelations);

    /**
     * 查询结算单内容
     * @param patmentNo
     * @return
     */
    List<PaymentRelation> selectByPaymentNo(String patmentNo);
}
