package per.chowhound.bot.spi;

import per.chowhound.bot.event.Event;
import per.chowhound.bot.event.response.EventResponse;
import reactor.core.publisher.Mono;

/**
 * @author : Chowhound
 * @since : 2024/9/15 - 17:35
 */
public interface QuickResponseService {

    Object handleQuickResponse(EventResponse response, Event event);

}
