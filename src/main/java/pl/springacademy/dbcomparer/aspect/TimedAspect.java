package pl.springacademy.dbcomparer.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
@RequiredArgsConstructor
public class TimedAspect {

    @Around(value = "@annotation(pl.springacademy.dbcomparer.aspect.Timed)")
    public Object countExecutionTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        final String className = methodSignature.getDeclaringType().getSimpleName();
        final String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch(className + "->" + methodName);
        stopWatch.start(methodName);
        final Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        if (log.isInfoEnabled()) {
            log.info(stopWatch.prettyPrint());
        }
        return result;
    }
}
