package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 16:50
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class VersionInfo extends ExpendableEntity {
    //应用标识，如 mirai-native
    private String app_name;
    //应用版本，如 1.2.3
    private String app_version;
    //OneBot 标准版本，如 v11
    private String protocol_version;
}
