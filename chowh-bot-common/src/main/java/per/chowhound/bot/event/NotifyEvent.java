package per.chowhound.bot.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 22:20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class NotifyEvent extends NoticeEvent{
    private String subType;
    private String groupId;
}
