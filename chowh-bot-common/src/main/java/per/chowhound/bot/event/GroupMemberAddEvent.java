package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupMemberAddEvent extends NoticeEvent{
    // approve、invite	事件子类型，分别表示管理员已同意入群、管理员邀请入群
    private String subType;

    private Long groupId;


    private Long operatorId;
}
