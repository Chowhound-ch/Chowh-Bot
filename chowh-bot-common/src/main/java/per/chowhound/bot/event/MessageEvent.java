package per.chowhound.bot.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import per.chowhound.bot.entity.MessageSender;
import per.chowhound.bot.msg.Messages;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 13:21
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        property = "message_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PrivateMessageEvent.class, name = "private"),
        @JsonSubTypes.Type(value = GroupMessageEvent.class, name = "group"),
})
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageEvent extends AbstractEvent {
    // 消息类型
    private String messageType;
    protected String subType;
    // 消息 ID
    private Long messageId;
    // 发送者 QQ 号
    private Long userId;
    // 消息内容
    private Messages message;
    // 原始消息内容
    private String rawMessage;
    // 字体
    private Long font;
    // 发送人信息
    private MessageSender sender;
}
