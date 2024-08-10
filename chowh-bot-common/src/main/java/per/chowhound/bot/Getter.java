package per.chowhound.bot;

import per.chowhound.bot.entity.*;
import per.chowhound.bot.msg.Record;
import per.chowhound.bot.spi.GetterService;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.ServiceLoader;

/**
 * @author : Chowhound
 * @since : 2024/8/8 - 22:48
 */
public class Getter {
    private static final GetterService GETTER;
    static {
         //TODO 重写加载逻辑
        ServiceLoader<GetterService> load = ServiceLoader.load(GetterService.class);
        GETTER = load.findFirst().get();
    }

    public static Mono<Result<Bot>> getBotInfo() {
        return GETTER.getBotInfo();
    }

    public static Mono<Result<MessageInfo>> getMsg(Long messageId) {
        return GETTER.getMsg(messageId);
    }

    public static Mono<Result<List<Friend>>> getFriendList() {
        return Getter.GETTER.getFriendList();
    }

    /**
     * 默认使用缓存
     * @author : Chowhound
     * @since : 2024/08/10 - 14:42
     */
    public static Mono<Result<Group>> getGroupInfo(Long group_id) {
        return GETTER.getGroupInfo(group_id, true);
    }

    public static Mono<Result<Group>> getGroupInfo(Long group_id, boolean noCache) {
        return GETTER.getGroupInfo(group_id, noCache);
    }

    public static Mono<Result<List<Group>>> getGroupList() {
        return GETTER.getGroupList();
    }
    /**
     * 默认使用缓存
     * @author : Chowhound
     * @since : 2024/08/10 - 14:57
     */
    public static Mono<Result<GroupMember>> getGroupMemberInfo(Long groupId, Long userId) {
        return GETTER.getGroupMemberInfo(groupId, userId, true);
    }
    public static Mono<Result<GroupMember>> getGroupMemberInfo(Long groupId, Long userId, boolean noCache) {
        return GETTER.getGroupMemberInfo(groupId, userId, noCache);
    }

    public static Mono<Result<List<GroupMember>>> getGroupMemberList(Long groupId) {
        return GETTER.getGroupMemberList(groupId);
    }

    public static Mono<Result<GroupHonorInfo>> getGroupHonorInfo(Long groupId, String type) {
        return GETTER.getGroupHonorInfo(groupId, type);
    }

    public static Mono<Result<Cookies>> getCookies() {
        return getCookies("");
    }
    public static Mono<Result<Cookies>> getCookies(String domain) {
        return GETTER.getCookies(domain);
    }

    public static Mono<Result<Token>> getCsrfToken() {
        return GETTER.getCsrfToken();
    }

    public static Mono<Result<Credentials>> getCredentials() {
        return GETTER.getCredentials("");
    }
    public static Mono<Result<Credentials>> getCredentials(String domain) {
        return GETTER.getCredentials(domain);
    }

    ///提示：要使用此接口，通常需要安装 ffmpeg，请参考 机器人框架 实现的相关说明。
    // TODO 待确认是 Result<Record> 还是 Result<String>
    public static Mono<Result<Record>> getRecord(String file, String outFormat) {
        return GETTER.getRecord(file, outFormat);
    }
    // TODO 待确认是 Result<Image> 还是 Result<String>
    public static Mono<Result<String>> getImage(String image) {
        return GETTER.getImage(image);
    }

    public static Mono<Result<Status>> getStatus() {
        return GETTER.getStatus();
    }

    public static Mono<Result<VersionInfo>> getVersionInfo() {
        return GETTER.getVersionInfo();
    }
}
