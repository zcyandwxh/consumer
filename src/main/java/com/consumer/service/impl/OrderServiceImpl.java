package com.consumer.service.impl;

import com.consumer.bean.dto.OrderDTO;
import com.consumer.bean.form.OrderForm;
import com.consumer.biz.BizResult;
import com.consumer.biz.PageResult;
import com.consumer.manager.OrderManager;
import com.consumer.model.Order;
import com.consumer.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 *   
 * <p>订单模块实现</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/7 
 * @since V1.0
 *  
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderManager orderManager;

    @Override
    public BizResult<PageResult<List<OrderDTO>>> findOrder(OrderForm orderForm) {
        PageResult<List<OrderDTO>> pageResult = new PageResult<>();
        List<Order> orders = orderManager.findOrder(orderForm);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(order, orderDTO);
            orderDTOList.add(orderDTO);
        }
        pageResult.setPageNo(orderForm.getPageNo());
        pageResult.setPageSize(orderForm.getPageSize());
        return BizResult.create(pageResult);
    }
}
