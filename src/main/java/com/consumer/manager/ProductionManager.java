package com.consumer.manager;

import com.consumer.bean.dto.PageParam;
import com.consumer.bean.dto.ProductDTO;
import com.consumer.bean.dto.ProviderDTO;
import com.consumer.biz.BizResult;
import com.consumer.model.Product;
import com.consumer.model.ProductDetail;

import java.util.List;
import java.util.Map;

/**
 *   
 * <p>商品管理层</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/3 
 * @since V1.0
 *  
 */
public interface ProductionManager {

    /**
     * 查询商品目录 共有两层目录
     * @return
     */
    BizResult<Map<String, List<Product>>> findProduct();

    /**
     * 通过类型id查询产品
     * @return
     */
    List<Product> findProductByKindId(Long id);

    /**
     * 查询产品的id
     * @return
     */
    List<Product> findProductByKind(String kind);

    /**
     * 将商品添加进购物车
     * @param productDTO
     */
    void addProductToShopCart(ProductDTO productDTO);

    /**
     * 分页查询商品
     * @param id
     * @param pageParam
     * @return
     */
    List<Product> findProductByKindByPage(Long id, PageParam pageParam);

    /**
     * 查询商品总数
     * @return
     */
    Integer count(Long id);

    /**
     * 根据id查询商品信息
     * @param id
     * @return
     */
    Product findProductById(Long id);

    /**
     * 根据商品ID批量查找
     * @param providerIds
     */
    List<Product> findProductByIdS(List<Long> providerIds);

    /**
     * 根据商品id和经销商id确定一个商品
     * @param productDTO
     * @return
     */
    ProductDetail findProductByProviderIdAndProductId(ProductDTO productDTO);
    //List<Coffee> findCoffee();
}
