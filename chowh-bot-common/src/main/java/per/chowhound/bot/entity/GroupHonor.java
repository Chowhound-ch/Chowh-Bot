package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 15:23
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupHonor extends Member{
    // 龙王
    public static final String TYPE_TALKATIVE = "talkative";
    // 群聊之火
    public static final String TYPE_PERFORMER = "performer";
    // 群聊炽焰
    public static final String TYPE_LEGEND = "legend";
    // 冒尖小春笋
    public static final String TYPE_STRONG_NEWBIE = "strong_newbie";
    // 快乐之源
    public static final String TYPE_EMOTION = "emotion";
    // 全部
    public static final String TYPE_ALL = "all";

    private String avatar;

    private Long day_count;

    private String description;
}
