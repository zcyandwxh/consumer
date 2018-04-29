package com.consumer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.consumer.bean.dto.PageParam;
import com.consumer.bean.dto.ProductDTO;
import com.consumer.bean.dto.ShopCartDTO;
import com.consumer.biz.BizResult;
import com.consumer.biz.PageResult;
import com.consumer.manager.ProductionManager;
import com.consumer.manager.ShopCartManager;
import com.consumer.model.Product;
import com.consumer.model.ShopCart;
import com.consumer.service.ProductionService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIXDom;
import com.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *   
 * <p>商品服务</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/3 
 * @since V1.0
 *  
 */
@Service
@Slf4j
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionManager productionManager;
    @Autowired
    private ShopCartManager shopCartManager;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public BizResult<Map<String, List<Product>>> getProducts() {
        BizResult<Map<String, List<Product>>> productDTOs = productionManager.findProduct();
        return productDTOs;
    }

    @Override
    public BizResult<PageResult<List<ProductDTO>>> findProductByKind(Long kind, Integer pageNo) {
        if (log.isInfoEnabled()) {
            log.info("商品种类为： {}", kind);
        }
        PageParam pageParam = new PageParam();
        pageParam.setPageNo(pageNo);

        //计算总数
        Integer count = productionManager.count(kind);
        List<Product> productList = productionManager.findProductByKindByPage(kind, pageParam);
        if (productList.size() > 0 && productList != null) {
            ProductDTO productDTO = null;
            List<ProductDTO> productDTOS = new ArrayList<>();
            for (Product pro : productList) {
                productDTO = new ProductDTO();
                BeanUtils.copyProperties(pro, productDTO);
                productDTOS.add(productDTO);
            }
            BizResult<PageResult<List<ProductDTO>>> result = new BizResult<>();
            result.setFlag(true);
            result.setDesc("查询成功");
            PageResult<List<ProductDTO>> pageResult = new PageResult<>();
            pageResult.setResult(productDTOS);
            result.setData(pageResult);
            return result;
        }
        return BizResult.create(null);
    }

    @Override
    public BizResult<Boolean> addProductToRedis(ProductDTO productDTO) {
//        productionManager.addProductToShopCart(productDTO);
        redisUtil.setProduct(productDTO.getId(), productDTO.getNum());
        return null;
    }

    @Override
    public BizResult<Integer> addProduct(ProductDTO productDTO) {
        ShopCart shopCart = new ShopCart();
        BeanUtils.copyProperties(productDTO, shopCart);
        Integer num = shopCartManager.selectById(productDTO.getId());
        //增加到购物车中
        if (num == 0) {
            return BizResult.create(shopCartManager.addProductIntoShopCart(shopCart));
        } else {
            num = num + productDTO.getNum();
            return BizResult.create(shopCartManager.updateProductShoppingCart(num.longValue()));
        }
    }

    @Override
    public BizResult<List<ShopCartDTO>> findShopCart(Long id) {
        List<ShopCart> list = shopCartManager.selectByBuyerId(id);
        if (CollectionUtils.isEmpty(list)) {
            return BizResult.create(null);
        }
        List<ShopCartDTO> shopCartDTOS = new ArrayList<>();
        list.stream().forEach((x) -> {
            ShopCartDTO shopCartDTO = new ShopCartDTO();
            BeanUtils.copyProperties(x, shopCartDTO);
            shopCartDTOS.add(shopCartDTO);
        });
        return BizResult.create(shopCartDTOS);
    }

    @Override
    public BizResult<ProductDTO> findProductDetail(Long id) {
        Product product = productionManager.findProductById(id);
        if (product == null) {
            BizResult.create(null);
        }
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return BizResult.create(productDTO);
    }
}
