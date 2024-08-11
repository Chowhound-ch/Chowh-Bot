package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:56
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupPokeEvent extends NotifyEvent{
    private Long targetId;
}
