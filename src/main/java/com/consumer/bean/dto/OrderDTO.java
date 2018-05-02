package com.consumer.bean.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *   
 * <p>订单DTO对象</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/7 
 * @since V1.0
 *  
 */
@Data
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 4840212304639605744L;

    private String id;

    private Long shopCartId;

    private Long buyerId;

    private String buyerName;

    private String provider;

    private String tradeId;

    private Long num;

    private Integer status;

    private Date gmtCreate;

    private Date gmtModitied;

    private String products;

    private Integer productNum;

}
