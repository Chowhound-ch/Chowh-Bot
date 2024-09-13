package per.chowhound.bot.listener;

import org.springframework.stereotype.Component;
import per.chowhound.bot.Sender;
import per.chowhound.bot.entity.MsgRes;
import per.chowhound.bot.event.GroupMessageEvent;
import per.chowhound.bot.event.PrivateMessageEvent;
import per.chowhound.bot.event.response.EventResponse;
import per.chowhound.bot.event.response.FriendMsgResponse;
import per.chowhound.bot.event.response.GroupMsgResponse;
import per.chowhound.bot.register.EventMethod;
import per.chowhound.bot.register.Listener;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;


@Component
public class MessageListener {



    @Listener
    public Mono<EventResponse> privateMsg1(GroupMessageEvent event) {
        System.out.println("群消息：" + event);
        return Mono.just(new GroupMsgResponse("什么消息"));
    }


}
