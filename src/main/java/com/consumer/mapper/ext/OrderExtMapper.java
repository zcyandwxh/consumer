package com.consumer.mapper.ext;

import com.consumer.bean.form.OrderForm;
import com.consumer.mapper.OrderMapper;
import com.consumer.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 * <p>订单扩展查询</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/10 
 * @since V1.0
 *  
 */
@Mapper
@Repository
public interface OrderExtMapper extends OrderMapper {
    List<Order> selectOrderByPage(@Param("record") OrderForm orderForm);
}
