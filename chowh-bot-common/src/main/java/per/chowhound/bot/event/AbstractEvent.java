package per.chowhound.bot.event;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.NullifyingDeserializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import per.chowhound.bot.entity.ExpendableEntity;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 13:21
 */
@JsonDeserialize(using = NullifyingDeserializer.class)
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractEvent extends ExpendableEntity implements Event{
    // 事件发生的时间戳
    private Long time;
    // 收到事件的机器人 QQ 号
    private Long selfId;
    // 上报类型
    private String postType;
}
