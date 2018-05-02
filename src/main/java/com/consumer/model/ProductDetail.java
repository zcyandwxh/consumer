package com.consumer.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class ProductDetail {
    /**
     * 商品id
     */
    private Long id;

    private String pictureUrl;

    private String productName;

    private Integer isParent;

    private Long parent;

    private LocalDateTime modityTime;

    private Long providerId;

    private BigDecimal price;

    private String providerName;
}
