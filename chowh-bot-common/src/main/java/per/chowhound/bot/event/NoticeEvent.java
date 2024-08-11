package per.chowhound.bot.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:43
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        property = "notice_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = GroupUploadEvent.class, name = "group_upload"),
        @JsonSubTypes.Type(value = GroupAdminChangeEvent.class, name = "group_admin"),
        @JsonSubTypes.Type(value = GroupMemberReduceEvent.class, name = "group_decrease"),
        @JsonSubTypes.Type(value = GroupMemberAddEvent.class, name = "group_increase"),
        @JsonSubTypes.Type(value = GroupBanEvent.class, name = "group_ban"),
        @JsonSubTypes.Type(value = FriendAddEvent.class, name = "friend_add"),
        @JsonSubTypes.Type(value = GroupMessageRevokeEvent.class, name = "group_recall"),
        @JsonSubTypes.Type(value = PrivateMessageRevokeEvent.class, name = "friend_recall"),
        @JsonSubTypes.Type(value = NotifyEvent.class, name = "notify"),
})
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class NoticeEvent extends AbstractEvent{
    // 通知类型
    private String noticeType;

    private Long userId;
}
