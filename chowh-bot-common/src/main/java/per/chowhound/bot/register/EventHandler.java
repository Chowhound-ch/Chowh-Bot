package per.chowhound.bot.register;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.chowhound.bot.event.Event;
import per.chowhound.bot.event.response.EventResponse;
import per.chowhound.bot.register.exception.ListenerNotRegistryExecution;
import per.chowhound.bot.spi.GetterService;
import per.chowhound.bot.spi.QuickResponseService;
import reactor.core.publisher.Mono;

import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : Chowhound
 * @since : 2024/9/12 - 19:41
 */
@Slf4j
@Component
public class EventHandler {
    @Autowired
    private EventScanner eventScanner;


    public Mono<EventResponse> handleEvent(Event event) {
        if (eventScanner.EVENT_MAP == null) {
            throw new ListenerNotRegistryExecution("Listener not registry execution");
        }
        AtomicReference<Mono<EventResponse>> responseMono = new AtomicReference<>();
        eventScanner.EVENT_MAP.get(event.getClass()).forEach(method -> {
            if (!method.isAccessed(event)) {
                return;
            }

            Object res = method.invoke(event);

            if (responseMono.get() == null) {
                if (! (res instanceof Mono<?>)) {
                    res = Mono.just(res);
                }
                Mono<EventResponse> newValue = ((Mono<?>) res).cast(EventResponse.class)
                            .onErrorResume(signal -> {
                        log.error("事件监听方法返回值类型错误: {}, 应该为Mono<? extend EventResponse>", method.getEventName());
                        return Mono.empty();
                    });
                newValue.hasElement().subscribe(value -> {
                    if (value) {
                        responseMono.set(newValue);
                    }
                });
            }
        });
        return responseMono.get();
    }
}
