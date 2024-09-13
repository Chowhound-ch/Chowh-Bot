package per.chowhound.bot.register.utils;

import per.chowhound.bot.register.Listener;

import java.lang.reflect.Method;

/**
 * @author : Chowhound
 * @since : 2024/9/12 - 21:49
 */
@SuppressWarnings("unused")
public class EventUtil {
    public static String getEventName(Method method) {
        if (method == null) {
            return null;
        }
        Listener annotation = method.getAnnotation(Listener.class);
        if (annotation == null) {
            return method.getName();
        }
        return getEventName(annotation, method.getName());
    }

    public static String getEventName(Listener listener, String defaultName) {
        if (listener == null) {
            return null;
        }
        return "".equals(listener.name()) ? defaultName : listener.name();
    }
}
