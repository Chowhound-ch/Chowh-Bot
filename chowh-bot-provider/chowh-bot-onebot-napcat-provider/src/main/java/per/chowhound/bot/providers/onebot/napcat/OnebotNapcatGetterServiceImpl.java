package per.chowhound.bot.providers.onebot.napcat;


import per.chowhound.bot.entity.*;
import per.chowhound.bot.exception.UnsupportedException;
import per.chowhound.bot.providers.onebot.OnebotGetterServiceImpl;
import per.chowhound.bot.spi.GetterService;
import per.chowhound.bot.utils.HttpUtil;
import per.chowhound.bot.utils.JacksonUtil;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;


/**
 * @author : Chowhound
 * @since : 2024/8/8 - 23:38
 */
public class OnebotNapcatGetterServiceImpl extends OnebotGetterServiceImpl {
    @Override
    public Mono<Result<Token>> getCsrfToken() {
        throw new UnsupportedException();
    }

    @Override
    public Mono<Result<Credentials>> getCredentials(String domain) {
        throw new UnsupportedException();
    }
}
