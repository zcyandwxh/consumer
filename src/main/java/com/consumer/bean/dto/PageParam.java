package com.consumer.bean.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *   
 * <p>页码参数</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/10 
 * @since V1.0
 *  
 */
@Data
public class PageParam implements Serializable{
    private static final long serialVersionUID = 5936635406715753448L;

    /**
     * 页码
     */
    private int pageNo;

    /**
     * 每页数量
     */
    private int pageSize = 6;

    /**
     * 偏移量
     */
    private int pageOffset;
}
