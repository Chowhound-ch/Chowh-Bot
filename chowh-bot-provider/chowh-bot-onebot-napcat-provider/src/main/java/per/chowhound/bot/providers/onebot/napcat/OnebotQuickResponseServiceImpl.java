package per.chowhound.bot.providers.onebot.napcat;

import per.chowhound.bot.event.Event;
import per.chowhound.bot.event.response.EventResponse;
import per.chowhound.bot.spi.QuickResponseService;
import reactor.core.publisher.Mono;

/**
 * @author : Chowhound
 * @since : 2024/9/15 - 17:37
 */
public class OnebotQuickResponseServiceImpl implements QuickResponseService {
    /**
     * napcat没发现有支持快速响应，通过多次请求来实现
     */
    @Override
    public Object handleQuickResponse(EventResponse response, Event event) {
        response.imitateResponse(event);
        return null;
    }
}
