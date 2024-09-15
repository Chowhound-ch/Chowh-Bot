package per.chowhound.bot.event.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import per.chowhound.bot.event.Event;
import per.chowhound.bot.event.GroupAddRequestEvent;

/**
 * @author : Chowhound
 * @since : 2024/9/13 - 22:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Log
@Data
public class GroupAddResponse implements EventResponse{
    // 是否同意请求
    private Boolean approve = Boolean.FALSE;
    // 拒绝理由
    private String reason = "";



    @Override
    public void imitateResponse(Event event) {
        if (! (event instanceof GroupAddRequestEvent groupAddRequest)) {
            log.warning("不支持的事件类型");
            return;
        }
        if (approve) {
            groupAddRequest.approve();
        } else {
            groupAddRequest.reject(reason);
        }
    }
}
