package per.chowhound.bot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 15:46
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageSender extends ExpendableEntity{
    //发送者QQ号
    private Long userId;
    //昵称
    private String nickname;
    //性别，male 或 female 或 unknown
    private String sex;
    // 年龄
    private Long age;
}
