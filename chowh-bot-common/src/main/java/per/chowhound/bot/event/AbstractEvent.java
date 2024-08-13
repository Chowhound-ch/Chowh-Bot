package per.chowhound.bot.event;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.NullifyingDeserializer;
import lombok.*;
import per.chowhound.bot.entity.ExpendableEntity;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 13:21
 */
//@JsonDeserialize(using = NullifyingDeserializer.class)
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractEvent extends ExpendableEvent implements Event{
    // 事件发生的时间戳
    protected Long time;
    // 收到事件的机器人 QQ 号
    protected Long selfId;
    // 上报类型
    protected String postType;
}
