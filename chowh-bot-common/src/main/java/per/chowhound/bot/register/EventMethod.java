package per.chowhound.bot.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import per.chowhound.bot.filter.EventFilter;

import java.lang.reflect.Method;

@AllArgsConstructor
@Data
public class EventMethod {
    private Method method;

    private EventFilter eventFilter;

    private Object target;
}
