package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 15:26
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupHonorInfo extends ExpendableEntity {
    private Long groupId;

    // 当前龙王, 仅 type 为 talkative 或 all 时有数据
    private GroupHonor currentTalkative;

    // 历史龙王, 仅 type 为 talkative 或 all 时有数据
    private List<GroupHonor> talkativeList;

    // 群聊之火, 仅 type 为 performer 或 all 时有数据
    private List<GroupHonor> performerList;

    // 群聊炽焰, 仅 type 为 legend 或 all 时有数据
    private List<GroupHonor> legendList;

    // 冒尖小春笋, 仅 type 为 strong_newbie 或 all 时有数据
    private List<GroupHonor> strongNewbieList;

    // 快乐之源, 仅 type 为 emotion 或 all 时有数据
    private List<GroupHonor> emotionList;
}
