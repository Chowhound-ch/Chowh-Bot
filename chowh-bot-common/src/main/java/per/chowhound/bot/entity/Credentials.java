package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 16:12
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class Credentials extends ExpendableEntity {
    private Long csrf_token;
    private String cookies;
}
