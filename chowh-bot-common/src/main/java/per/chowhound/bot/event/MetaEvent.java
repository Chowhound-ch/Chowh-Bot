package per.chowhound.bot.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 17:32
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class MetaEvent extends AbstractEvent {
    public static final String TYPE_LIFECYCLE = "lifecycle";
    public static final String TYPE_HEARTBEAT = "heartbeat";

    private String metaEventType;

}
