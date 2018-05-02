package com.consumer.manager.impl;

import com.consumer.manager.OrderProductRelationManager;
import com.consumer.mapper.ext.OrderProductRelationExtMapper;
import com.consumer.model.OrderProductRelation;
import com.consumer.model.OrderProductRelationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class OrderProductRelationManagerImpl  implements OrderProductRelationManager{
    @Autowired
    private OrderProductRelationExtMapper orderProductRelationMapper;
    @Override
    public void insertBatch(List<OrderProductRelation> orderProductRelation) {
        orderProductRelationMapper.insertBatch(orderProductRelation);
    }

    @Override
    public List<OrderProductRelation> selectOrderDetail(String orderId) {
        OrderProductRelationExample orderProductRelationExample = new OrderProductRelationExample();
        OrderProductRelationExample.Criteria criteria = orderProductRelationExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        return orderProductRelationMapper.selectByExample(orderProductRelationExample);
    }
}
