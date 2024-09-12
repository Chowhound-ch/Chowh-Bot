package per.chowhound.bot.filter;

import per.chowhound.bot.event.Event;
import per.chowhound.bot.filter.exception.FilterUndefinedException;
import per.chowhound.bot.register.Listener;

import java.lang.reflect.Method;

/**
 * @author : Chowhound
 * @since : 2024/9/12 - 21:21
 */
public abstract class AbstractEventFilter implements EventFilter {
    private Listener listener;

    public AbstractEventFilter(Listener listener) {
        this.listener = listener;
    }

    @Override
    public boolean filter(Method method, Event event) {
        return false;
    }

    @Override
    public Listener getListener() {
        return null;
    }
}
