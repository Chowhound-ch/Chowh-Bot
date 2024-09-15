package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import per.chowhound.bot.MonoSetter;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 22:07
 */
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupAddRequestEvent extends RequestEvent{
    // add、invite	请求子类型，分别表示加群请求、邀请登录号入群
    private String subType;
    private Long groupId;

    public void approve() {
        MonoSetter.approveGroupAddRequest(super.getFlag(), subType).subscribe();
    }

    public void reject(String reason) {
        MonoSetter.rejectGroupAddRequest(super.getFlag(), subType, reason).subscribe();
    }

    public void reject() {
        this.reject("");
    }
}
