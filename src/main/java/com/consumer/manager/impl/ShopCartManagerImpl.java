package com.consumer.manager.impl;

import com.consumer.manager.ShopCartManager;
import com.consumer.mapper.ShopCartMapper;
import com.consumer.model.ShopCart;
import com.consumer.model.ShopCartExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@Component
public class ShopCartManagerImpl implements ShopCartManager{

    @Autowired
    private ShopCartMapper shopCartMapper;

    @Override
    public Integer addProductIntoShopCart(ShopCart shopCart) {
        return shopCartMapper.insert(shopCart);
    }

    @Override
    public Integer selectById(Long id) {
        ShopCartExample shopCartExample = new ShopCartExample();
        ShopCartExample.Criteria criteria = shopCartExample.createCriteria();
        criteria.andProductIdEqualTo(id);
        return shopCartMapper.countByExample(shopCartExample);
    }

    @Override
    public Integer updateProductShoppingCart(Long number) {
        ShopCart shopCart = new ShopCart();
        shopCart.setNum(number);
        return shopCartMapper.updateByPrimaryKeySelective(shopCart);
    }

    @Override
    public List<ShopCart> selectByBuyerId(Long id) {
        ShopCartExample shopCartExample = new ShopCartExample();
        ShopCartExample.Criteria criteria = shopCartExample.createCriteria();
        criteria.andBuyerIdEqualTo(id);
        List<ShopCart> shopCarts = shopCartMapper.selectByExample(shopCartExample);
        return shopCarts;
    }

    @Override
    public ShopCart selectByShopCartId(Long id) {
        return shopCartMapper.selectByPrimaryKey(id);
    }
}
