package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import per.chowhound.bot.MonoSender;
import per.chowhound.bot.Sender;
import per.chowhound.bot.Setter;
import per.chowhound.bot.entity.Anonymous;
import per.chowhound.bot.entity.GroupMessageSender;
import per.chowhound.bot.msg.Message;
import per.chowhound.bot.msg.Messages;
import per.chowhound.bot.msg.Reply;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupMessageEvent extends MessageEvent {
    // 消息子类型，正常消息是 normal，匿名消息是 anonymous，系统提示（如「管理员已禁止群内匿名聊天」）是 notice
    protected String subType;
    // 消息类型
    protected String messageType;
    // 群号
    private Long groupId;
    // 匿名信息，如果不是匿名消息则为 null
    private Anonymous anonymous;

    private GroupMessageSender sender;

    public void reply(Message message, Boolean atSender, Boolean autoEscape) {
        Messages.Builder msgBuilder = Messages.builder().reply(messageId);
        if (atSender) {
            msgBuilder.at(sender.getUserId());
        }
        msgBuilder.add(message);

        Sender.sendGroupMsg(groupId, msgBuilder.build(), autoEscape);
    }

    @Override
    public void reply(Message message, Boolean autoEscape) {
        reply(message, true, autoEscape);
    }
}
