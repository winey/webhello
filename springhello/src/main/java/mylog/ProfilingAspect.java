package mylog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.sql.SQLOutput;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 5. 27
 * Time: 오후 5:18
 * To change this template use File | Settings | File Templates.
 */
@Aspect
public class ProfilingAspect {

    //@Around("execution(public * *.*Log.*(..))")
    @Around("@target(org.springframework.stereotype.Component)")
    public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before joinPoint = [" + joinPoint + "]");
        Object proceed = joinPoint.proceed();
        System.out.println("after joinPoint = [" + joinPoint + "]");
        return proceed;
    }
}

