package com.consumer.bean.form;

import com.consumer.bean.dto.ProductDTO;
import com.consumer.bean.dto.ShopCartDTO;
import lombok.Data;

import java.util.List;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/5/1 
 * @since V1.0
 *  
 */
@Data
public class ShopCartForm {
    private List<ShopCartDTO> productDTO;
}
