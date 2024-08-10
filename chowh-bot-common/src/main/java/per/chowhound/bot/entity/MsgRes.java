package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 20:43
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class MsgRes extends ExpendableEntity{
    private Long messageId;
}
