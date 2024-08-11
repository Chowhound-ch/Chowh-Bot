package per.chowhound.bot.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import per.chowhound.bot.msg.*;

import java.io.IOException;

public class MessageDeserializer extends JsonDeserializer<Message> {

    @Override
    public Message deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        if (node.isArray()) {
            return JacksonUtil.readValue(node, Messages.class);
        } else {
            return deserializeMessage(node);
        }
    }

    public static Message deserializeMessage(JsonNode node) {
        String type = node.get("type").asText();
        return switch (type) {
            case "text" -> Text.of(node.get("data").get("text").asText());
            case "forward" -> new Forward();
            case "image" -> Image.of(node.get("data").get("file").asText());
            default -> null;
        };
    }
}