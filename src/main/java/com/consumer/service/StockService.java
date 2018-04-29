package com.consumer.service;

import com.consumer.bean.dto.StockDTO;
import com.consumer.biz.BizResult;
import com.consumer.biz.PageResult;

import java.util.List;

/**
 *   
 * <p>库存服务</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/10 
 * @since V1.0
 *  
 */
public interface StockService {
    /**
     * 库存接口
     * @return
     */
    BizResult<List<StockDTO>> findProductInStockByPage();
}
