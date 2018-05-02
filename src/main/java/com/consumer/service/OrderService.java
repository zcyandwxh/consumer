package com.consumer.service;

import com.consumer.bean.dto.OrderDTO;
import com.consumer.bean.dto.OrderDetail;
import com.consumer.bean.form.OrderForm;
import com.consumer.bean.form.ShopCartForm;
import com.consumer.biz.BizResult;
import com.consumer.biz.PageResult;

import java.util.List;

/**
 *   
 * <p>订单接口</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/7 
 * @since V1.0
 *  
 */
public interface OrderService {
    /**
     * 查询所有订单的信息
     * @return
     */
    BizResult<PageResult<List<OrderDTO>>> findOrder(OrderForm orderForm);

    /**
     * 创建订单并且删除购物车中内容
     * @param
     * @return
     */
    BizResult<String> createOrder(List<Long> ids);

    /**
     * 订单细节
     * @param orderId
     * @return
     */
    BizResult<List<OrderDetail>> findOrderDetail(String orderId);
}
