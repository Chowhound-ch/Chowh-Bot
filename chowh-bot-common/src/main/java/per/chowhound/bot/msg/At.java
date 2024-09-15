package per.chowhound.bot.msg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author : Chowhound
 * @since : 2024/9/15 - 20:16
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class At extends AbstractMessage {
    private final String type = "at";

    private AtData data;


    public static At of(Long qq) {
        return new At(new At.AtData(qq));
    }

    public Long get() {
        return data.getQq();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class AtData {
        private Long qq;
    }
}
