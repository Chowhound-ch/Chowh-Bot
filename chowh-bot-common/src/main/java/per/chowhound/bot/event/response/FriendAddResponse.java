package per.chowhound.bot.event.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import per.chowhound.bot.event.Event;
import per.chowhound.bot.event.FriendAddRequestEvent;

/**
 * @author : Chowhound
 * @since : 2024/9/13 - 22:02
 */
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FriendAddResponse implements EventResponse {
    // 是否同意请求
    private Boolean approve = Boolean.FALSE;
    // 添加后的好友备注（仅在同意时有效）
    private String remark = "";

    public void imitateResponse(Event event) {
        if (!(event instanceof FriendAddRequestEvent friendAddRequest)) {
            log.warn("不支持的事件类型");
            return;
        }
        if (approve) {
            friendAddRequest.approve(remark);
        } else {
            friendAddRequest.reject();
        }
    }
}
