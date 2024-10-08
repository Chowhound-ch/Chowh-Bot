package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/8 - 23:34
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Bot extends ExpendableEntity{
    private Long userId;

    private String nickname;
}
