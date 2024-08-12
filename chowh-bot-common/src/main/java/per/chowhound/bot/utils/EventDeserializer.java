package per.chowhound.bot.utils;


import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeBuilder;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.extra.mail.MailUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.util.MultiValueMap;
import per.chowhound.bot.event.Event;
import per.chowhound.bot.event.MessageEvent;
import per.chowhound.bot.event.MetaEvent;
import per.chowhound.bot.event.NoticeEvent;
import per.chowhound.bot.msg.Message;
import per.chowhound.bot.msg.Messages;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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


    @Override
    public Event deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode root = mapper.readTree(jp);

        switch (root.get("post_type").asText()) {
            case "message": return JacksonUtil.readValue(root,  MessageEvent.class);
            case "meta_event": return JacksonUtil.readValue(root,  MetaEvent.class);
            case "notice": return JacksonUtil.readValue(root,  NoticeEvent.class);
            case ""
        }

        root.forEach( node -> messages.add(JacksonUtil.readValue(node, Message.class)));

        return messages;
    }
    @Data
    static class EventRelationTree {
        private boolean isEnd = false;
        private List<EventRelationTree> children;
        private String nextKey;
        private String value;
        private Class<Event> eventClass;

        private EventRelationTree(String rootKey) {
            this.nextKey = rootKey;
        }

        private EventRelationTree(String nextKey, String value) {
            this.nextKey = nextKey;
            this.value = value;
        }
        // key: String
        // value: Map<String, Map> | Map<String. Class>
//        public EventRelationTree(Map<String, Map<String, Object>> map) {
//            for (Map.Entry<String, Map> entry : map.entrySet()) {
//                Object value = entry.getValue();
//                if (value instanceof String) {
//                    String v = (String) value;
//
//
//                }
//            }
//        }

        public EventRelationTree from(Map<String, Class<Event>> map){
            for (Map.Entry<String, Class<Event>> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    String v = (String) value;


                }
            }
        }



    }
}