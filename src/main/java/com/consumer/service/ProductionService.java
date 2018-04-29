package com.consumer.service;

import com.consumer.bean.dto.PageParam;
import com.consumer.bean.dto.ProductDTO;
import com.consumer.bean.dto.ShopCartDTO;
import com.consumer.biz.BizResult;
import com.consumer.biz.PageResult;
import com.consumer.model.Product;

import java.util.List;
import java.util.Map;

/**
 *   
 * <p>对商品对服务</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/3 
 * @since V1.0
 *  
 */
public interface ProductionService {

    /**
     * 获取所有的商品
     * @return
     */
    BizResult<Map<String, List<Product>>> getProducts();

    /**
     * 根据类别查询产品
     * @param kind
     * @return
     */
    BizResult<PageResult<List<ProductDTO>>> findProductByKind(Long kind, Integer pageNo);

    /**
     * 将物料添加入购物车
     * @return
     */
    BizResult<Boolean> addProductToRedis(ProductDTO productDTO);

    /**
     * 将物料添加到购物车（持久化）
     * @param productDTO
     * @return
     */
    BizResult<Integer> addProduct(ProductDTO productDTO);

    /**
     * 查询购物车内商品
     * @param id
     * @return
     */
    BizResult<List<ShopCartDTO>> findShopCart(Long id);

    /**
     * 查询商品细节
     * @param id
     * @return
     */
    BizResult<ProductDTO> findProductDetail(Long id);
    // List<Coffee> findCoffees();
}
