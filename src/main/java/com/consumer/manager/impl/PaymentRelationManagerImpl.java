package com.consumer.manager.impl;

import com.consumer.bean.dto.PaymentRelationDTO;
import com.consumer.manager.PaymentRelationManager;
import com.consumer.mapper.ext.PaymentRelationMapperExt;
import com.consumer.model.PaymentRelation;
import com.consumer.model.PaymentRelationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@Component
public class PaymentRelationManagerImpl implements PaymentRelationManager {

    @Autowired
    private PaymentRelationMapperExt paymentMapper;

    @Override
    public void insertIntoPaymentRelation(List<PaymentRelation> paymentRelations) {
        for (PaymentRelation payment : paymentRelations) {
            paymentMapper.insertSelective(payment);
        }
    }

    @Override
    public List<PaymentRelation> selectByPaymentNo(String patmentNo) {
        PaymentRelationExample paymentRelationExample = new PaymentRelationExample();
        PaymentRelationExample.Criteria criteria = paymentRelationExample.createCriteria();
        criteria.andPaymentNoEqualTo(patmentNo);
        return paymentMapper.selectByExample(paymentRelationExample);
    }
}
