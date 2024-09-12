package per.chowhound.bot.register.exception;

/**
 * @author : Chowhound
 * @since : 2024/9/12 - 20:27
 */
public class ListenerNotRegistryExecution extends RuntimeException {
    public ListenerNotRegistryExecution(String message) {
        super(message);
    }
}
