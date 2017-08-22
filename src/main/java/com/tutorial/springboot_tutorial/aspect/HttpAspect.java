package com.tutorial.springboot_tutorial.aspect;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by JeremyLiu on 21/08/2017.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    // .. means method will be intercepted no matter what the params are
    @Pointcut("execution(public * com.tutorial.springboot_tutorial.controller.EmployeeController.*(..))")
    public void log() {
    }

    // @Before("execution(public * com.tutorial.springboot_tutorial.controller.EmployeeController.*(..))")
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("************ Method is intercepted ************");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // url
        logger.info("url={}", request.getRequestURL());

        // request method
        logger.info("method={}", request.getMethod());

        // ip
        logger.info("ip={}", request.getRemoteAddr());

        // class method
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        // params
        logger.info("args={}", joinPoint.getArgs());
    }

    // @After("execution(public * com.tutorial.springboot_tutorial.controller.EmployeeController.*(..))")
    @After("log()")
    public void doAfter() {
        logger.info("************ Method ends ************");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}
