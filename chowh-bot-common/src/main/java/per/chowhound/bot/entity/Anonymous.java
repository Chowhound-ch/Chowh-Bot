package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:32
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class Anonymous extends ExpendableEntity{
    // 匿名用户ID
    private Long id;
    //  匿名用户名称
    private String name;
    // 匿名用户 flag，在调用禁言 API 时需要传入
    private String flag;
}
