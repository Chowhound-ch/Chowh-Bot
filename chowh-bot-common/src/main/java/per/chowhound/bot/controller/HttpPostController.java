package per.chowhound.bot.controller;

import cn.hutool.http.server.HttpServerRequest;
import org.springframework.context.event.EventListener;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import per.chowhound.bot.event.Event;
import per.chowhound.bot.event.HeartbeatEvent;
import per.chowhound.bot.event.LifecycleEvent;
import per.chowhound.bot.event.PrivateMessageEvent;
import per.chowhound.bot.msg.Messages;
import per.chowhound.bot.utils.JacksonUtil;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Objects;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 11:30
 */
@RestController
public class HttpPostController {

    @PostMapping("/**")
    public Mono<Map<String, Object>> post(@RequestBody String body, ServerHttpRequest request) {
        System.out.println("数据:" + body);
        System.out.println("uri:" + request.getPath());
        Event event = JacksonUtil.readValue(body, Event.class);
        System.out.println(event);

//        if (body.get("post_type").equals("message") && body.get("message_type").equals("private")) {
//            System.out.println("消息类型");
//            PrivateMessageEvent privateMessageEvent = JacksonUtil.readValue(jsonString, PrivateMessageEvent.class);
//            System.out.println(privateMessageEvent);
//            Messages messageTest = Messages.builder()
//                .text("回复")
//                .image("http://cdn.wolves.vip/img/ljenvuIEmM6LCerd-jSRUQFQi2dt.png"
//                ).build();
//            return Mono.just(Map.of("reply", messageTest));
//
//        } else if (body.get("post_type").equals("meta_event")) {
//            System.out.println("元事件");
//            if (body.get("meta_event_type").equals("lifecycle")) {
//                System.out.println("生命周期事件");
//                LifecycleEvent lifecycleEvent = JacksonUtil.readValue(jsonString, LifecycleEvent.class);
//                System.out.println(lifecycleEvent);
//            } else {
//                System.out.println("心跳事件");
//                HeartbeatEvent heartbeatEvent = JacksonUtil.readValue(jsonString, HeartbeatEvent.class);
//                System.out.println(heartbeatEvent);
//            }
//
//        }
//        if (map.get("post_type").equals("message") && map.get("message_type").equals("private")) {
//            System.out.println("消息类型");
//
//        }

        return Mono.just(Map.of("ddddd", "success"));
    }

}
