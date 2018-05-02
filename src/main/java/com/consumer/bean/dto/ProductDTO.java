package com.consumer.bean.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *   
 * <p>商品传输对象</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/5 
 * @since V1.0
 *  
 */
@Data
public class ProductDTO extends PageParam implements Serializable {

    private static final long serialVersionUID = -5671302299195029612L;

    /**
     * 商品od
     */
    private Long id;

    /**
     * 商品图片
     */
    private String pictureUrl;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 属于那一个商品类别
     */
    private Long parent;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 经销商
     */
    private String provider;

    /**
     * jingxiaoshangid
     */
    private Long providerId;

    /**
     * 价格
     */
    private String price;
}
