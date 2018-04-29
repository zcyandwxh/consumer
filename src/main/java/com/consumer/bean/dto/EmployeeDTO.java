package com.consumer.bean.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *   
 * <p>员工数据传输对象</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/2 
 * @since V1.0
 *  
 */
@Data
public class EmployeeDTO implements Serializable{

    private static final long serialVersionUID = 71679513238908163L;

    /**
     * 员工id
     */
    private Long id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 员工密码
     */
    private String password;

    /**
     * 上次登录时间
     */
    private LocalDateTime loginTime;

}
