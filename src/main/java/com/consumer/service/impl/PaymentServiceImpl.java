package com.consumer.service.impl;

import com.consumer.bean.dto.PaymentRelationDTO;
import com.consumer.biz.BizResult;
import com.consumer.manager.PaymentManager;
import com.consumer.manager.PaymentRelationManager;
import com.consumer.model.PaymentRelation;
import com.consumer.service.PaymentService;
import com.util.PaymenyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *   
 * <p>结算服务实现</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/29 
 * @since V1.0
 *  
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentManager paymentManager;
    @Autowired
    private PaymentRelationManager paymentRelationManager;

    @Override
    @Transactional
    public BizResult<String> addPayment(List<PaymentRelationDTO> paymentRelations) {
        String paymentNo = PaymenyUtils.payment();
        List<PaymentRelation> paymentRelations1 = new ArrayList<>();
        paymentRelations.stream().forEach((x) -> {
            PaymentRelation paymentRelation = new PaymentRelation();
            Integer num = paymentManager.insertIntoPayment(paymentNo);
            if (Objects.isNull(num)) {
                throw new RuntimeException("插入结算单出错");
            }
            BeanUtils.copyProperties(x, paymentRelation);
            paymentRelations1.add(paymentRelation);
            paymentRelationManager.insertIntoPaymentRelation(paymentRelations1);
        });
        return BizResult.create(paymentNo);
    }

    @Override
    public BizResult<List<PaymentRelation>> findPayment(String patmentNo) {
        List<PaymentRelation> paymentRelationDTOS = paymentRelationManager.selectByPaymentNo(patmentNo);
        return BizResult.create(paymentRelationDTOS);
    }
}
