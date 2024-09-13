package per.chowhound.bot.providers.onebot;

import per.chowhound.bot.Sender;
import per.chowhound.bot.entity.CheckRes;
import per.chowhound.bot.entity.MsgRes;
import per.chowhound.bot.entity.VoidRes;
import per.chowhound.bot.msg.Message;
import per.chowhound.bot.spi.SenderService;
import per.chowhound.bot.utils.HttpUtil;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 18:46
 */
public class OnebotSenderServiceImpl implements SenderService {
    @Override
    public Mono<Result<MsgRes>> sendPrivateMsg(Long userId, Message message, boolean autoEscape) {
        return HttpUtil.doPostResult("/send_private_msg", MsgRes.class, Map.of("user_id", userId, "message", message, "auto_escape", autoEscape));
    }

    @Override
    public Mono<Result<MsgRes>> sendGroupMsg(Long groupId, Message message, boolean autoEscape) {
        return HttpUtil.doPostResult("/send_group_msg", MsgRes.class, Map.of("group_id", groupId, "message", message, "auto_escape", autoEscape));
    }

    @Override
    public Mono<Result<MsgRes>> sendMsg(String messageType, Long id, Message message, boolean autoEscape) {
        String idStr = "group_id";
        if (messageType.equals(Sender.PRIVATE_MSG)) {
            idStr = "user_id";
        }
        return HttpUtil.doPostResult("/send_msg", MsgRes.class, Map.of("message_type", messageType, idStr, id, "message", message, "auto_escape", autoEscape));
    }

    @Override
    public Mono<Result<VoidRes>> sendLike(Long userId, Integer number) {
        return HttpUtil.doPostResult("/send_like", VoidRes.class, Map.of("user_id", userId, "times", number));
    }

    @Override
    public Mono<Result<CheckRes>> canSendImage() {
        return HttpUtil.doPostResult("/can_send_image", CheckRes.class);
    }

    @Override
    public Mono<Result<CheckRes>> canSendRecord() {
        return HttpUtil.doPostResult("/can_send_record", CheckRes.class);
    }
}
