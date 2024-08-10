package per.chowhound.bot.spi;

import per.chowhound.bot.entity.CheckRes;
import per.chowhound.bot.entity.MsgRes;
import per.chowhound.bot.entity.VoidRes;
import per.chowhound.bot.exception.UnsupportedException;
import per.chowhound.bot.msg.Message;
import per.chowhound.bot.msg.Text;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 18:43
 */
public interface SenderService {
    default Mono<Result<MsgRes>> sendPrivateMsg(Long userId, Message message, boolean autoEscape) {
        throw new UnsupportedException();
    }

    default Mono<Result<MsgRes>> sendGroupMsg(Long groupId, Message message, boolean autoEscape) {
        throw new UnsupportedException();
    }

    default Mono<Result<MsgRes>> sendMsg(String messageType, Long id, Message message, boolean autoEscape) {
        throw new UnsupportedException();
    }

    default Mono<Result<VoidRes>> sendLike(Long userId, Integer number) {
        throw new UnsupportedException();
    }

    default Mono<Result<CheckRes>> canSendImage() {
        throw new UnsupportedException();
    }

    default Mono<Result<CheckRes>> canSendRecord() {
        throw new UnsupportedException();
    }
}
