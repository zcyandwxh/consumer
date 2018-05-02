package com.consumer.manager.impl;

import com.consumer.bean.dto.PageParam;
import com.consumer.bean.dto.ProductDTO;
import com.consumer.bean.dto.ProviderDTO;
import com.consumer.biz.BizResult;
import com.consumer.enums.KindEnum;
import com.consumer.manager.ProductionManager;
import com.consumer.mapper.ProductMapper;
import com.consumer.mapper.ext.ProductExtMapper;
import com.consumer.model.Product;
import com.consumer.model.ProductDetail;
import com.consumer.model.ProductExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/3 
 * @since V1.0
 *  
 */
@Component
@Slf4j
public class ProductionManagerImpl implements ProductionManager {

    private static Integer IS_PARENT = 1;
    private static Integer NOT_PARENT = 0;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductExtMapper productExtMapper;

    @Override
    public BizResult<Map<String, List<Product>>> findProduct() {
        //TODO 有待优化
        BizResult<Map<String, List<Product>>> productResult = new BizResult<>();
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andIsParentEqualTo(IS_PARENT);
        List<Product> products = productMapper.selectByExample(productExample);

        if (log.isInfoEnabled()) {
            log.info("商品的目录为：{}", products);
        }
        Map<String, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            if (product.getParent() == 0) {
                if (!productMap.containsKey(product.getProduct())) {
                    productMap.put(product.getProduct(), new ArrayList<>());
                }
            } else {
                //取到了父产品的id
                Long parentId = product.getParent();
                String productName = KindEnum.getType(parentId);
                if (!StringUtils.isEmpty(productName)) {
                    if (productMap.containsKey(productName)) {
                        productMap.get(productName).add(product);
                    } else {
                        List<Product> twiceProduct = new ArrayList<>();
                        twiceProduct.add(product);
                        productMap.put(productName, twiceProduct);
                    }
                } else {
                    if (log.isInfoEnabled()) {
                        log.info("父产品id = {}, 名字name = {}对应不到枚举类", parentId, productName);
                    }
                }
            }
        }
        productResult.setData(productMap);
        return productResult;
    }

    @Override
    public List<Product> findProductByKindId(Long id) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andParentEqualTo(id);
        List<Product> products = productMapper.selectByExample(productExample);
        return products;
    }

    @Override
    public List<Product> findProductByKind(String kind) {
        ProductExample productExample = new ProductExample();
        //根据kind查询类别的id
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductEqualTo(kind);
        List<Product> list = productMapper.selectByExample(productExample);
        return list;
    }

    @Override
    public void addProductToShopCart(ProductDTO productDTO) {
       // productMapper.insert()
    }

    @Override
    public List<Product> findProductByKindByPage(Long id, PageParam pageParam) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        productDTO.setPageNo(pageParam.getPageNo());
        productDTO.setPageSize(pageParam.getPageSize());
        productDTO.setPageOffset((pageParam.getPageNo()-1) * pageParam.getPageSize());
        return productExtMapper.selectByExampleByPage(productDTO);
    }

    @Override
    public Integer count(Long id) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andParentEqualTo(id);
        return productExtMapper.countByExample(productExample);
    }

    @Override
    public Product findProductById(Long id) {
        return productExtMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> findProductByIdS(List<Long> providerIds) {
        return productExtMapper.selectBatchById(providerIds);
    }

    @Override
    public ProductDetail findProductByProviderIdAndProductId(ProductDTO productDTO) {
        return productExtMapper.selectProductDetail(productDTO);
    }
}
