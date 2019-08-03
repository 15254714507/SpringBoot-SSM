/**
 * 
 */
package com.ssm.aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author 作者
 * @data 2019年8月2日 
 */
@Aspect  
@Component 
public class MyAspect {
	private final static Logger log = LoggerFactory.getLogger(MyAspect.class);
	
	//定义切点
	@Pointcut("execution(* com.ssm.controller..*.*(..))")
	public void performance() {
	}
	
	/**
	 * 环绕通知记录时间
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("performance()")
	public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
	
	    // 记录起始时间
	    long begin = System.currentTimeMillis();
	    Object result = "";
	    /** 执行目标方法 */
	    try {
	        result = joinPoint.proceed();
	    } catch (Exception e) {
	        log.error("日志记录发生错误, errorMessage: {}", e.getMessage());
	    } finally {
	        /** 记录操作时间 */
	        long took = (System.currentTimeMillis() - begin) / 1000;
	        log.info("controller执行时间为: {}秒", took);
	    }	 
	    return result;
	}
	
	/**
	 * 前置通知
	 * 
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("performance()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
	    // 接收到请求，记录请求内容
	    log.info("doBefore");
	}
	
	}
