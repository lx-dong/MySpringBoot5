package com.china317.myspringboot5.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by lx-dong on 2017/11/6.
 */
@Aspect
@Component
public class ServiceMonitor {
    Logger logger = LoggerFactory.getLogger(ServiceMonitor.class);

    @AfterReturning(value = "execution(public * com.china317.myspringboot5.service..*.*Service.*(..))",returning = "ret")
    public void logServiceAccess(JoinPoint joinPoint, Object ret){
        logger.info("============AOP=============== Completed:" + joinPoint);
        logger.info("============AOP=============== Return:" + ret);
    }
}
