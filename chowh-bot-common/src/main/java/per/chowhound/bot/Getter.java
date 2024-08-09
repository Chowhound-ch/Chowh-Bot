package per.chowhound.bot;

import per.chowhound.bot.entity.Bot;
import per.chowhound.bot.spi.GetterService;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

import java.util.ServiceLoader;

/**
 * @author : Chowhound
 * @since : 2024/8/8 - 22:48
 */
public class Getter {
    private static final GetterService GETTER;
    static {
        ServiceLoader<GetterService> load = ServiceLoader.load(GetterService.class);
        GETTER = load.findFirst().get();
    }

    public static Mono<Result<Bot>> getBotInfo() {
        return GETTER.getBotInfo();
    }
}
