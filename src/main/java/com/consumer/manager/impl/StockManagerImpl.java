package com.consumer.manager.impl;

import com.consumer.bean.dto.StockDTO;
import com.consumer.manager.StockManager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   
 * <p>实现</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/10 
 * @since V1.0
 *  
 */
@Service
public class StockManagerImpl implements StockManager{
    @Override
    public List<StockDTO> selectProductInStockByPage() {
        return null;
    }

    @Override
    public Integer count() {
        return null;
    }
}
