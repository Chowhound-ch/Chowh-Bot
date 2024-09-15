package per.chowhound.bot.msg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 不宜直接作为Messages一部分
 * @author : Chowhound
 * @since : 2024/9/15 - 19:09
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reply extends AbstractMessage {
    private final String type = "reply";

    private ReplyData data;

    public Long get() {
        return data.getMessageId();
    }

    public static Reply of(Long messageId) {
        return new Reply(new ReplyData(messageId));
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class ReplyData {
        private Long messageId;
    }
}
