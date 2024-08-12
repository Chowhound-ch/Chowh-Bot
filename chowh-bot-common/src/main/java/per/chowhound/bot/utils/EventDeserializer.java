package per.chowhound.bot.utils;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import per.chowhound.bot.event.*;

import java.io.IOException;
import java.util.*;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
//        property = "post_type"
//)
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = MessageEvent.class, name = "message"),
//        @JsonSubTypes.Type(value = MetaEvent.class, name = "meta_event"),
//        @JsonSubTypes.Type(value = NoticeEvent.class, name = "notice"),
//        @JsonSubTypes.Type(value = RequestEvent.class, name = "request"),
//})
public class EventDeserializer extends JsonDeserializer<Event> {
    private static final EventRelationTree EVENT_RELATION_TREE = EventDeserializer.EventRelationTree.buildTree("post_type",
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


    @Override
    public Event deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode root = mapper.readTree(jp);
        return JacksonUtil.readValue(root, EVENT_RELATION_TREE.search(root));
    }

    @Data
    static class EventRelationTree {
        private List<EventRelationTree> children;
        private String nextKey;
        private String value;
        private Class<Event> eventClass;

        private EventRelationTree(String rootKey) {
            this.nextKey = rootKey;
        }

        public EventRelationTree(Class<Event> eventClass) {
            this.eventClass = eventClass;
        }
        public static EventRelationTree buildTree(String rootKey, Map<String[], Object> map) {
            EventRelationTree root = new EventRelationTree(rootKey);
            root.children = map.entrySet().stream().map(entry -> {
                Object entryValue = entry.getValue();
                String[] key = entry.getKey();
                EventRelationTree eventRelationTree;
                if (entryValue instanceof Class<?>) {
                    eventRelationTree = new EventRelationTree((Class<Event>) entryValue);
                } else {
                    eventRelationTree = buildTree(key[1], (Map<String[], Object>) entryValue);
                    eventRelationTree.setNextKey(key[1]);
                }
                eventRelationTree.setValue(key[0]);
                return eventRelationTree;
            }).toList();
            return root;
        }
        public Class<Event> search(JsonNode node) {
            if (eventClass != null) {
                return eventClass;
            }
            JsonNode nextNode = node.get(nextKey);
            for (EventRelationTree child : children) {
                if (child.value.equals(nextNode.asText())) {
                    return child.search(node);
                }
            }
            return null;
        }

    }
}