package com.consumer.controller;

import com.consumer.bean.dto.OrderDTO;
import com.consumer.bean.dto.OrderDetail;
import com.consumer.bean.dto.ProductDTO;
import com.consumer.bean.form.OrderForm;
import com.consumer.biz.BizResult;
import com.consumer.biz.PageResult;
import com.consumer.model.Product;
import com.consumer.service.OrderService;
import com.consumer.service.ProductionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/6 
 * @since V1.0
 *  
 */
@Controller
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductionService productionService;

    /**
     * 显示所有订单的信息
     * @return
     */
    @RequestMapping("showOrder.htm")
    public String showOrder(ModelMap modelMap, OrderForm orderForm) {

        try {
            if (log.isInfoEnabled()) {
                log.info("查询条件为：{}", orderForm);
            }
            BizResult<PageResult<List<OrderDTO>>> orderDTOList = orderService.findOrder(orderForm);
            BizResult<Map<String, List<Product>>> productDTOs = productionService.getProducts();
            modelMap.addAttribute("products", productDTOs);
            modelMap.put("orderDTOList", orderDTOList.getData());
            return "showOrder";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 查询订单
     * @param orderId
     * @param map
     * @return
     */
    @RequestMapping("detail.htm")
    public String showDetail(String orderId, ModelMap map) {
        BizResult<List<OrderDetail>> orderDTOS = orderService.findOrderDetail(orderId);
        BizResult<Map<String, List<Product>>> productDTOs = productionService.getProducts();
        map.addAttribute("products", productDTOs);
        map.addAttribute("orderDTOS", orderDTOS);
        return "orderDetail";
    }
}
