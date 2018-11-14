package com.wangning.example.demo.controller;


import com.sun.istack.internal.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component     //每个切面最终还是要扫面到斌容器里面去，成为bin容器的组件
@Order(4)
public class WebLogAspect {
    //获取日志记录器
    private Logger logger = Logger.getLogger(getClass());
    //获取线程副本
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.wangning.example.demo.controller.AopController.*(..))")
    public void weblog() {
        System.out.println("---------------weblog-----------------------");
    }

    @Before(value = "weblog()" )
    public void doBefore(JoinPoint joinPoint) {
        //获取请求报文头部元数据
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取请求对象
        HttpServletRequest request = requestAttributes.getRequest();
        //记录控制器执行前的时间毫秒数
        startTime.set(System.currentTimeMillis());
        logger.info("前置通知执行：");
        logger.info("url:" + request.getRequestURL());
        logger.info("method:" + request.getMethod());
        logger.info("ip:" + request.getRemoteAddr());
        logger.info("class_method:" + joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName());

        logger.info("args:" + Arrays.toString(joinPoint.getArgs()));

        logger.info("argsClassName:" +   joinPoint.getArgs()[0].getClass().getName());
    }

    @AfterReturning(returning = "ret", pointcut = "weblog()")
    public void doAfter(Object ret) {
        logger.info("后置通知执行：");
        logger.info("RESPONSE:" + ret);
        logger.info("spend:" + (System.currentTimeMillis() - startTime.get()));
    }


}
