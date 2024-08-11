package per.chowhound.bot;

import per.chowhound.bot.entity.CheckRes;
import per.chowhound.bot.entity.MsgRes;
import per.chowhound.bot.entity.VoidRes;
import per.chowhound.bot.msg.Message;
import per.chowhound.bot.msg.Text;
import per.chowhound.bot.spi.SenderService;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

import java.util.ServiceLoader;

/**
 * @author : Chowhound
 * @since : 2024/8/8 - 22:48
 */
@SuppressWarnings("unused")
public class Sender {
    public static final String GROUP_MSG = "group";
    public static final String PRIVATE_MSG = "private";

    private static final SenderService SENDER;
    static {
        //TODO 重写加载逻辑
        ServiceLoader<SenderService> load = ServiceLoader.load(SenderService.class);
        SENDER = load.findFirst().get();
    }
    // region 私聊
    public static Mono<Result<MsgRes>> sendPrivateMsg(Long userId, String text) {
        return SENDER.sendPrivateMsg(userId, Text.of(text), false);
    }
    public static Mono<Result<MsgRes>> sendPrivateMsg(Long userId, Message message) {
        return SENDER.sendPrivateMsg(userId, message, false);
    }
    public static Mono<Result<MsgRes>> sendPrivateMsg(Long userId, String text, boolean autoEscape) {
        return SENDER.sendPrivateMsg(userId, Text.of(text), false);
    }
    public static Mono<Result<MsgRes>> sendPrivateMsg(Long userId, Message message, boolean autoEscape) {
        return SENDER.sendPrivateMsg(userId, message, autoEscape);
    }
    // endregion
    // region 群聊
    public static Mono<Result<MsgRes>> sendGroupMsg(Long groupId, String message) {
        return SENDER.sendGroupMsg(groupId, Text.of(message), false);
    }
    public static Mono<Result<MsgRes>> sendGroupMsg(Long groupId, Message message) {
        return SENDER.sendGroupMsg(groupId, message, false);
    }
    public static Mono<Result<MsgRes>> sendGroupMsg(Long groupId, String message, boolean autoEscape) {
        return SENDER.sendGroupMsg(groupId, Text.of(message), autoEscape);
    }
    public static Mono<Result<MsgRes>> sendGroupMsg(Long groupId, Message message, boolean autoEscape) {
        return SENDER.sendGroupMsg(groupId, message, autoEscape);
    }

    // endregion
    // region 通用
    public static Mono<Result<MsgRes>> sendMsg(String messageType, Long id, String message) {
        return SENDER.sendMsg(messageType, id, Text.of(message), false);
    }
    public static Mono<Result<MsgRes>> sendMsg(String messageType, Long id, Message message) {
        return SENDER.sendMsg(messageType, id, message, false);
    }
    public static Mono<Result<MsgRes>> sendMsg(String messageType, Long id, String message, boolean autoEscape) {
        return SENDER.sendMsg(messageType, id, Text.of(message), autoEscape);
    }
    public static Mono<Result<MsgRes>> sendMsg(String messageType, Long id, Message message, boolean autoEscape) {
        return SENDER.sendMsg(messageType, id, message, autoEscape);
    }
    // endregion
    // region 非消息
    public static Mono<Result<VoidRes>> sendLike(Long userId) {
        return SENDER.sendLike(userId, 1);
    }
    public static Mono<Result<VoidRes>> sendLike(Long userId, Integer number) {
        return SENDER.sendLike(userId, number);
    }
    // endregion
    // region 检查是否能发送
    public static Mono<Result<CheckRes>> canSendImage() {
        return SENDER.canSendImage();
    }
    public static Mono<Result<CheckRes>> canSendRecord() {
        return SENDER.canSendRecord();
    }
    // endregion
}
