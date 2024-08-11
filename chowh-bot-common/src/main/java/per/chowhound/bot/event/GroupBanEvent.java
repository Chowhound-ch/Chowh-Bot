package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupBanEvent extends NoticeEvent{
    // ban、lift_ban	事件子类型，分别表示禁言、解除禁言
    private String subType;

    private Long operatorId;
    // 群号
    private Long groupId;
    // 禁言时长，单位秒
    private Long duration;
}
