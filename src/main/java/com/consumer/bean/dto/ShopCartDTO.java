package com.consumer.bean.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 *   
 * <p>购物车信息</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/29 
 * @since V1.0
 *  
 */
@Data
public class ShopCartDTO {
    private Long id;

    private Long productId;

    private String productName;

    private BigDecimal price;

    private Long num;

    private Long buyerId;

    private Long providerId;

    private String providerName;

    private String pictureUrl;

    private BigDecimal total;

}
