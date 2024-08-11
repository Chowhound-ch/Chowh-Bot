package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:36
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupMessageSender extends MessageSender{
    // 群名片／备注
    private String card;
    // 地区
    private String area;
    // 等级
    private String level;
    // 角色
    private String role;
    // 专属头衔
    private String title;
}
