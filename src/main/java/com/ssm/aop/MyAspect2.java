/**
 * 
 */
package com.ssm.aop;

import java.lang.reflect.Method;
import java.sql.SQLException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ssm.annotation.MyAnnotation;

/**
 * @author 作者
 * @data 2019年8月2日 
 */
@Aspect  
@Component 
public class MyAspect2 {
	 private final static Logger log = LoggerFactory.getLogger(MyAspect2.class);

	    /**
	     * 环绕通知处理
	     *
	     * @param pjp
	     * @return
	     * @throws Throwable
	     */
	    @Around("@annotation(com.ssm.annotation.MyAnnotation)")
	    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
	        // 1.方法执行前的处理，相当于前置通知
	        // 获取方法签名
	        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
	        // 获取方法
	        Method method = methodSignature.getMethod();
	        // 获取方法上面的注解
	        MyAnnotation myAnno = method.getAnnotation(MyAnnotation.class);
	        // 获取到类名
	        String targetName = pjp.getTarget().getClass().getName();
	        // 获取到方法名字
	        String methodName = method.getName();
	        // 获取操作描述的属性值
	        String operateDescription = myAnno.operateDescription();
	        Object result = null;
	        try {
	            // 让代理方法执行
	            result = pjp.proceed();
	            // 2.相当于后置通知(方法成功执行之后走这里)
	        } catch (SQLException e) {
	            // 3.相当于异常通知部分
	        } finally {
	            // 4.相当于最终通知
	            log.info("class->{},methodName->{},operateDescription->{}", targetName, methodName, operateDescription);
	        }
	        System.out.println("基于手写注解的AOP拦截功能实现");
	        return result;
	    }
}
