package per.chowhound.bot.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import per.chowhound.bot.msg.Forward;
import per.chowhound.bot.msg.AbstractMessage;
import per.chowhound.bot.msg.Messages;
import per.chowhound.bot.msg.Text;

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
        root.forEach( node -> messages.add(deserializeMessage(node)));

        return messages;
    }

    public static AbstractMessage deserializeMessage(JsonNode node) {
        String type = node.get("type").asText();
        return switch (type) {
            case "text" -> Text.of(node.get("data").get("text").asText());
            case "forward" -> new Forward();
            default -> null;
        };
    }
}
