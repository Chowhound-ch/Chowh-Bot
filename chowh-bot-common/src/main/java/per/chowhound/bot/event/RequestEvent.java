package per.chowhound.bot.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 22:03
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        property = "request_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FriendAddRequestEvent.class, name = "friend"),
        @JsonSubTypes.Type(value = GroupAddRequestEvent.class, name = "group"),
})
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
