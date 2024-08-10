package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 1:55
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupMember extends Member{
    private Long groupId;

    // 群名片 / 备注
    private String card;

    // 性别，male 或 female 或 unknown
    private String sex;

    // 年龄
    private Integer age;

    // 地区
    private String area;

    // 加群时间戳
    private Long joinTime;

    // 最后发言时间戳
    private Long lastSentTime;

    // 成员等级
    private String level;

    // 角色，owner 或 admin 或 member
    private String role;

    // 是否不良记录成员
    private Boolean unfriendly;

    // 专属头衔
    private String title;

    // 专属头衔过期时间戳
    private Long titleExpireTime;

    // 是否允许修改群名片
    private Boolean cardChangeable;
}
