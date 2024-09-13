package per.chowhound.bot.event.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Chowhound
 * @since : 2024/9/13 - 22:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GroupAddResponse implements EventResponse{
    // 是否同意请求
    private Boolean approve = Boolean.FALSE;
    // 拒绝理由
    private String reason = "";

}
