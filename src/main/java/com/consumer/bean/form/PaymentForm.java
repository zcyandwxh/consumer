package com.consumer.bean.form;

import com.consumer.bean.dto.PaymentRelationDTO;
import lombok.Data;

import java.util.List;

/**
 *   
 * <p>结算</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/29 
 * @since V1.0
 *  
 */
@Data
public class PaymentForm {
    private List<PaymentRelationDTO> list;
}
