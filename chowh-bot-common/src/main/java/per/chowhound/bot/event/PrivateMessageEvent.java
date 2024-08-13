package per.chowhound.bot.event;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 13:22
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PrivateMessageEvent extends MessageEvent {
//    // 消息子类型，如果是好友则是 friend，如果是群临时会话则是 group
//    private String subType;
//    // 消息类型
//    private String messageType;
}
