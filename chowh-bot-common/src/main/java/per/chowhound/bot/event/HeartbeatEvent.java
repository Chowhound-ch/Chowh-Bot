package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import per.chowhound.bot.entity.Status;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 19:46
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HeartbeatEvent extends MetaEvent {
    private Status status;

    // 到下次心跳的间隔，单位毫秒
    private Long interval;

}
