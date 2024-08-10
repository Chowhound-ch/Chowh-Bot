package per.chowhound.bot.spi;

import per.chowhound.bot.entity.VoidRes;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 23:18
 */
public interface SetterService {
    default Mono<Result<VoidRes>> deleteMsg(Long messageId) {
        throw new UnsupportedOperationException();
    }

    default Mono<Result<VoidRes>> setGroupKick(Long groupId, Long userId, boolean rejectAddRequest) {
        throw new UnsupportedOperationException();
    }

    default Mono<Result<VoidRes>> setGroupBan(Long groupId, Long userId, Integer duration) {
        throw new UnsupportedOperationException();
    }

    default Mono<Result<VoidRes>> setGroupAnonymousBan(Long groupId, Integer duration, Object anonymousOrFlag) {
        throw new UnsupportedOperationException();
    }

    default Mono<Result<VoidRes>> setGroupWholeBan(Long groupId, boolean enable) {
        throw new UnsupportedOperationException();
    }

    default Mono<Result<VoidRes>> setGroupAdmin(Long groupId, Long userId, boolean enable) {
        throw new UnsupportedOperationException();
    }

    default Mono<Result<VoidRes>> setGroupAnonymous(Long groupId, boolean enable) {
        throw new UnsupportedOperationException();
    }

    default Mono<Result<VoidRes>> setGroupCard(Long groupId, Long userId, String card) {
        throw new UnsupportedOperationException();
    }

    default Mono<Result<VoidRes>> setGroupName(Long groupId, String groupName) {
        throw new UnsupportedOperationException();
    }

    default Mono<Result<VoidRes>> setGroupLeave(Long groupId, boolean isDismiss) {
        throw new UnsupportedOperationException();
    }

    default Mono<Result<VoidRes>> setGroupSpecialTitle(Long groupId, Long userId, String specialTitle, Integer duration) {
        throw new UnsupportedOperationException();
    }

    default Mono<Result<VoidRes>> setFriendAddRequest(String flag, boolean approve, String remark) {
        throw new UnsupportedOperationException();
    }

    default Mono<Result<VoidRes>> setGroupAddRequest(String flag, String type, boolean approve, String reason) {
        throw new UnsupportedOperationException();
    }
}
