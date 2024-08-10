package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 14:34
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Member extends ExpendableEntity{
    private Long userId;

    private String nickname;
}
