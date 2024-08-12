package per.chowhound.bot.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import per.chowhound.bot.utils.EventDeserializer;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 19:41
 */
@JsonDeserialize(using = EventDeserializer.class)
public interface Event {
}
