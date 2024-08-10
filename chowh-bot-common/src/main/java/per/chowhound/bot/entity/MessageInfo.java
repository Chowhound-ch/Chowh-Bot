package per.chowhound.bot.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import per.chowhound.bot.msg.Messages;
import per.chowhound.bot.utils.MessagesDeserializer;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 1:54
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class MessageInfo extends ExpendableEntity{
    //发送时间
    private Long time;
    //消息类型，同 消息事件
    private String messageType;
    //消息 ID
    private Long messageId;
    //消息真实 ID
    private Long realId;
    //发送人信息，同 消息事件
    private GroupMember sender;
    //消息内容
    @JsonDeserialize(using = MessagesDeserializer.class)
    private Messages message;
}
