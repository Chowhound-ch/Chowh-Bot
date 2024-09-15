package per.chowhound.bot;

import lombok.extern.slf4j.Slf4j;
import per.chowhound.bot.entity.MsgRes;
import per.chowhound.bot.msg.Message;
import per.chowhound.bot.utils.Result;

import java.util.concurrent.ExecutionException;

/**
 * @author : Chowhound
 * @since : 2024/9/15 - 19:36
 */
@Slf4j
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Sender {
    public static MsgRes sendPrivateMsg(Long userId, String text) {
        Result<MsgRes> result = null;
        try {
            result = MonoSender.sendPrivateMsg(userId, text).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static MsgRes sendPrivateMsg(Long userId, Message message) {
        Result<MsgRes> result = null;
        try {
            result = MonoSender.sendPrivateMsg(userId, message).toFuture().get();

        } catch (Exception e) {
            log.error(e.getMessage());

        }        if (result == null) {
            return null;
        }
        return result.getData();
    }


    public static MsgRes sendPrivateMsg(Long userId, String text, boolean autoEscape) {
        Result<MsgRes> result = null;
        try {
            result = MonoSender.sendPrivateMsg(userId, text, autoEscape).toFuture().get();

        } catch (Exception e) {
            log.error(e.getMessage());

        }        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static MsgRes sendPrivateMsg(Long userId, Message message, boolean autoEscape) {
        Result<MsgRes> result = null;
        try {
            result = MonoSender.sendPrivateMsg(userId, message, autoEscape).toFuture().get();

        } catch (Exception e) {
            log.error(e.getMessage());

        }        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static MsgRes sendGroupMsg(Long groupId, String message) {
        Result<MsgRes> result = null;
        try {
            result = MonoSender.sendGroupMsg(groupId, message).toFuture().get();

        } catch (Exception e) {
            log.error(e.getMessage());

        }        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static MsgRes sendGroupMsg(Long groupId, Message message) {
        Result<MsgRes> result = null;
        try {
            result = MonoSender.sendGroupMsg(groupId, message).toFuture().get();

        } catch (Exception e) {
            log.error(e.getMessage());

        }        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static MsgRes sendGroupMsg(Long groupId, String message, boolean autoEscape) {
        Result<MsgRes> result = null;
        try {
            result = MonoSender.sendGroupMsg(groupId, message, autoEscape).toFuture().get();

        } catch (Exception e) {
            log.error(e.getMessage());

        }        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static MsgRes sendGroupMsg(Long groupId, Message message, boolean autoEscape) {
        Result<MsgRes> result = null;
        try {
            result = MonoSender.sendGroupMsg(groupId, message, autoEscape).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static MsgRes sendMsg(String messageType, Long id, String message) {
        Result<MsgRes> result = null;
        try {
            result = MonoSender.sendMsg(messageType, id, message).toFuture().get();

        } catch (Exception e) {
            log.error(e.getMessage());

        }        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static MsgRes sendMsg(String messageType, Long id, Message message) {
        Result<MsgRes> result = null;
        try {
            result = MonoSender.sendMsg(messageType, id, message).toFuture().get();

        } catch (Exception e) {
            log.error(e.getMessage());

        }        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static MsgRes sendMsg(String messageType, Long id, String message, boolean autoEscape) {
        Result<MsgRes> result = null;
        try {
            result = MonoSender.sendMsg(messageType, id, message, autoEscape).toFuture().get();

        } catch (Exception e) {
            log.error(e.getMessage());

        }        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static MsgRes sendMsg(String messageType, Long id, Message message, boolean autoEscape) {
        Result<MsgRes> result = null;
        try {
            result = MonoSender.sendMsg(messageType, id, message, autoEscape).toFuture().get();

        } catch (Exception e) {
            log.error(e.getMessage());

        }        if (result == null) {
            return null;
        }
        return result.getData();
    }

    public static void sendLike(Long userId) {
        try {
            MonoSender.sendLike(userId).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }


    }
    public static void sendLike(Long userId, Integer number) {
        try {
            MonoSender.sendLike(userId, number).toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }


    }
    public static void canSendImage() {
        try {
            MonoSender.canSendImage().toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    public static void canSendRecord() {
        try {
            MonoSender.canSendRecord().toFuture().get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
