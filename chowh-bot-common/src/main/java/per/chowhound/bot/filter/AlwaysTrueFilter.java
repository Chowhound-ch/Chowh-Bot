package per.chowhound.bot.filter;

import per.chowhound.bot.event.Event;
import per.chowhound.bot.register.Listener;

import java.lang.reflect.Method;

/**
 * @author : Chowhound
 * @since : 2024/9/12 - 21:43
 */
public class AlwaysTrueFilter extends AbstractEventFilter{
    public AlwaysTrueFilter(Listener listener) {
        super(listener);
    }

    @Override
    public boolean filter(Method method, Event event) {
        return true;
    }
}
