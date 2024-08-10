package per.chowhound.bot.msg;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 13:58
 */
@NoArgsConstructor
public class Messages extends ArrayList<Message> {
    public Messages(int initialCapacity) {
        super(initialCapacity);
    }

    public static Messages of(Message... messages) {
        Messages msgs = new Messages();
        msgs.addAll(Arrays.asList(messages));
        return msgs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Message message : this) {
            sb.append(message.toString());
        }
        return sb.toString();

    }
}
