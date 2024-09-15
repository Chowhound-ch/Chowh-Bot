package per.chowhound.bot.event.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import per.chowhound.bot.MonoSender;
import per.chowhound.bot.Sender;
import per.chowhound.bot.event.Event;
import per.chowhound.bot.event.PrivateMessageEvent;
import per.chowhound.bot.msg.Message;
import per.chowhound.bot.msg.Text;

/**
 * @author : Chowhound
 * @since : 2024/9/13 - 21:53
 */
@NoArgsConstructor
@SuppressWarnings("unused")
@Log
@Data
public class FriendMsgResponse implements EventResponse {
    private Message reply;
    private Boolean autoEscape = false;

    @Override
    public void imitateResponse(Event event) {
        if (! (event instanceof PrivateMessageEvent privateMessageEvent)) {
            log.warning("不支持的事件类型");
            return;
        }
        privateMessageEvent.reply(reply,autoEscape);
    }

    public FriendMsgResponse(Message reply) {
        this.reply = reply;
    }

    public FriendMsgResponse(String reply) {
        this.reply = Text.of(reply);
    }

    public FriendMsgResponse(Message reply, Boolean autoEscape) {
        this.reply = reply;
        this.autoEscape = autoEscape;
    }

    public FriendMsgResponse(String  reply, Boolean autoEscape) {
        this.reply = Text.of(reply);
        this.autoEscape = autoEscape;
    }

    public void setReply(String reply) {
        this.reply = Text.of(reply);
    }
}
