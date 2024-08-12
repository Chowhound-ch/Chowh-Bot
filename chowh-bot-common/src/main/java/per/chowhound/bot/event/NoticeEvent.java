package per.chowhound.bot.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:43
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class NoticeEvent extends AbstractEvent{
    // 通知类型
    private String noticeType;

    private Long userId;
}
