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
    BizResult<List<ProviderDTO>> getProvider(String providerName);

    /**
     * 查找供应商的商品信息
     * @param providerDTO
     * @return
     */
    BizResult<ProviderDTO> selectProviderDetail(ProviderDTO providerDTO);

    /**
     * 删除供应商
     * @param providerDTO
     * @return
     */
    BizResult<Integer> deleteProvider(ProviderDTO providerDTO);

    /**
     * 新增供应商
     * @param providerDTO
     * @return
     */
    BizResult<Boolean> addProvider(ProviderDTO providerDTO);
}
