package per.chowhound.bot.entity;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 21:47
 */
public class FileInfo extends ExpendableEntity{
    // 文件 ID
    private String id;
    // 文件名
    private String name;
    // 文件大小（字节数）
    private Long size;
    // busid（目前不清楚有什么作用）
    private Long busid;

}
