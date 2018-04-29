package com.consumer.bean.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *   
 * <p>库存dto对象</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/10 
 * @since V1.0
 *  
 */
@Data
public class StockDTO {
    private Long id;

    private String material;

    private Long num;

    private Integer status;

    private String picture;

    private BigDecimal price;

    private LocalDateTime modifyTime;
}
