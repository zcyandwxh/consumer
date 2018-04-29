package com.consumer.manager.impl;

import com.consumer.manager.EmployeeManager;
import com.consumer.mapper.EmployeeMapper;
import com.consumer.model.Employee;
import com.consumer.model.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@Component
public class EmployeeManagerImpl implements EmployeeManager {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findEmpByName(String username) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andNameEqualTo(username);
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        return employees;
    }
}
