package per.chowhound.bot.msg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * {
 *     "type": "text",
 *     "data": {
 *         "text": "纯文本内容"
 *     }
 * }
 * @author : Chowhound
 * @since : 2024/8/10 - 2:01
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Text extends AbstractMessage {
    private final String type = "text";

    private TextData data;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class TextData {
        private String text;
    }

    public static Text of(String msg) {
        return new Text(new TextData(msg));
    }

    @Override
    public String get() {
        return data.getText();
    }
}
