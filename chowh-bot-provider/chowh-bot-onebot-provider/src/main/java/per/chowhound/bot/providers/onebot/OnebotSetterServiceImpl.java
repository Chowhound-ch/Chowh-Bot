package per.chowhound.bot.providers.onebot;

import per.chowhound.bot.entity.VoidRes;
import per.chowhound.bot.spi.SetterService;
import per.chowhound.bot.utils.HttpUtil;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 23:22
 */
public class OnebotSetterServiceImpl implements SetterService {
    @Override
    public Mono<Result<VoidRes>> deleteMsg(Long messageId) {
        return HttpUtil.doPostResult("/delete_msg", VoidRes.class, Map.of("message_id", messageId));
    }

    @Override
    public Mono<Result<VoidRes>> setGroupKick(Long groupId, Long userId, boolean rejectAddRequest) {
        return HttpUtil.doPostResult("/set_group_kick", VoidRes.class, Map.of("group_id", groupId, "user_id", userId, "reject_add_request", rejectAddRequest));
    }

    @Override
    public Mono<Result<VoidRes>> setGroupBan(Long groupId, Long userId, Integer duration) {
        return HttpUtil.doPostResult("/set_group_ban", VoidRes.class, Map.of("group_id", groupId, "user_id", userId, "duration", duration));
    }

    @Override
    public Mono<Result<VoidRes>> setGroupAnonymousBan(Long groupId, Integer duration, Object anonymousOrFlag) {
        String anonymousFiled = "anonymous";
        if (anonymousOrFlag instanceof String) {
            anonymousFiled = "flag";
        }
        return HttpUtil.doPostResult("/set_group_anonymous_ban", VoidRes.class, Map.of("group_id", groupId, "duration", duration, anonymousFiled, anonymousOrFlag));
    }

    @Override
    public Mono<Result<VoidRes>> setGroupWholeBan(Long groupId, boolean enable) {
        return HttpUtil.doPostResult("/set_group_whole_ban", VoidRes.class, Map.of("group_id", groupId, "enable", enable));
    }

    @Override
    public Mono<Result<VoidRes>> setGroupAdmin(Long groupId, Long userId, boolean enable) {
        return HttpUtil.doPostResult("/set_group_admin", VoidRes.class, Map.of("group_id", groupId, "user_id", userId, "enable", enable));
    }

    @Override
    public Mono<Result<VoidRes>> setGroupAnonymous(Long groupId, boolean enable) {
        return HttpUtil.doPostResult("/set_group_anonymous", VoidRes.class, Map.of("group_id", groupId, "enable", enable));
    }

    @Override
    public Mono<Result<VoidRes>> setGroupCard(Long groupId, Long userId, String card) {
        return HttpUtil.doPostResult("/set_group_card", VoidRes.class, Map.of("group_id", groupId, "user_id", userId, "card", card));
    }

    @Override
    public Mono<Result<VoidRes>> setGroupName(Long groupId, String groupName) {
        return HttpUtil.doPostResult("/set_group_name", VoidRes.class, Map.of("group_id", groupId, "group_name", groupName));
    }

    @Override
    public Mono<Result<VoidRes>> setGroupLeave(Long groupId, boolean isDismiss) {
        return HttpUtil.doPostResult("/set_group_leave", VoidRes.class, Map.of("group_id", groupId, "is_dismiss", isDismiss));
    }

    @Override
    public Mono<Result<VoidRes>> setGroupSpecialTitle(Long groupId, Long userId, String specialTitle, Integer duration) {
        return HttpUtil.doPostResult("/set_group_special_title", VoidRes.class, Map.of("group_id", groupId, "user_id", userId, "special_title", specialTitle, "duration", duration));
    }

    @Override
    public Mono<Result<VoidRes>> setFriendAddRequest(String flag, boolean approve, String remark) {
        return HttpUtil.doPostResult("/set_friend_add_request", VoidRes.class, Map.of("flag", flag, "approve", approve, "remark", remark));
    }

    @Override
    public Mono<Result<VoidRes>> setGroupAddRequest(String flag, String type, boolean approve, String reason) {
        return HttpUtil.doPostResult("/set_group_add_request", VoidRes.class, Map.of("flag", flag, "type", type, "approve", approve, "reason", reason));
    }
}
