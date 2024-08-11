package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:50
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupMemberReduceEvent extends NoticeEvent{
    //leave、kick、kick_me	事件子类型，分别表示主动退群、成员被踢、登录号被踢
    private String subType;

    private Long groupId;


    private Long operatorId;
}
