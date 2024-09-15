package per.chowhound.bot.listener;

import org.springframework.stereotype.Component;
import per.chowhound.bot.MonoSender;
import per.chowhound.bot.Sender;
import per.chowhound.bot.event.GroupMessageEvent;
import per.chowhound.bot.event.PrivateMessageEvent;
import per.chowhound.bot.event.response.EventResponse;
import per.chowhound.bot.event.response.FriendMsgResponse;
import per.chowhound.bot.event.response.GroupMsgResponse;
import per.chowhound.bot.register.Listener;
import reactor.core.publisher.Mono;


@Component
public class MessageListener {



    @Listener
    public EventResponse privateMsg1(PrivateMessageEvent event) {
        event.reply("什么消息1d1dasd");
        MonoSender.sendPrivateMsg(event.getSender().getUserId(), "什么消息1d1dasd").subscribe();

        return new FriendMsgResponse("什么消息");
    }


}
