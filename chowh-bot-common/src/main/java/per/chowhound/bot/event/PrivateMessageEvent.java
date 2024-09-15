package per.chowhound.bot.event;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import per.chowhound.bot.Sender;
import per.chowhound.bot.msg.Message;
import per.chowhound.bot.msg.Messages;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 13:22
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PrivateMessageEvent extends MessageEvent {

    @Override
    public void reply(Message message, Boolean autoEscape) {
        Sender.sendPrivateMsg(userId, Messages.replyOf(userId, message), autoEscape);
    }
}
