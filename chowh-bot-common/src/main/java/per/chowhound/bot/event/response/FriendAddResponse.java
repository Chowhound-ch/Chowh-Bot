package per.chowhound.bot.event.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Chowhound
 * @since : 2024/9/13 - 22:02
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FriendAddResponse implements EventResponse {
    // 是否同意请求
    private Boolean approve = Boolean.FALSE;
    // 添加后的好友备注（仅在同意时有效）
    private String remark = "";

}
