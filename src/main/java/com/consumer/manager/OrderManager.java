package com.consumer.manager;

import com.consumer.bean.form.OrderForm;
import com.consumer.model.Order;

import java.util.List;

/**
 *   
 * <p>订单管理接口</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/7 
 * @since V1.0
 *  
 */
public interface OrderManager {
    /**
     * 查询所有订单
     * @return
     */
    List<Order> findOrder(OrderForm orderForm);

    /**
     * 插入订单
     * @param order
     * @return
     */
    Integer insertOrder(Order order);
}
