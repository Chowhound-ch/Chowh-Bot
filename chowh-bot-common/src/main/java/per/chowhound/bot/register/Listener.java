package per.chowhound.bot.register;

import per.chowhound.bot.filter.DefaultEventFilter;
import per.chowhound.bot.filter.EventFilter;

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

    /**
     * 仅用于显示
     */
    String name() default "";

    Class<? extends EventFilter> filter() default DefaultEventFilter.class;
}
