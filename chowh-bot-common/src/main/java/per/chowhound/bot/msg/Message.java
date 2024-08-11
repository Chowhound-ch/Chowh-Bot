package per.chowhound.bot.msg;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import per.chowhound.bot.utils.MessageDeserializer;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 20:54
 */
@JsonDeserialize(using = MessageDeserializer.class)
public interface Message {
}
