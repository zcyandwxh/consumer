package com.consumer.manager.impl;

import com.consumer.manager.ProviderManager;
import com.consumer.mapper.ProviderMapper;
import com.consumer.model.Provider;
import com.consumer.model.ProviderExample;
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

    @Override
    public List<Provider> findProvider() {
        ProviderExample providerExample = new ProviderExample();
        return providerMapper.selectByExample(null);
    }
}
