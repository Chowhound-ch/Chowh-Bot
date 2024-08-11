package per.chowhound.bot.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import per.chowhound.bot.entity.FileInfo;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:46
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupUploadEvent extends NoticeEvent{
    private String groupId;

    private FileInfo file;

}
