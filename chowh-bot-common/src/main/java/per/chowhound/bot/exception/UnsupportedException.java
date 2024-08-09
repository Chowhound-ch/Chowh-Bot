package per.chowhound.bot.exception;

/**
 * @author : Chowhound
 * @since : 2024/8/8 - 23:40
 */
public class UnsupportedException extends RuntimeException {
    public UnsupportedException() {
        super("不支持的操作");
    }

    public UnsupportedException(String message) {
        super("不支持的操作:" + message);
    }
}
