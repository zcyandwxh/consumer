package com.consumer.service.impl;

import com.consumer.bean.dto.ProviderDTO;
import com.consumer.biz.BizResult;
import com.consumer.manager.ProviderManager;
import com.consumer.model.Provider;
import com.consumer.service.ProviderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *   
 * <p>供应商</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/1 
 * @since V1.0
 *  
 */
@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderManager providerManager;

    @Override
    public BizResult<List<ProviderDTO>> getProvider() {
        List<Provider> providers = providerManager.findProvider();
        ProviderDTO providerDTO = null;
        List<ProviderDTO> providerDTOS = new ArrayList<>();
        for (Provider provider : providers) {
            providerDTO = new ProviderDTO();
            BeanUtils.copyProperties(provider, providerDTO);
        }
        return BizResult.create(providerDTOS);
    }

    /**
     *  TODO 为了消除类型转换的重复代码
     * @param source
     * @param target
     * @return
     */
    public List<?> transfer(Class<?> source, Class<?> target){
        try {
            Object o = source.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
