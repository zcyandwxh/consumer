package com.consumer.bean.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/2 
 * @since V1.0
 *  
 */
@Data
public class ProviderDTO implements Serializable{
    private static final long serialVersionUID = 773689295397509513L;
    private Long id;

    private String providerName;

    private Long credit;

    private String contact;
}
