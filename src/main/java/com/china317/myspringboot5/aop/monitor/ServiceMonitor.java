package com.china317.myspringboot5.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by lx-dong on 2017/11/6.
 */
@Aspect
@Component
public class ServiceMonitor {

    @AfterReturning(pointcut = "execution(* com.china317.myspringboot5.service..*.*Service(..))",returning = "ret")
    public void logServiceAccess(JoinPoint joinPoint, Object ret){
        System.out.println("Completed:" + joinPoint);
        System.out.println("Return:" + ret);
    }
}
