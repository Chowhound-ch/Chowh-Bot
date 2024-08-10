package per.chowhound.bot.spi;

import per.chowhound.bot.entity.*;
import per.chowhound.bot.exception.UnsupportedException;
import per.chowhound.bot.msg.Record;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author : Chowhound
 * @since : 2024/8/8 - 23:37
 */
public interface GetterService {

    /**
     *  获取机器人登录信息
     * @author : Chowhound
     * @since : 2024/08/10 - 01:52
     */
    default Mono<Result<Bot>> getBotInfo() {
        throw new UnsupportedException();
    }

    default Mono<Result<MessageInfo>> getMsg(Long messageId) {
        throw new UnsupportedException();
    }

    default Mono<Result<MessageInfo>> getForwardMsg(Long messageId) {
        throw new UnsupportedException();
    }

    default Mono<Result<List<Friend>>> getFriendList() {
        throw new UnsupportedException();
    }

    default Mono<Result<Group>> getGroupInfo(Long groupId, boolean noCache){
        throw new UnsupportedException();
    }

    default Mono<Result<List<Group>>> getGroupList(){
        throw new UnsupportedException();
    }

    default Mono<Result<GroupMember>> getGroupMemberInfo(Long groupId, Long userId, boolean noCache) {
        throw new UnsupportedException();
    }

    default Mono<Result<List<GroupMember>>> getGroupMemberList(Long groupId) {
        throw new UnsupportedException();
    }

    default Mono<Result<GroupHonorInfo>> getGroupHonorInfo(Long groupId, String type) {
        throw new UnsupportedException();
    }

    default Mono<Result<Cookies>> getCookies(String domain) {
        throw new UnsupportedException();
    }

    default Mono<Result<Token>> getCsrfToken() {
        throw new UnsupportedException();
    }

    default Mono<Result<Credentials>> getCredentials(String domain) {
        throw new UnsupportedException();
    }

    default Mono<Result<Record>> getRecord(String file, String outFormat) {
        throw new UnsupportedException();
    }

    default Mono<Result<String>> getImage(String image) {
        throw new UnsupportedException();
    }

    default Mono<Result<Status>> getStatus() {
        throw new UnsupportedException();
    }

    default Mono<Result<VersionInfo>> getVersionInfo() {
        throw new UnsupportedException();
    }

}
