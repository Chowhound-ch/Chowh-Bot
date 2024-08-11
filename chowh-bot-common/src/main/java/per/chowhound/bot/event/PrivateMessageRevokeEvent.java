package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PrivateMessageRevokeEvent extends NoticeEvent{
    private Long messageId;
}
