/**
 * 
 */
package com.ssm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 作者
 * @data 2019年8月2日 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String operateDescription();// 记录日志的操作类型，不写默认值就是一个必须填的注解
}
