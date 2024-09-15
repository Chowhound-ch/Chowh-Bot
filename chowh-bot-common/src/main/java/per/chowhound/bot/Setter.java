package per.chowhound.bot;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : Chowhound
 * @since : 2024/9/15 - 19:36
 */
@Slf4j
@SuppressWarnings("unused")
public class Setter {

    public static void deleteMsg(Long messageId) {
        try {
            MonoSetter.deleteMsg(messageId).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupKick(Long groupId, Long userId) {
        try {
            MonoSetter.setGroupKick(groupId, userId).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }


    }
    public static void setGroupKick(Long groupId, Long userId, boolean rejectAddRequest) {
        try {
            MonoSetter.setGroupKick(groupId, userId, rejectAddRequest).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    // region 群组禁言
    public static void setGroupBan(Long groupId, Long userId) {
        try {
            MonoSetter.setGroupBan(groupId, userId).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }


    }
    public static void setGroupBan(Long groupId, Long userId, Integer duration) {
        try {
            MonoSetter.setGroupBan(groupId, userId, duration).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupAnonymousBan(Long groupId, String flag) {
        try {
            MonoSetter.setGroupAnonymousBan(groupId, flag).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }


    }
    public static void setGroupAnonymousBan(Long groupId, Integer duration, String flag) {
        try {
            MonoSetter.setGroupAnonymousBan(groupId, duration, flag).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupAnonymousBan(Long groupId, Object anonymous) {
        try {
            MonoSetter.setGroupAnonymousBan(groupId, anonymous).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupAnonymousBan(Long groupId, Integer duration, Object anonymous) {
        try {
            MonoSetter.setGroupAnonymousBan(groupId, duration, anonymous).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupWholeBan(Long groupId) {
        try {
            MonoSetter.setGroupWholeBan(groupId).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupWholeBan(Long groupId, boolean enable) {
        try {
            MonoSetter.setGroupWholeBan(groupId, enable).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }


    }// endregion
    // region 群组管理

    public static void setGroupAdmin(Long groupId, Long userId) {
        try {
            MonoSetter.setGroupAdmin(groupId, userId).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupAdmin(Long groupId, Long userId, boolean enable) {
        try {
            MonoSetter.setGroupAdmin(groupId, userId, enable).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupAnonymous(Long groupId) {
        try {
            MonoSetter.setGroupAnonymous(groupId).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupAnonymous(Long groupId, boolean enable) {
        try {
            MonoSetter.setGroupAnonymous(groupId, enable).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupCard(Long groupId, Long userId, String card) {
        try {
            MonoSetter.setGroupCard(groupId, userId, card).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void deleteGroupCard(Long groupId, Long userId) {
        try {
            MonoSetter.setGroupCard(groupId, userId, "").toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupName(Long groupId, String groupName) {
        try {
            MonoSetter.setGroupName(groupId, groupName).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupLeave(Long groupId) {
        try {
            MonoSetter.setGroupLeave(groupId).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupLeave(Long groupId, boolean isDismiss) {
        try {
            MonoSetter.setGroupLeave(groupId, isDismiss).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupSpecialTitle(Long groupId, Long userId, String specialTitle, Integer duration) {
        try {
            MonoSetter.setGroupSpecialTitle(groupId, userId, specialTitle, duration).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupSpecialTitle(Long groupId, Long userId, String specialTitle) {
        try {
            MonoSetter.setGroupSpecialTitle(groupId, userId, specialTitle).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void deleteGroupSpecialTitle(Long groupId, Long userId) {
        try {
            MonoSetter.setGroupSpecialTitle(groupId, userId, "", -1).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }


    }// endregion
    // region 加好友/群

    public static void approveFriendAddRequest(String flag) {
        try {
            MonoSetter.approveFriendAddRequest(flag).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void rejectFriendAddRequest(String flag) {
        try {
            MonoSetter.rejectFriendAddRequest(flag).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void approveFriendAddRequest(String flag, String remark) {
        try {
            MonoSetter.approveFriendAddRequest(flag, remark).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setFriendAddRequest(String flag, boolean approve, String remark) {
        try {
            MonoSetter.setFriendAddRequest(flag, approve, remark).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setFriendAddRequest(String flag, boolean approve) {
        try {
            MonoSetter.setFriendAddRequest(flag, approve).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void approveGroupAddRequest(String flag, String type) {
        try {
            MonoSetter.approveGroupAddRequest(flag, type).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void rejectGroupAddRequest(String flag, String type) {
        try {
            MonoSetter.rejectGroupAddRequest(flag, type).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void rejectGroupAddRequest(String flag, String type, String reason) {
        try {
            MonoSetter.rejectGroupAddRequest(flag, type, reason).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupAddRequest(String flag, String type, boolean approve) {
        try {
            MonoSetter.setGroupAddRequest(flag, type, approve).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public static void setGroupAddRequest(String flag, String type, boolean approve, String reason) {
        try {
            MonoSetter.setGroupAddRequest(flag, type, approve, reason).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
