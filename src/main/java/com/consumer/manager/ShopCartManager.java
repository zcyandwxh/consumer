package com.consumer.manager;

import com.consumer.bean.dto.ProductDTO;
import com.consumer.model.ShopCart;

import java.util.List;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/22 
 * @since V1.0
 *  
 */
public interface ShopCartManager {
    /**
     * 增加物料到购物车
     * @param shopCart
     * @return
     */
    Integer addProductIntoShopCart(ShopCart shopCart);

    /**
     * 根据id筛选出物料
     * @param id
     * @return
     */
    Integer selectById(Long id);

    /**
     * 更新购物车中同款商品的数量
     * @param number
     * @return
     */
    Integer updateProductShoppingCart(Long number);

    /**
     * 根据购买者的id查询购物车内商品
     */
    List<ShopCart> selectByBuyerId(Long id);
}
