package per.chowhound.bot.event.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import per.chowhound.bot.msg.Message;
import per.chowhound.bot.msg.Text;

/**
 * @author : Chowhound
 * @since : 2024/9/13 - 21:56
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupMsgResponse implements EventResponse {
    // 要回复的内容
    private Message reply;
    // 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 reply 字段是字符串时有效
    private Boolean autoEscape = Boolean.FALSE;
    // 是否要在回复开头 at 发送者（自动添加），发送者是匿名用户时无效
    private Boolean atSender = Boolean.FALSE;
    // 撤回该条消息
    private Boolean delete = Boolean.FALSE;
    // 把发送者踢出群组（需要登录号权限足够），不拒绝此人后续加群请求，发送者是匿名用户时无效
    private Boolean kick = Boolean.FALSE;
    // 把发送者禁言 ban_duration 指定时长，对匿名用户也有效
    private Boolean ban = Boolean.FALSE;
    // 禁言时长
    private Integer banDuration = 30;


    public GroupMsgResponse(Message reply) {
        this.reply = reply;
    }
    public GroupMsgResponse(String reply) {
        this.reply = Text.of(reply);
    }

    public GroupMsgResponse(Message reply, Boolean autoEscape) {
        this.reply = reply;
        this.autoEscape = autoEscape;
    }

    public GroupMsgResponse(String reply, Boolean autoEscape) {
        this.reply = Text.of(reply);
        this.autoEscape = autoEscape;
    }

    public void setReply(String reply) {
        this.reply = Text.of(reply);
    }
}
