package per.chowhound.bot.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class EventAspect {
    @Pointcut("@annotation(org.springframework.context.event.EventListener)")
    public void pointcut() {
    }


    @AfterReturning(value = "pointcut()", returning = "returnValue")
    public Object afterReturning(JoinPoint joinPoint, Object returnValue) throws Throwable {
        Signature signature = joinPoint.getSignature();
        if (log.isDebugEnabled()) {
            StringBuffer argsStr = new StringBuffer();
            for (Object arg : joinPoint.getArgs()) {
                argsStr.append(arg.toString()).append(",");
            }
            log.debug("事件处理结束: {}, 参数: {}, 方法返回值为: {}", signature.getName(), argsStr, returnValue);
        }
        if (returnValue instanceof Mono<?>) {

        }

        return returnValue;
    }

}
