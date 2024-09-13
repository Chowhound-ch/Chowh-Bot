package per.chowhound.bot.controller;

import cn.hutool.http.server.HttpServerRequest;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import per.chowhound.bot.event.*;
import per.chowhound.bot.event.response.EventResponse;
import per.chowhound.bot.msg.Messages;
import per.chowhound.bot.register.EventHandler;
import per.chowhound.bot.utils.EventDeserializer;
import per.chowhound.bot.utils.JacksonUtil;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 11:30
 */
@RestController
public class HttpPostController {
    private static final EventDeserializer.EventRelationTree EVENT_RELATION_TREE = EventDeserializer.EventRelationTree.buildTree("post_type",
            Map.of(
                    new String[]{"message", "message_type"}, Map.of(
                            new String[]{"private"}, PrivateMessageEvent.class,
                            new String[]{"group"}, GroupMessageEvent.class),
                    new String[]{"meta_event", "meta_event_type"}, Map.of(
                            new String[]{"lifecycle"}, LifecycleEvent.class,
                            new String[]{"heartbeat"}, HeartbeatEvent.class),
                    new String[]{"notice", "notice_type"}, Map.of(
                            new String[]{"group_upload"}, GroupUploadEvent.class,
                            new String[]{"group_admin"}, GroupAdminChangeEvent.class,
                            new String[]{"group_decrease"}, GroupMemberReduceEvent.class,
                            new String[]{"group_increase"}, GroupMemberAddEvent.class,
                            new String[]{"friend_add"}, FriendAddEvent.class,
                            new String[]{"group_recall"}, GroupMessageRevokeEvent.class,
                            new String[]{"friend_recall"}, PrivateMessageRevokeEvent.class,
                            new String[]{"group_ban"}, GroupBanEvent.class,
                            new String[]{"notify", "sub_type"}, Map.of(
                                    new String[]{"lucky_king"}, GroupEnvelopeLuckiestEvent.class,
                                    new String[]{"poke"}, GroupPokeEvent.class,
                                    new String[]{"honor"}, GroupHonorChangeEvent.class))
            )
    );

    @Autowired
    private EventHandler handler;

    @PostMapping("/**")
    public Mono<EventResponse> post(@RequestBody String body, ServerHttpRequest request) {
        System.out.println("数据:" + body);
        System.out.println("uri:" + request.getPath());
        JsonNode jsonNode = JacksonUtil.readTree(body);
        Event event = JacksonUtil.readValue(body, EVENT_RELATION_TREE.search(jsonNode));
        Mono<EventResponse> monos = handler.handleEvent(event);
        System.out.println(event);
        System.out.println(monos);

        return monos;
    }

}
