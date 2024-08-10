package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : Chowhound
 * @since : 2024/8/8 - 23:25
 */

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class Group extends ExpendableEntity{
    private Long groupId;

    private String groupName;

    private Integer memberCount;

    private Integer maxMemberCount;
}
