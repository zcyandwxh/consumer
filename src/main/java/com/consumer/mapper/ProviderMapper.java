package com.consumer.mapper;

import com.consumer.model.Provider;
import com.consumer.model.ProviderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProviderMapper {
    int countByExample(ProviderExample example);

    int deleteByExample(ProviderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Provider record);

    int insertSelective(Provider record);

    List<Provider> selectByExample(ProviderExample example);

    Provider selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Provider record, @Param("example") ProviderExample example);

    int updateByExample(@Param("record") Provider record, @Param("example") ProviderExample example);

    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKey(Provider record);
}