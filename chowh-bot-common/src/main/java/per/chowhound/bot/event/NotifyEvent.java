package per.chowhound.bot.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 22:20
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        property = "sub_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = GroupPokeEvent.class, name = "poke"),
        @JsonSubTypes.Type(value = GroupEnvelopeLuckiestEvent.class, name = "lucky_king"),
        @JsonSubTypes.Type(value = GroupHonorChangeEvent.class, name = "honor"),
})
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class NotifyEvent extends NoticeEvent{
    private String subType;
    private String groupId;
}
