package per.chowhound.bot.event.response;

import per.chowhound.bot.event.Event;

/**
 * @author : Chowhound
 * @since : 2024/9/13 - 21:52
 */
public interface EventResponse {

    /**
     * 对于不支持快速响应的平台，通过其他方式来模拟快速响应
     */
    default void imitateResponse(Event event){
    }

}
