package per.chowhound.bot.register;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Listener {
    /**
     * 0 到 Integer.MAX_VALUE
     * 越小越先执行
     */
    int priority() default Integer.MAX_VALUE;
}
