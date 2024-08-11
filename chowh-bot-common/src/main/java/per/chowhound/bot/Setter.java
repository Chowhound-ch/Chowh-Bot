package per.chowhound.bot;

import per.chowhound.bot.entity.VoidRes;
import per.chowhound.bot.spi.GetterService;
import per.chowhound.bot.spi.SetterService;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

import java.util.ServiceLoader;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 23:17
 */
@SuppressWarnings("unused")
public class Setter {
    public static final String GROUP_ADD_REQUEST = "add";
    public static final String GROUP_INVITE_REQUEST = "invite";
    public static final Integer DEFAULT_BAN_DURATION = 60 * 5;
    private static final SetterService SETTER;
    static {
        //TODO 重写加载逻辑
        ServiceLoader<SetterService> load = ServiceLoader.load(SetterService.class);
        SETTER = load.findFirst().get();
    }

    public static Mono<Result<VoidRes>> deleteMsg(Long messageId) {
        return SETTER.deleteMsg(messageId);
    }

    public static Mono<Result<VoidRes>> setGroupKick(Long groupId, Long userId) {
        return SETTER.setGroupKick(groupId, userId, false);
    }

    public static Mono<Result<VoidRes>> setGroupKick(Long groupId, Long userId, boolean rejectAddRequest) {
        return SETTER.setGroupKick(groupId, userId, rejectAddRequest);
    }

    // region 群组禁言
    public static Mono<Result<VoidRes>> setGroupBan(Long groupId, Long userId) {
        return SETTER.setGroupBan(groupId, userId, DEFAULT_BAN_DURATION);
    }
    /**
     * 单位：秒
     * @author : Chowhound
     * @since : 2024/08/10 - 23:44
     */
    public static Mono<Result<VoidRes>> setGroupBan(Long groupId, Long userId, Integer duration) {
        return SETTER.setGroupBan(groupId, userId, duration);
    }

    public static Mono<Result<VoidRes>> setGroupAnonymousBan(Long groupId, String flag) {
        return SETTER.setGroupAnonymousBan(groupId, DEFAULT_BAN_DURATION, flag);
    }
    public static Mono<Result<VoidRes>> setGroupAnonymousBan(Long groupId, Integer duration, String flag) {
        return SETTER.setGroupAnonymousBan(groupId, duration, flag);
    }
    public static Mono<Result<VoidRes>> setGroupAnonymousBan(Long groupId, Object anonymous) {
        return SETTER.setGroupAnonymousBan(groupId, DEFAULT_BAN_DURATION, anonymous);
    }
    public static Mono<Result<VoidRes>> setGroupAnonymousBan(Long groupId, Integer duration, Object anonymous) {
        return SETTER.setGroupAnonymousBan(groupId, duration, anonymous);
    }

    public static Mono<Result<VoidRes>> setGroupWholeBan(Long groupId) {
        return SETTER.setGroupWholeBan(groupId, true);
    }
    public static Mono<Result<VoidRes>> setGroupWholeBan(Long groupId, boolean enable) {
        return SETTER.setGroupWholeBan(groupId, enable);
    }
    // endregion
    // region 群组管理
    public static Mono<Result<VoidRes>> setGroupAdmin(Long groupId, Long userId) {
        return SETTER.setGroupAdmin(groupId, userId, true);
    }
    public static Mono<Result<VoidRes>> setGroupAdmin(Long groupId, Long userId, boolean enable) {
        return SETTER.setGroupAdmin(groupId, userId, enable);
    }

    public static Mono<Result<VoidRes>> setGroupAnonymous(Long groupId) {
        return SETTER.setGroupAnonymous(groupId, true);
    }
    public static Mono<Result<VoidRes>> setGroupAnonymous(Long groupId, boolean enable) {
        return SETTER.setGroupAnonymous(groupId, enable);
    }

    public static Mono<Result<VoidRes>> setGroupCard(Long groupId, Long userId, String card) {
        return SETTER.setGroupCard(groupId, userId, card);
    }
    public static Mono<Result<VoidRes>> deleteGroupCard(Long groupId, Long userId) {
        return SETTER.setGroupCard(groupId, userId, "");
    }

    public static Mono<Result<VoidRes>> setGroupName(Long groupId, String groupName) {
        return SETTER.setGroupName(groupId, groupName);
    }

    public static Mono<Result<VoidRes>> setGroupLeave(Long groupId) {
        return SETTER.setGroupLeave(groupId, false);
    }
    public static Mono<Result<VoidRes>> setGroupLeave(Long groupId, boolean isDismiss) {
        return SETTER.setGroupLeave(groupId, isDismiss);
    }

    public static Mono<Result<VoidRes>> setGroupSpecialTitle(Long groupId, Long userId, String specialTitle, Integer duration) {
        return SETTER.setGroupSpecialTitle(groupId, userId, specialTitle, duration);
    }
    public static Mono<Result<VoidRes>> setGroupSpecialTitle(Long groupId, Long userId, String specialTitle) {
        return SETTER.setGroupSpecialTitle(groupId, userId, specialTitle, -1);
    }
    public static Mono<Result<VoidRes>> deleteGroupSpecialTitle(Long groupId, Long userId) {
        return SETTER.setGroupSpecialTitle(groupId, userId, "", -1);
    }
    // endregion
    // region 加好友/群
    public static Mono<Result<VoidRes>> approveFriendAddRequest(String flag) {
        return SETTER.setFriendAddRequest(flag, true, "");
    }
    public static Mono<Result<VoidRes>> rejectFriendAddRequest(String flag) {
        return SETTER.setFriendAddRequest(flag, false, "");
    }
    public static Mono<Result<VoidRes>> approveFriendAddRequest(String flag, String remark) {
        return SETTER.setFriendAddRequest(flag, true, remark);
    }
    public static Mono<Result<VoidRes>> setFriendAddRequest(String flag, boolean approve, String remark) {
        return SETTER.setFriendAddRequest(flag, approve, remark);
    }
    public static Mono<Result<VoidRes>> setFriendAddRequest(String flag, boolean approve) {
        return SETTER.setFriendAddRequest(flag, approve, "");
    }

    public static Mono<Result<VoidRes>> approveGroupAddRequest(String flag, String type) {
        return SETTER.setGroupAddRequest(flag, type, true, "");
    }
    public static Mono<Result<VoidRes>> rejectGroupAddRequest(String flag, String type) {
        return SETTER.setGroupAddRequest(flag, type, false, "");
    }
    public static Mono<Result<VoidRes>> rejectGroupAddRequest(String flag, String type, String reason) {
        return SETTER.setGroupAddRequest(flag, type, false, reason);
    }
    public static Mono<Result<VoidRes>> setGroupAddRequest(String flag, String type, boolean approve) {
        return SETTER.setGroupAddRequest(flag, type, approve, "");
    }
    public static Mono<Result<VoidRes>> setGroupAddRequest(String flag, String type, boolean approve, String reason) {
        return SETTER.setGroupAddRequest(flag, type, approve, reason);
    }

}
