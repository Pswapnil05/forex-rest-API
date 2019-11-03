package com.innovecture.forex.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Around("execution(* com.innovecture.forex.service..*(..))")
  public Object performanceOfAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

    String className = methodSignature.getDeclaringType().getSimpleName();
    String methodName = methodSignature.getName();

    final StopWatch stopWatch = new StopWatch();

    stopWatch.start();
    Object result = proceedingJoinPoint.proceed();
    stopWatch.stop();

    logger.info("Execution time of "+className+"."+methodName+" :: "+stopWatch.getTotalTimeMillis()+" ms ");
    return result;
  }


}
