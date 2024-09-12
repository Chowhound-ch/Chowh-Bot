package per.chowhound.bot.filter;

import per.chowhound.bot.event.Event;
import per.chowhound.bot.register.Listener;

import java.lang.reflect.Method;

/**
 * @author : Chowhound
 * @since : 2024/9/12 - 20:34
 */
public interface EventFilter {
    boolean filter(Method method, Event event);

    Listener getListener();
}
