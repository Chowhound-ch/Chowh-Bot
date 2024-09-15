package per.chowhound.bot.msg;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import per.chowhound.bot.event.MessageEvent;
import per.chowhound.bot.utils.MessagesDeserializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 13:58
 */
@Slf4j
@JsonDeserialize(using = MessagesDeserializer.class)
@NoArgsConstructor
public class Messages extends ArrayList<Message> implements Message {
    public Messages(int initialCapacity) {
        super(initialCapacity);
    }

    public Messages(Collection<? extends Message> c) {
        super(c);
    }

    public static Messages of(Message... messages) {
        Messages msgs = new Messages();
        for (Message message : messages) {
            if (message instanceof Messages) {
                msgs.addAll((Messages) message);
            } else {
                if (message instanceof Reply) {
                    log.warn("Reply message should not be added to Messages directly");
                }
                msgs.add(message);
            }
        }
        return msgs;
    }
    public static Messages replyOf(Reply reply, Message... messages) {
        Messages res = of(messages);
        res.add(0, reply);
        return res;
    }
    public static Messages replyOf(Long messageId, Message... messages) {
        return replyOf(Reply.of(messageId), messages);
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
        private Reply replied;

        public Builder reply(MessageEvent event) {
            return this.reply(event.getMessageId());
        }

        public Builder reply(Long messageId) {
            replied = Reply.of(messageId);
            return this;
        }

        public Builder add(Message message) {
            if (message instanceof Messages) {
                messages.addAll((Messages) message);
            } else {
                messages.add(message);
            }
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
            for (Message message : messages) {
                add(message);
            }
            return this;
        }

        public Builder at(Long userId) {
            messages.add(At.of(userId));
            return this;
        }

        public Messages build() {
            if (replied != null) {
                messages.add(0, replied);
            }
            return messages;
        }
    }
}
