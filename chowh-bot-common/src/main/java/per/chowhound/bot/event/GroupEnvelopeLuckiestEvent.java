package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:58
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupEnvelopeLuckiestEvent extends NotifyEvent{
    // 运气王 QQ 号
    private Long targetId;
}
