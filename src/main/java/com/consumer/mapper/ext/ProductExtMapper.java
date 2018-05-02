package com.consumer.mapper.ext;

import com.consumer.bean.dto.PageParam;
import com.consumer.bean.dto.ProductDTO;
import com.consumer.mapper.ProductMapper;
import com.consumer.model.Product;
import com.consumer.model.ProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

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
@Mapper
@Repository
public interface ProductExtMapper extends ProductMapper {
    /**
     * 分页查询
     * @return
     */
    List<Product> selectByExampleByPage(@Param("productCondition") ProductDTO productDTO);

    /**
     * 批量查找
     * @param providerIds
     * @return
     */
    List<Product> selectBatchById(@Param("providerIds") List<Long> providerIds);

    /**
     * 根据商品id和经销商id查询出商品的细节
     * @param productDTO
     * @return
     */
    ProductDetail selectProductDetail(@Param("productDTO") ProductDTO productDTO);
}
