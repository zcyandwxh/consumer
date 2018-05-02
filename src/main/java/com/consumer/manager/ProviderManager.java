package com.consumer.manager;

import com.consumer.bean.dto.ProviderDTO;
import com.consumer.model.Provider;
import com.consumer.model.ProviderProductRelation;

import java.util.List;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/2 
 * @since V1.0
 *  
 */
public interface ProviderManager {
    /**
     * 查找所有的供应商信息
     * @return
     */
    List<Provider> findProvider(String provider);

    /**
     * 查找供应商的商品信息
     * @param providerDTO
     * @return
     */
    List<ProviderProductRelation> selectProviderDetail(ProviderDTO providerDTO);

    /**
     * 删除供应商
     * @param providerDTO
     */
    Integer deleteProvider(ProviderDTO providerDTO);

    /**
     * 新增供应商
     * @param providerDTO
     * @return
     */
    Integer addProvider(ProviderDTO providerDTO);

    /**
     * 将供应商商品对应信息插入到表中
     * @param providerProductRelation
     * @return
     */
    Integer addProviderProductRelation(ProviderProductRelation providerProductRelation);

    /**
     * 根据经销商id查询出经销商信息
     * @param providerId
     * @return
     */
    Provider selectProviderById(Long providerId);
}
