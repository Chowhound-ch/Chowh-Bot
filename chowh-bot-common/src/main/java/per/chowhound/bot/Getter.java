package per.chowhound.bot;

import lombok.extern.slf4j.Slf4j;
import per.chowhound.bot.entity.*;
import per.chowhound.bot.msg.Record;
import per.chowhound.bot.utils.Result;

import java.util.List;

/**
 * @author : Chowhound
 * @since : 2024/9/15 - 19:36
 */
@Slf4j
@SuppressWarnings("unused")
public class Getter {

    public static Bot getBotInfo() {
        Result<Bot> result = null;
        try {
            result = MonoGetter.getBotInfo().toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static MessageInfo getMsg(Long messageId) {
        Result<MessageInfo> result = null;
        try {
            result = MonoGetter.getMsg(messageId).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static List<Friend> getFriendList() {
        Result<List<Friend>> result = null;
        try {
            result = MonoGetter.getFriendList().toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static Group getGroupInfo(Long group_id) {
        Result<Group> result = null;
        try {
            result = MonoGetter.getGroupInfo(group_id).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static Group getGroupInfo(Long group_id, boolean noCache) {
        Result<Group> result = null;
        try {
            result = MonoGetter.getGroupInfo(group_id, noCache).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static List<Group> getGroupList() {
        Result<List<Group>> result = null;
        try {
            result = MonoGetter.getGroupList().toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static GroupMember getGroupMemberInfo(Long groupId, Long userId) {
        Result<GroupMember> result = null;
        try {
            result = MonoGetter.getGroupMemberInfo(groupId, userId).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static GroupMember getGroupMemberInfo(Long groupId, Long userId, boolean noCache) {
        Result<GroupMember> result = null;
        try {
            result = MonoGetter.getGroupMemberInfo(groupId, userId, noCache).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static List<GroupMember> getGroupMemberList(Long groupId) {
        Result<List<GroupMember>> result = null;
        try {
            result = MonoGetter.getGroupMemberList(groupId).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static GroupHonorInfo getGroupHonorInfo(Long groupId, String type) {
        Result<GroupHonorInfo> result = null;
        try {
            result = MonoGetter.getGroupHonorInfo(groupId, type).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static Cookies getCookies() {
        Result<Cookies> result = null;
        try {
            result = MonoGetter.getCookies().toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static Cookies getCookies(String domain) {
        Result<Cookies> result = null;
        try {
            result = MonoGetter.getCookies(domain).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static Token getCsrfToken() {
        Result<Token> result = null;
        try {
            result = MonoGetter.getCsrfToken().toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static Credentials getCredentials() {
        Result<Credentials> result = null;
        try {
            result = MonoGetter.getCredentials().toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static Credentials getCredentials(String domain) {
        Result<Credentials> result = null;
        try {
            result = MonoGetter.getCredentials(domain).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static Record getRecord(String file, String outFormat) {
        Result<Record> result = null;
        try {
            result = MonoGetter.getRecord(file, outFormat).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static String getImage(String image) {
        Result<String> result = null;
        try {
            result = MonoGetter.getImage(image).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }


    public static Status getStatus() {
        Result<Status> result = null;
        try {
            result = MonoGetter.getStatus().toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static VersionInfo getVersionInfo() {
        Result<VersionInfo> result = null;
        try {
            result = MonoGetter.getVersionInfo().toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (result == null) {
            return null;
        }
        return result.getData();
    }
}
