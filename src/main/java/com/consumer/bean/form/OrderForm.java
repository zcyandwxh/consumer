package com.consumer.bean.form;

import com.consumer.bean.dto.PageParam;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/10 
 * @since V1.0
 *  
 */
@Data
public class OrderForm extends PageParam {

    private static final long serialVersionUID = 2107782063165996817L;

    private String id;

    /**
     * {供应商：{商品id:商品name}}
     */
    private Long providerId;

    private String providerName;

    private List<Long> shopCarIds;

    private String tradeId;

    private Long num;

    private Integer status;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModitied;
}
