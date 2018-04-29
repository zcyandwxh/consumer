package com.consumer.controller;

import com.consumer.annotation.Auth;
import com.consumer.biz.BizResult;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/1 
 * @since V1.0
 *  
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Auth(islogin = false)
    @RequestMapping("delete")
    public BizResult<Boolean> deleteEmployee(){
        try {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 员工增加
     * @return
     */
    @RequestMapping(value = "add")
    public BizResult<Boolean> addEmployee() {
        try {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "show")
    public BizResult<Boolean> showEmployee() {
        return null;
    }

}
