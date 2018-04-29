package com.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/2/6 
 * @since V1.0
 *  
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    /**
     * 利用双端检索机制实例化ApplicationContext
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext != null) {
            synchronized (SpringUtil.class) {
                if (applicationContext != null) {
                    this.applicationContext = applicationContext;
                }
            }
        }
    }

    /**
     * 获取ApplicationContext
     */
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 通过name实例化bean
     */
    public static Object getBeanByName(String name){
        return applicationContext.getBean(name);
    }

    /**
     * 通过Class实例化bean
     */
    public static <T> T getBeanByClass(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }

    /**
     * 通过Class和name实例化bean
     */
    public static <T> T getBeanByNameAndClass(String name, Class<T> clazz){
        return applicationContext.getBean(name, clazz);
    }
}
