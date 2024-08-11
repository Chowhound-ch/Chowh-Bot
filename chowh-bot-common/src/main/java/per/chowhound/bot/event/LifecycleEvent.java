package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 19:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LifecycleEvent extends MetaEvent {
    public static final String TYPE_ENABLE = "enable";
    public static final String TYPE_DISABLE = "disable";
    public static final String TYPE_CONNECT = "connect";

    private String subType;
}
