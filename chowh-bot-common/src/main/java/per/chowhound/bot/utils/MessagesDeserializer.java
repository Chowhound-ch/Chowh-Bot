package per.chowhound.bot.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import per.chowhound.bot.msg.*;

import java.io.IOException;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 13:54
 */
public class MessagesDeserializer extends JsonDeserializer<Messages> {
    @Override
    public Messages deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode root = mapper.readTree(jp);

        Messages messages = new Messages(root.size());
        root.forEach( node -> messages.add(JacksonUtil.readValue(node, Message.class)));

        return messages;
    }
}
