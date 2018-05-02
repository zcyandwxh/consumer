package com.consumer.bean.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/5/1 
 * @since V1.0
 *  
 */
@Data
public class OrderDetail {
    private Long id;

    private String orderId;

    private Long productId;

    private String productName;

    private Integer num;

    private BigDecimal price;

    private BigDecimal total;

    private Long providerId;

    private String providerName;
}
