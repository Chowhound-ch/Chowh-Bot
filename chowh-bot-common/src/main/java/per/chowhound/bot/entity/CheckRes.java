package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 0:45
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class CheckRes extends ExpendableEntity{
    private boolean yes;
}
