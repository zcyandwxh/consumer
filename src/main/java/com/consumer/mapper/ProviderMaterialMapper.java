package com.consumer.mapper;

import com.consumer.model.ProviderMaterial;
import com.consumer.model.ProviderMaterialExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProviderMaterialMapper {
    int countByExample(ProviderMaterialExample example);

    int deleteByExample(ProviderMaterialExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProviderMaterial record);

    int insertSelective(ProviderMaterial record);

    List<ProviderMaterial> selectByExample(ProviderMaterialExample example);

    ProviderMaterial selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProviderMaterial record, @Param("example") ProviderMaterialExample example);

    int updateByExample(@Param("record") ProviderMaterial record, @Param("example") ProviderMaterialExample example);

    int updateByPrimaryKeySelective(ProviderMaterial record);

    int updateByPrimaryKey(ProviderMaterial record);
}