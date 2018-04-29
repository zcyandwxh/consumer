package com.consumer.manager;

import com.consumer.model.Employee;

import java.util.List;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/2 
 * @since V1.0
 *  
 */
public interface EmployeeManager {
    /**
     * 通过用户名查询对应的人是否存在
     */
    List<Employee> findEmpByName(String username);
}
