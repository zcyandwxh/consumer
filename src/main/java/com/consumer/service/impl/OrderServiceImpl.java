package com.consumer.service.impl;

import com.consumer.bean.dto.OrderDTO;
import com.consumer.bean.dto.OrderDetail;
import com.consumer.bean.dto.ShopCartDTO;
import com.consumer.bean.form.OrderForm;
import com.consumer.bean.form.ShopCartForm;
import com.consumer.biz.BizResult;
import com.consumer.biz.PageResult;
import com.consumer.manager.OrderManager;
import com.consumer.manager.OrderProductRelationManager;
import com.consumer.manager.ShopCartManager;
import com.consumer.model.Order;
import com.consumer.model.OrderProductRelation;
import com.consumer.model.ShopCart;
import com.consumer.service.OrderService;
import com.util.PaymenyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private OrderProductRelationManager orderProductRelationManager;
    @Autowired
    private ShopCartManager shopCartManager;

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
        pageResult.setResult(orderDTOList);
        pageResult.setPageNo(orderForm.getPageNo());
        pageResult.setPageSize(orderForm.getPageSize());
        return BizResult.create(pageResult);
    }

    @Override
    @Transactional
    public BizResult<String> createOrder(List<Long> ids) {
        Order order = new Order();
        List<ShopCartDTO> productDTO = new ArrayList<>();
        for (Long id : ids) {
            ShopCartDTO shopCartDTO = new ShopCartDTO();
            ShopCart shopCart = shopCartManager.selectByShopCartId(id);
            BeanUtils.copyProperties(shopCart, shopCartDTO);
            productDTO.add(shopCartDTO);
        }
        String orderId = PaymenyUtils.payment();
        order.setId(orderId);
        orderManager.insertOrder(order);
        List<OrderProductRelation> orderProductRelations = new ArrayList<>();
        productDTO.stream().forEach((x) -> {
            OrderProductRelation orderProductRelation = new OrderProductRelation();
            orderProductRelation.setNum(x.getNum().intValue());
            orderProductRelation.setOrderId(orderId);
            orderProductRelation.setPrice(x.getPrice());
            orderProductRelation.setProductId(x.getProductId());
            orderProductRelation.setProductName(x.getProductName());
            orderProductRelations.add(orderProductRelation);
        });
        orderProductRelationManager.insertBatch(orderProductRelations);
        return BizResult.create(orderId);
    }

    @Override
    public BizResult<List<OrderDetail>> findOrderDetail(String orderId) {
        List<OrderProductRelation> orderProductRelations = orderProductRelationManager.selectOrderDetail(orderId);
        OrderDetail orderDetail = new OrderDetail();
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderProductRelation orderProductRelation : orderProductRelations) {
            BeanUtils.copyProperties(orderProductRelation, orderDetail);
            orderDetails.add(orderDetail);
        }
        return BizResult.create(orderDetails);
    }
}
