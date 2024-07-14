package in.ineuron.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {

    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    //syntax :: Aspect return type packageName.className.methodName(parameter)
    @Pointcut ("execution(public * in.ineuron.*.*.*(..))")
    public void myPointcut(){

    }

    @Around("myPointcut()")
   public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
       ObjectMapper objectMapper = new ObjectMapper();
       String methodName = proceedingJoinPoint
               .getSignature()
               .getName();
       String className = proceedingJoinPoint
               .getTarget()
               .getClass()
               .toString();
       Object[] array = proceedingJoinPoint.getArgs();
       log.info("method invoked " + className + " : " + methodName + "()" + "arguments : " + objectMapper.writeValueAsString(array));
       Object object = proceedingJoinPoint.proceed();
       log.info(className + " : " + methodName + "()" + "Response : " + objectMapper.writeValueAsString(object));
       return object;
   }
}
