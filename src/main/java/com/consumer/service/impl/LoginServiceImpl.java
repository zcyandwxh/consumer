package com.consumer.service.impl;


import com.consumer.bean.dto.EmployeeDTO;
import com.consumer.biz.BizResult;
import com.consumer.manager.EmployeeManager;
import com.consumer.model.Employee;
import com.consumer.service.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/2/10 
 * @since V1.0
 *  
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private EmployeeManager employeeManager;

    @Override
    public Employee write() {
        return null;
    }

    @Override
    public BizResult<EmployeeDTO> login(EmployeeDTO employeeDTO) {
        List<Employee> employees = employeeManager.findEmpByName(employeeDTO.getName());
        final boolean flag = false;
        if((employees != null) && (employees.size() > 0)) {
            for (Employee emp : employees) {
                if (emp.getPassword().equals(employeeDTO.getPassword())) {
                    BizResult<EmployeeDTO> bizResult = new BizResult<>();
                    BeanUtils.copyProperties(emp, employeeDTO);
                    bizResult.setData(employeeDTO);
                    bizResult.setDesc("查询成功");
                    bizResult.setFlag(true);
                    return bizResult;
                }
            }
        }
        return BizResult.create(null);
    }
}
