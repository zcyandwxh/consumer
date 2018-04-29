package com.consumer.mapper.ext;

import com.consumer.mapper.PaymentMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/29 
 * @since V1.0
 *  
 */
@Mapper
@Repository
public interface PaymentExtMapper extends PaymentMapper{
}
