package com.consumer.manager.impl;

import com.consumer.bean.dto.ProviderDTO;
import com.consumer.manager.ProviderManager;
import com.consumer.mapper.ProviderMapper;
import com.consumer.mapper.ProviderProductRelationMapper;
import com.consumer.model.Provider;
import com.consumer.model.ProviderExample;
import com.consumer.model.ProviderProductRelation;
import com.consumer.model.ProviderProductRelationExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@Component
public class ProviderManagerImpl implements ProviderManager {

    @Autowired
    private ProviderMapper providerMapper;
    @Autowired
    private ProviderProductRelationMapper providerProductRelationMapper;

    @Override
    public List<Provider> findProvider(String provider) {
        if (provider != null) {
            ProviderExample providerExample = new ProviderExample();
            ProviderExample.Criteria criteria = providerExample.createCriteria();
            criteria.andProviderNameLike("%" + provider);
            return providerMapper.selectByExample(providerExample);
        }
        return providerMapper.selectByExample(null);
    }

    @Override
    public List<ProviderProductRelation> selectProviderDetail(ProviderDTO providerDTO) {
        ProviderProductRelationExample providerProductRelationExample = new ProviderProductRelationExample();
        ProviderProductRelationExample.Criteria criteria = providerProductRelationExample.createCriteria();
        criteria.andProviderIdEqualTo(providerDTO.getId());
        return providerProductRelationMapper.selectByExample(providerProductRelationExample);
    }

    @Override
    public Integer deleteProvider(ProviderDTO providerDTO) {
        return providerProductRelationMapper.deleteByPrimaryKey(providerDTO.getId());
    }

    @Override
    public Integer addProvider(ProviderDTO providerDTO) {
//        ProviderProductRelation providerProductRelation = new ProviderProductRelation();
//        providerProductRelation.setProviderId(providerDTO.getId());
//        providerProductRelation.setPrice(providerDTO.get);
        Provider provider = new Provider();
        BeanUtils.copyProperties(providerDTO, provider);
        return providerMapper.insertSelective(provider);
    }

    @Override
    public Integer addProviderProductRelation(ProviderProductRelation providerProductRelation) {
        return providerProductRelationMapper.insertSelective(providerProductRelation);
    }

    @Override
    public Provider selectProviderById(Long providerId) {
        return providerMapper.selectByPrimaryKey(providerId);
    }
}
