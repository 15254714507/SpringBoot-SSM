
# SpringBoot-SSM
SpringBoot和SSM进行整合

####目录结构
```
├─.mvn
│  └─wrapper
│          maven-wrapper.jar
│          maven-wrapper.properties
│          MavenWrapperDownloader.java
│                
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─ssm
│  │  │          │  SpringBoot1Application.java     启动类
│  │  │          │  
│  │  │          ├─annotation
│  │  │          │      MyAnnotation.java       //手写注解实现AOP拦截
│  │  │          │      
│  │  │          ├─aop
│  │  │          │      MyAspect.java           //用切点表达式实现AOP拦截
│  │  │          │      MyAspect2.java	    //手写注解的AOP拦截类
│  │  │          │      
│  │  │          ├─controller
│  │  │          │      UserController.java     //Controller类
│  │  │          │      
│  │  │          ├─filter
│  │  │          │      MyFilter.java          //过滤器
│  │  │          │      
│  │  │          ├─listener
│  │  │          │      MyListener.java        //监听器
│  │  │          │      
│  │  │          ├─mapper
│  │  │          │      UserMapper.java        //mybatis的接口
│  │  │          │      
│  │  │          ├─pojo
│  │  │          │      User.java            //bean
│  │  │          │      
│  │  │          └─service
│  │  │              │  UserService.java    //service接口
│  │  │              │  
│  │  │              └─impl
│  │  │                      UserServiceImpl.java  //实现类，事务管理，异常手动回滚
│  │  │                      
│  │  ├─resources
│  │  │  │  application.yml			//全局配置文件
│  │  │  │  
│  │  │  ├─mapper
│  │  │  │      UserMapper.xml		//Mybatis的xml文件，里面是SQL语句	
│  │  │  │      
│  │  │  ├─static				//存放静态文件
│  │  │  │      1.jpg
│  │  │  │      2.jpg
│  │  │  │      3.png
│  │  │  │      
│  │  │  └─templates			//存放html等
│  │  │          first.html
│  │  │          second.html
│  │  │          
│  │  └─webapp
│  │      └─WEB-INF
│  │          └─jsp
│  │                  index.jsp		//做测试的网页，建议用thymeleaf与html

```
