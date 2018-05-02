package com.consumer.service.impl;

import com.consumer.bean.dto.ProductDTO;
import com.consumer.bean.dto.ProviderDTO;
import com.consumer.biz.BizResult;
import com.consumer.manager.ProductionManager;
import com.consumer.manager.ProviderManager;
import com.consumer.model.Product;
import com.consumer.model.Provider;
import com.consumer.model.ProviderProductRelation;
import com.consumer.service.ProviderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *   
 * <p>供应商</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/1 
 * @since V1.0
 *  
 */
@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderManager providerManager;
    @Autowired
    private ProductionManager productionManager;

    @Override
    public BizResult<List<ProviderDTO>> getProvider(String providerName) {
        List<Provider> providers = providerManager.findProvider(providerName);
        ProviderDTO providerDTO = null;
        List<ProviderDTO> providerDTOS = new ArrayList<>();
        for (Provider provider : providers) {
            providerDTO = new ProviderDTO();
            BeanUtils.copyProperties(provider, providerDTO);
            providerDTOS.add(providerDTO);
        }
        return BizResult.create(providerDTOS);
    }

    @Override
    public BizResult<ProviderDTO> selectProviderDetail(ProviderDTO providerDTO) {
        List<ProviderProductRelation> providerDTOS = providerManager.selectProviderDetail(providerDTO);
        List<Long> providerIds = providerDTOS.stream().map(ProviderProductRelation::getProviderId).collect(Collectors.toList());
        List<Product> products = productionManager.findProductByIdS(providerIds);
        ProviderDTO providerDTO1 = null;
        providerDTO1 = new ProviderDTO();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            for (ProviderProductRelation providerProductRelation : providerDTOS) {
                if (product.getId().equals(providerProductRelation.getProviderId())) {
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setPrice(providerProductRelation.getPrice().toString());
                    productDTO.setProductName(product.getProduct());
                    productDTOS.add(productDTO);
                }
            }
        }
        providerDTO1.setProduct(productDTOS);
        return BizResult.create(providerDTO1);
    }

    @Override
    public BizResult<Integer> deleteProvider(ProviderDTO providerDTO) {
        return BizResult.create(providerManager.deleteProvider(providerDTO));
    }

    @Override
    @Transactional
    public BizResult<Boolean> addProvider(ProviderDTO providerDTO) {
        Integer flag = providerManager.addProvider(providerDTO);
        if (flag == null) {
            throw new RuntimeException("插入供应商信息失败");
//            return BizResult.create(null);
        }
        ProviderProductRelation providerProductRelation = new ProviderProductRelation();
        for (ProductDTO entry : providerDTO.getProduct()) {
            providerProductRelation.setPrice(BigDecimal.valueOf(Double.parseDouble(entry.getPrice())));
            providerProductRelation.setProductId(entry.getId());
            providerProductRelation.setProviderId(providerDTO.getId());
        }
        Integer num = providerManager.addProviderProductRelation(providerProductRelation);
        if (num == null) {
            throw new RuntimeException("插入供应商商品关系表信息失败");
//            return BizResult.create(false);
        }
        return BizResult.create(true);
    }

    /**
     *  TODO 为了消除类型转换的重复代码
     * @param source
     * @param target
     * @return
     */
    public List<?> transfer(Class<?> source, Class<?> target){
        try {
            Object o = source.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
