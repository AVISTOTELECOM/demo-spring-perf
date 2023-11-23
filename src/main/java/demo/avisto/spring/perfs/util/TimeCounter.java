package demo.avisto.spring.perfs.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class TimeCounter {

    @SneakyThrows
    @Around("@annotation(demo.avisto.spring.perfs.util.TimeStatistic)")
    public void timeCounter(ProceedingJoinPoint pjp) {
        long startTime = System.nanoTime();
        pjp.proceed();
        long endTime = System.nanoTime();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        String message = method.getAnnotation(TimeStatistic.class).value();
        log.info(message, (endTime - startTime) / 1000000);
    }
}
