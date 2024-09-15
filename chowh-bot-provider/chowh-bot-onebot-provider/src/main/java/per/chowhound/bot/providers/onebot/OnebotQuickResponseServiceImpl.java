package per.chowhound.bot.providers.onebot;

import per.chowhound.bot.event.Event;
import per.chowhound.bot.event.response.EventResponse;
import per.chowhound.bot.spi.QuickResponseService;
import reactor.core.publisher.Mono;

/**
 * @author : Chowhound
 * @since : 2024/9/15 - 17:37
 */
public class OnebotQuickResponseServiceImpl implements QuickResponseService {
    @Override
    public Object handleQuickResponse(EventResponse response, Event event) {
        return response;
    }
}
