package com.consumer.model;


import lombok.Data;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com.model.User）
 * @date: 2017/12/20 
 * @since V1.0
 *  
 */
@Data
public class User implements java.io.Serializable {

    private String password;
    private String username;
}
