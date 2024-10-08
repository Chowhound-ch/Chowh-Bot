package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 22:03
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class RequestEvent extends AbstractEvent{
    // 请求类型
    private String requestType;
    // 请求 flag，在调用处理请求的 API 时需要传入
    private String flag;
    // 验证信息
    private String comment;
    private Long userId;
}
