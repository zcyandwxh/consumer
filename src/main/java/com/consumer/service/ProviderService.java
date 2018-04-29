package com.consumer.service;

import com.consumer.bean.dto.ProviderDTO;
import com.consumer.biz.BizResult;
import com.consumer.model.Provider;

import java.util.List;

/**
 *   
 * <p>供应商服务</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/1 
 * @since V1.0
 *  
 */
public interface ProviderService {

    /**
     * 查找所有的供应商
     * @return
     */
    BizResult<List<ProviderDTO>> getProvider();
}
