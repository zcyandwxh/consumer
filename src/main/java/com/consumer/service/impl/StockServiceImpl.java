package com.consumer.service.impl;

import com.consumer.bean.dto.PageParam;
import com.consumer.bean.dto.StockDTO;
import com.consumer.biz.BizResult;
import com.consumer.biz.PageResult;
import com.consumer.manager.StockManager;
import com.consumer.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockManager stockManager;

    @Override
    public BizResult<List<StockDTO>> findProductInStockByPage() {
//        PageParam pageParam = new PageParam();
//        pageParam.setPageNo(pageNo);
//        PageResult<List<StockDTO>> pageResult = new PageResult<>();
//        pageResult.setPageNo(pageNo);
//        pageResult.setPageSize(pageNo);
        List<StockDTO> stockDTOS = stockManager.selectProductInStockByPage();
//        Integer total = stockManager.count();
//        pageResult.setTotal(total);
//        pageResult.setResult(stockDTOS);
        return BizResult.create(stockDTOS);
    }
}
