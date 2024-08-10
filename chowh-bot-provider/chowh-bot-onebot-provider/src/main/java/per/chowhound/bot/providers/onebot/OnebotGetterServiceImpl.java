package per.chowhound.bot.providers.onebot;


import per.chowhound.bot.entity.*;
import per.chowhound.bot.msg.Record;
import per.chowhound.bot.spi.GetterService;
import per.chowhound.bot.utils.HttpUtil;
import per.chowhound.bot.utils.JacksonUtil;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;


/**
 * @author : Chowhound
 * @since : 2024/8/8 - 23:38
 */
public class OnebotGetterServiceImpl implements GetterService {
    @Override
    public Mono<Result<Bot>> getBotInfo() {
        return HttpUtil.doGetResult("/get_login_info", Bot.class);
    }

    @Override
    public Mono<Result<MessageInfo>> getMsg(Long messageId) {
        return HttpUtil.doGetResult("/get_msg", MessageInfo.class, Map.of("message_id", messageId));
    }

    //TODO
    @Override
    public Mono<Result<MessageInfo>> getForwardMsg(Long messageId) {
        return HttpUtil.doGetResult("/get_forward_msg", MessageInfo.class, Map.of("message_id", messageId));
    }

    @Override
    public Mono<Result<List<Friend>>> getFriendList() {
        return HttpUtil.doGetResult("/get_friend_list", JacksonUtil.getListOf(Friend.class));
    }

    @Override
    public Mono<Result<Group>> getGroupInfo(Long groupId, boolean noCache) {
        return HttpUtil.doGetResult("/get_group_info", Group.class, Map.of("group_id", groupId, "no_cache", noCache));
    }

    @Override
    public Mono<Result<List<Group>>> getGroupList() {
        return HttpUtil.doGetResult("/get_group_list", JacksonUtil.getListOf(Group.class));
    }

    @Override
    public Mono<Result<GroupMember>> getGroupMemberInfo(Long groupId, Long userId, boolean noCache) {
        return HttpUtil.doGetResult("/get_group_member_info", GroupMember.class, Map.of("group_id", groupId, "user_id", userId, "no_cache", noCache));
    }

    @Override
    public Mono<Result<List<GroupMember>>> getGroupMemberList(Long groupId) {
        return HttpUtil.doGetResult("/get_group_member_list", JacksonUtil.getListOf(GroupMember.class), Map.of("group_id", groupId));
    }

    @Override
    public Mono<Result<GroupHonorInfo>> getGroupHonorInfo(Long groupId, String type) {
        return HttpUtil.doGetResult("/get_group_honor_info", GroupHonorInfo.class, Map.of("group_id", groupId, "type", type));
    }

    @Override
    public Mono<Result<Cookies>> getCookies(String domain) {
        return HttpUtil.doGetResult("/get_cookies", Cookies.class, Map.of("domain", domain));
    }

    @Override
    public Mono<Result<Token>> getCsrfToken() {
        return HttpUtil.doGetResult("/get_csrf_token", Token.class);
    }

    @Override
    public Mono<Result<Credentials>> getCredentials(String domain) {
        return HttpUtil.doGetResult("/get_credentials", Credentials.class, Map.of("domain", domain));
    }

    // TODO 暂未测试
    @Override
    public Mono<Result<Record>> getRecord(String file, String outFormat) {
        Mono<Result<String>> mono = HttpUtil.doGetResult("/get_record", String.class, Map.of("file", file, "out_format", outFormat));
        return mono.map(res -> {
            Result<Record> rResult = res.copyWithoutData(Record.class);
            rResult.setData(Record.of(res.getData()));
            return rResult;
        });
    }

    @Override
    public Mono<Result<String>> getImage(String image) {
        return HttpUtil.doGetResult("/get_image", String.class, Map.of("file", image));
    }

    @Override
    public Mono<Result<Status>> getStatus() {
        return HttpUtil.doGetResult("/get_status", Status.class);
    }

    @Override
    public Mono<Result<VersionInfo>> getVersionInfo() {
        return HttpUtil.doGetResult("/get_version_info", VersionInfo.class);
    }
}
