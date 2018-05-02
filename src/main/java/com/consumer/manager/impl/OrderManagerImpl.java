package com.consumer.manager.impl;

import com.consumer.bean.form.OrderForm;
import com.consumer.manager.OrderManager;
import com.consumer.mapper.ext.OrderExtMapper;
import com.consumer.model.Employee;
import com.consumer.model.Order;
import com.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *   
 * <p>订单管理</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/7 
 * @since V1.0
 *  
 */
@Component
public class OrderManagerImpl implements OrderManager {

    @Autowired
    private OrderExtMapper orderMapper;
    @Autowired
    private RedisUtil redisUtils;

    @Override
    public List<Order> findOrder(OrderForm orderForm) {
        return orderMapper.selectOrderByPage(orderForm);
    }

    @Override
    public Integer insertOrder(Order order) {
        order.setStatus(1);
        Employee employee = redisUtils.getUser();
        order.setBuyerId(employee.getId());
        order.setBuyerName(employee.getName());
        return orderMapper.insertSelective(order);
    }
}
