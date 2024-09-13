package per.chowhound.bot.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import per.chowhound.bot.event.Event;
import per.chowhound.bot.filter.EventFilter;

import java.lang.reflect.Method;

@Slf4j
@AllArgsConstructor
@Data
@Getter
public class EventMethod {
    private Method method;

    private EventFilter eventFilter;

    private Object target;

    public Object invoke(Object... args) {
        try {
            return method.invoke(target, args);
        } catch (Exception e) {
            log.error("监听器执行失败: {}", e.getMessage());
        }
        return null;
    }

    public Boolean isAccessed(Event event) {
        return eventFilter.filter(method, event);
    }

    public String getEventName() {
        Listener listener = eventFilter.getListener();
        if (listener == null) {
            return method.getName();
        }
        return "".equals(listener.name()) ? method.getName() : listener.name();
    }
}
