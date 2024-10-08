package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : Chowhound
 * @since : 2024/8/8 - 23:34
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class Friend extends Member{
    private String remark;
}
