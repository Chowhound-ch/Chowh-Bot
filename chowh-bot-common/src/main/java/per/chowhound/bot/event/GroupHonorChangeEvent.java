package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 22:01
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupHonorChangeEvent extends NotifyEvent{
    // talkative、performer、emotion	荣誉类型，分别表示龙王、群聊之火、快乐源泉
    private String honorType;
}
