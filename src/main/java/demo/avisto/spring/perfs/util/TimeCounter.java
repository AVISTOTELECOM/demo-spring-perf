package demo.avisto.spring.perfs.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class TimeCounter {

    @Around("@annotation(timeStatistic)")
    public Object timeCounter(ProceedingJoinPoint pjp, TimeStatistic timeStatistic) throws Throwable {
        long startTime = System.nanoTime();
        Object res = pjp.proceed();
        long endTime = System.nanoTime();
        log.info(timeStatistic.value(), (endTime - startTime) / 1000000);
        return res;
    }
}
