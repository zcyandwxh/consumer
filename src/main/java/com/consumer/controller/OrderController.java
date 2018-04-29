package com.consumer.controller;

import com.consumer.bean.dto.OrderDTO;
import com.consumer.bean.dto.ProductDTO;
import com.consumer.bean.form.OrderForm;
import com.consumer.biz.BizResult;
import com.consumer.biz.PageResult;
import com.consumer.service.OrderService;
import com.consumer.service.ProductionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
            modelMap.put("orderDTOList", orderDTOList);
            return "showOrder";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}
