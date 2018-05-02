package com.consumer.mapper;

import com.consumer.model.OrderProductRelation;
import com.consumer.model.OrderProductRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderProductRelationMapper {
    int countByExample(OrderProductRelationExample example);

    int deleteByExample(OrderProductRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderProductRelation record);

    int insertSelective(OrderProductRelation record);

    List<OrderProductRelation> selectByExample(OrderProductRelationExample example);

    OrderProductRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderProductRelation record, @Param("example") OrderProductRelationExample example);

    int updateByExample(@Param("record") OrderProductRelation record, @Param("example") OrderProductRelationExample example);

    int updateByPrimaryKeySelective(OrderProductRelation record);

    int updateByPrimaryKey(OrderProductRelation record);
}