package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 16:48
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class Status extends ExpendableEntity {
    private boolean online;

    private boolean good;
}
