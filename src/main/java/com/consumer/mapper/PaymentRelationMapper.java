package com.consumer.mapper;

import com.consumer.model.PaymentRelation;
import com.consumer.model.PaymentRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentRelationMapper {
    int countByExample(PaymentRelationExample example);

    int deleteByExample(PaymentRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaymentRelation record);

    int insertSelective(PaymentRelation record);

    List<PaymentRelation> selectByExample(PaymentRelationExample example);

    PaymentRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaymentRelation record, @Param("example") PaymentRelationExample example);

    int updateByExample(@Param("record") PaymentRelation record, @Param("example") PaymentRelationExample example);

    int updateByPrimaryKeySelective(PaymentRelation record);

    int updateByPrimaryKey(PaymentRelation record);
}