package com.consumer.service;


import com.consumer.bean.dto.EmployeeDTO;
import com.consumer.biz.BizResult;
import com.consumer.model.Employee;

/**
 *   
 * <p>登录功能</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2017/12/20 
 * @since V1.0
 *  
 */
public interface LoginService {

    /**
     * 注册功能
     * @return
     */
    Employee write();

    /**
     * 进行登录操作
     * @param employeeDTO
     * @return
     */
    BizResult<EmployeeDTO> login(EmployeeDTO employeeDTO);
}
