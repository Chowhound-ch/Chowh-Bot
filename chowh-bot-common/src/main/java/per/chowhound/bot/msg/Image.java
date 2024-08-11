package per.chowhound.bot.msg;

import lombok.*;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 22:29
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Image extends AbstractMessage {
    private final String type = "image";
    private ImageData data;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class ImageData {
        private String file;
    }

    public static Image of(String file) {
        return new Image(new ImageData(file));
    }

}
