package com.drtrue.global.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Sample AOP Aspect 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Aspect
@Slf4j
@Component
public class PerformanceAOPAspect {

    /**
     * 성능 측정 Aspect 정의
     * 
     * @param proceedingJoinPoint
     * @return Object
     * @since 1.0
     */
    @Around("@annotation(com.drtrue.global.aop.annotations.PerformanceAOPAnnotation)")
    public Object logging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        log.info("=========================PerformanceAOPAspect=========================");
        log.info("target class : " + proceedingJoinPoint.getTarget().toString());
        long startTime = System.currentTimeMillis();
        Object proceedReturnValue = proceedingJoinPoint.proceed();
        long estimatedTime = System.currentTimeMillis() - startTime;
        log.info("수행 시간 : " + estimatedTime);
        log.info("=========================PerformanceAOPAspect=========================");
        return proceedReturnValue;
    }

}
