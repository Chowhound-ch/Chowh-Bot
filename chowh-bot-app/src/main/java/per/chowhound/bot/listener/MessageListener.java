package per.chowhound.bot.listener;

import org.springframework.stereotype.Component;
import per.chowhound.bot.Sender;
import per.chowhound.bot.entity.MsgRes;
import per.chowhound.bot.event.GroupMessageEvent;
import per.chowhound.bot.event.PrivateMessageEvent;
import per.chowhound.bot.register.Listener;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;


@Component
public class MessageListener {


    @Listener(priority = 0)
    public void privateMsg0(PrivateMessageEvent event) {
        System.out.println("私聊消息0000：" + event);
    }

    @Listener(priority = 1)
    public Mono<Result<MsgRes>> privateMsg1(PrivateMessageEvent event) {
        System.out.println("私聊消息1111：" + event);
        return Sender.sendPrivateMsg(825352674L, "1");
    }

    @Listener
    public void privateMsg(PrivateMessageEvent event) {
        System.out.println("私聊消息：" + event);
    }

    @Listener
    public Mono<Result<MsgRes>> groupMsg(GroupMessageEvent event) {
        System.out.println("群聊消息：" + event);
        return null;
    }
}
