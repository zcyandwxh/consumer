package com.consumer.mapper.ext;

import com.consumer.bean.dto.PageParam;
import com.consumer.bean.dto.ProductDTO;
import com.consumer.mapper.ProductMapper;
import com.consumer.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
}
