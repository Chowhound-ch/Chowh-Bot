package per.chowhound.bot.register;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.chowhound.bot.entity.ExpendableEntity;
import per.chowhound.bot.entity.MsgRes;
import per.chowhound.bot.event.Event;
import per.chowhound.bot.register.exception.ListenerNotRegistryExecution;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Chowhound
 * @since : 2024/9/12 - 19:41
 */
@Slf4j
@Component
public class EventHandler {
    @Autowired
    private EventScanner eventScanner;

    public List<Mono<?>> handleEvent(Event event) {
        if (eventScanner.EVENT_MAP == null) {
            throw new ListenerNotRegistryExecution("Listener not registry execution");
        }
        List<Mono<?>> resList = new ArrayList<>();
        eventScanner.EVENT_MAP.get(event.getClass()).forEach(method -> {
            boolean accessed = eventScanner.EVENT_FILTER_MAP.get(method).filter(method, event);
            if (!accessed) {
                return;
            }

            Object res = null;
            try {
                res = method.invoke(event);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            if (res instanceof Mono) {
                resList.add((Mono<?>) res);
            }
        });
        return resList;
    }
}
