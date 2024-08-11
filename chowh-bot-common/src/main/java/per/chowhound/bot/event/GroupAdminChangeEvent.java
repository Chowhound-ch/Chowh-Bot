package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupAdminChangeEvent extends NoticeEvent{
    // 群号
    private String groupId;
    // set、unset	事件子类型，分别表示设置和取消管理员
    private String subType;
}
