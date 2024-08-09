package per.chowhound.bot.spi;

import per.chowhound.bot.entity.Bot;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

/**
 * @author : Chowhound
 * @since : 2024/8/8 - 23:37
 */
public interface GetterService {
    default Mono<Result<Bot>> getBotInfo() {
        throw new RuntimeException();
    }
}
