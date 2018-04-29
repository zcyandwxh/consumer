package com.consumer.annotation;

import java.lang.annotation.*;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/1 
 * @since V1.0
 *  
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface Auth {
     boolean islogin();
}
