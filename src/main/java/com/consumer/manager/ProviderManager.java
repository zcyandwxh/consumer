package com.consumer.manager;

import com.consumer.model.Provider;

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
    List<Provider> findProvider();
}
