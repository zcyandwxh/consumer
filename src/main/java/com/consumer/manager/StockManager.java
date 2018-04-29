package com.consumer.manager;

import com.consumer.bean.dto.StockDTO;

import java.util.List;

/**
 *   
 * <p>库存管理</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/10 
 * @since V1.0
 *  
 */
public interface StockManager {

    /**
     * 分页查询在库产品信息
     * @return
     */
    List<StockDTO> selectProductInStockByPage();

    /**
     * 查询在库商品类别总数
     * @return
     */
    Integer count();
}
