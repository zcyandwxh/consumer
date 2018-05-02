package com.consumer.mapper.ext;

import com.consumer.mapper.OrderProductRelationMapper;
import com.consumer.model.OrderProductRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
@Mapper
@Repository
public interface OrderProductRelationExtMapper extends OrderProductRelationMapper{
    void insertBatch(@Param("orderProductRelations") List<OrderProductRelation> orderProductRelations);
}
