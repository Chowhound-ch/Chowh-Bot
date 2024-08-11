package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupMessageRevokeEvent extends NoticeEvent{
    private Long groupId;
    private Long messageId;
    private Long operatorId;
}
