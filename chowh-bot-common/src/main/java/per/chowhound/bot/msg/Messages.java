package per.chowhound.bot.msg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 13:58
 */
@NoArgsConstructor
public class Messages extends ArrayList<Message> implements Message {
    public Messages(int initialCapacity) {
        super(initialCapacity);
    }

    public static Messages of(Message... messages) {
        Messages msgs = new Messages();
        msgs.addAll(Arrays.asList(messages));
        return msgs;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Message message : this) {
            sb.append(message.toString());
        }
        return sb.toString();

    }

    public static class Builder {
        private final Messages messages = new Messages();

        public Builder add(Message message) {
            messages.add(message);
            return this;
        }
        public Builder text(String text) {
            messages.add(Text.of(text));
            return this;
        }

        public Builder image(String file) {
            messages.add(Image.of(file));
            return this;
        }

        public Builder addAll(Message... messages) {
            this.messages.addAll(Arrays.asList(messages));
            return this;
        }

        public Messages build() {
            return messages;
        }
    }
}
