package com.consumer.service;

import com.consumer.bean.dto.PaymentRelationDTO;
import com.consumer.biz.BizResult;
import com.consumer.model.PaymentRelation;

import java.util.List;

/**
 *   
 * <p>结算服务</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/29 
 * @since V1.0
 *  
 */
public interface PaymentService {
    /**
     * 结算
     * @param paymentRelations
     * @return
     */
    BizResult<String> addPayment(List<PaymentRelationDTO> paymentRelations);

    /**
     * 查询结算单
     * @param patmentNo
     * @return
     */
    BizResult<List<PaymentRelation>> findPayment(String patmentNo);
}
