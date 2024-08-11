package per.chowhound.bot.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 19:41
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        property = "post_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MessageEvent.class, name = "message"),
        @JsonSubTypes.Type(value = MetaEvent.class, name = "meta_event"),
        @JsonSubTypes.Type(value = NoticeEvent.class, name = "notice"),
        @JsonSubTypes.Type(value = RequestEvent.class, name = "request"),
})
public interface Event {
}
