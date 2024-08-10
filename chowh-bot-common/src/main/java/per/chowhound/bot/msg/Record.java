package per.chowhound.bot.msg;

import lombok.*;
import per.chowhound.bot.entity.ExpendableEntity;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 16:16
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Record extends Message{
    private final String type = "record";

    private RecordData data;


    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @AllArgsConstructor
    @Data
    static class RecordData extends ExpendableEntity {
        private String file;
    }

    public static Record of(String file) {
        return new Record(new RecordData(file));
    }

    public String get() {
        return data.getFile();
    }

}
