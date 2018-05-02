package com.consumer.manager;

import com.consumer.model.OrderProductRelation;

import java.util.List;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/5/1 
 * @since V1.0
 *  
 */
public interface OrderProductRelationManager {
    /**
     * 批量插入
     * @param orderProductRelations
     */
    void insertBatch(List<OrderProductRelation> orderProductRelations);

    /**
     * 查询订单细节
     * @param orderId
     * @return
     */
    List<OrderProductRelation> selectOrderDetail(String orderId);
}
