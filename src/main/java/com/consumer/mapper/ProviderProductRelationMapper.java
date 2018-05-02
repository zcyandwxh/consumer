package com.consumer.mapper;

import com.consumer.model.ProviderProductRelation;
import com.consumer.model.ProviderProductRelationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper@Repository
public interface ProviderProductRelationMapper {
    int countByExample(ProviderProductRelationExample example);

    int deleteByExample(ProviderProductRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProviderProductRelation record);

    int insertSelective(ProviderProductRelation record);

    List<ProviderProductRelation> selectByExample(ProviderProductRelationExample example);

    ProviderProductRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProviderProductRelation record, @Param("example") ProviderProductRelationExample example);

    int updateByExample(@Param("record") ProviderProductRelation record, @Param("example") ProviderProductRelationExample example);

    int updateByPrimaryKeySelective(ProviderProductRelation record);

    int updateByPrimaryKey(ProviderProductRelation record);
}