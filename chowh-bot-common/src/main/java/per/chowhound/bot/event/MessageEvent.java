package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import per.chowhound.bot.Setter;
import per.chowhound.bot.entity.MessageSender;
import per.chowhound.bot.msg.Message;
import per.chowhound.bot.msg.Messages;
import per.chowhound.bot.msg.Text;


/**
 * @author : Chowhound
 * @since : 2024/8/11 - 13:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class MessageEvent extends AbstractEvent {
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


    public abstract void reply(Message message, Boolean autoEscape);

    public void reply(Message message) {
        this.reply(message, false);
    }

    public void reply(String message) {
        this.reply(Text.of(message));
    }

    public void delete() {
        Setter.deleteMsg(messageId);
    }
}
