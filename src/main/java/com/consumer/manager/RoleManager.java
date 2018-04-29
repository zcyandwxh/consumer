package com.consumer.manager;

import com.consumer.model.UserRoles;

import java.util.List;

/**
 *   
 * <p>权限管理</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/14 
 * @since V1.0
 *  
 */
public interface RoleManager {

    List<UserRoles> findEmpRole(String username);

}
