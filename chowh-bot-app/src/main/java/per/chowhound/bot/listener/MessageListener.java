package per.chowhound.bot.listener;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
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


    @Listener
    @EventListener
    public void privateMsg(PrivateMessageEvent event) {
        System.out.println("私聊消息：" + event);
    }

    @Listener
    @EventListener(condition = "#a0.userId == 825352674L")
    @Order(1)
    public Mono<Result<MsgRes>> groupMsg(GroupMessageEvent event) {
        System.out.println("群聊消息：" + event);
        return Sender.sendGroupMsg(event.getGroupId(), "1");
    }
}
