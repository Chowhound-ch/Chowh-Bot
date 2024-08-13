package per.chowhound.bot.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import per.chowhound.bot.event.GroupMessageEvent;
import per.chowhound.bot.event.PrivateMessageEvent;


@Component
public class MessageListener {


    @EventListener
    public void privateMsg(PrivateMessageEvent event) {
        System.out.println("私聊消息：" + event);
    }

    @EventListener
    public void groupMsg(GroupMessageEvent event) {
        System.out.println("群聊消息：" + event);
    }
}
