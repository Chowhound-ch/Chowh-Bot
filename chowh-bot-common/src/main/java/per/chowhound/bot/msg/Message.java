package per.chowhound.bot.msg;

import per.chowhound.bot.entity.ExpendableEntity;
import per.chowhound.bot.exception.UnsupportedException;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 2:00
 */
public abstract class Message extends ExpendableEntity {
    protected String type;
    protected Object data;

    public static Message of(String msg) {
        throw new UnsupportedException("Unsupported Message Type");
    }

    public String get() {
        throw new UnsupportedException("Unsupported Message Type");
    }

    @Override
    public String toString() {
        return get();
    }

//    public abstract class MessageData extends ExpendableEntity {
//    }
}
