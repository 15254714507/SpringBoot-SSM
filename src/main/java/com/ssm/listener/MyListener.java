/**
 * 
 */
package com.ssm.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 作者
 * @data 2019年8月2日 
 */
@WebListener()
public class MyListener implements HttpSessionListener{

	 public static int online = 0;

	    @Override
	    public void sessionCreated(HttpSessionEvent se) {
	        System.out.println("创建session,在线用户数:" + (++online));
	    }

	    @Override
	    public void sessionDestroyed(HttpSessionEvent se) {
	        System.out.println("销毁session,在线用户数:" + (--online));
	        online--;
	    }
}
