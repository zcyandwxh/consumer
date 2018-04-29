package com.consumer.manager.impl;

import com.consumer.manager.RoleManager;
import com.consumer.mapper.UserRolesMapper;
import com.consumer.model.UserRoles;
import com.consumer.model.UserRolesExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/14 
 * @since V1.0
 *  
 */
@Repository
public class RoleManagerImpl implements RoleManager{

    @Autowired
    private UserRolesMapper userRolesMapper;

    @Override
    public List<UserRoles> findEmpRole(String username) {

        UserRolesExample userRolesExample = new UserRolesExample();
        UserRolesExample.Criteria criteria = userRolesExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userRolesMapper.selectByExample(userRolesExample);
    }

//    private UserR
}
