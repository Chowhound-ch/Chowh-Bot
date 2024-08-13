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
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageEvent extends AbstractEvent {
    // 消息类型
    protected String messageType;
    protected String subType;
    // 消息 ID
    protected Long messageId;
    // 发送者 QQ 号
    protected Long userId;
    // 消息内容
    protected Messages message;
    // 原始消息内容
    protected String rawMessage;
    // 字体
    protected Long font;
    // 发送人信息
    protected MessageSender sender;
}
