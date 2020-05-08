package com.tencent.bbm.service.aspect;

import com.tencent.bbm.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author bbm
 * 切面
 */
@Aspect
@Component
public class LogAspect {
    /**
     * 定义切面
     */
    @Pointcut("@annotation(com.tencent.bbm.service.annotaion.MyAnnotation)")
    public void poitCut() { }

    /**
     *
     * @param joinPoint 切入点
     */
    @Before("poitCut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("before" + joinPoint.getSignature().getName());
        System.out.println("before" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("before" + joinPoint.getArgs());
    }

    /**
     * @param joinPoint after
     */
    @After("poitCut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("after执行结束" + joinPoint.getSignature().getName());
    }

    /**
     * @param joinPoint 切点
     * @param exception 异常
     */
    @AfterThrowing(value = "poitCut()", throwing = "exception")
    public void doThrowing(JoinPoint joinPoint, Throwable exception) {
        System.out.println("异常方法：" + joinPoint.getSignature().getName());
        System.out.println(exception.getMessage());
    }

    /**
     * @param proceedingJoinPoint 环绕
     * @return 返回
     * @throws Throwable 异常
     */
    @Around("poitCut()")
    public User aroudAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroud执行前……" + proceedingJoinPoint.getSignature().getName());
        User user = (User) proceedingJoinPoint.proceed();
        System.out.println("aroud执行后……" + proceedingJoinPoint.getSignature().getName());
        return user;
    }
}
