package com.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/29 
 * @since V1.0
 *  
 */
@RequestMapping("page")
@Controller
public class PageController {

    @RequestMapping("shopCart")
    public String toPageShopCart() {
        return "";
    }
}
