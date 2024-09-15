package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import per.chowhound.bot.Setter;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 22:06
 */
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = true)
@Data
public class FriendAddRequestEvent extends RequestEvent{
    public void approve(String remark) {
        Setter.approveFriendAddRequest(this.getFlag(), remark);
    }

    public void reject() {
        Setter.rejectFriendAddRequest(this.getFlag());
    }
}
