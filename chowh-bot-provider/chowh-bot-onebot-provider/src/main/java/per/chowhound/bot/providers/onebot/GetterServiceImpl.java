package per.chowhound.bot.providers.onebot;


import com.fasterxml.jackson.databind.JsonNode;
import per.chowhound.bot.entity.Bot;
import per.chowhound.bot.spi.GetterService;
import per.chowhound.bot.utils.HttpUtil;
import per.chowhound.bot.utils.JacksonUtil;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

import java.util.List;


/**
 * @author : Chowhound
 * @since : 2024/8/8 - 23:38
 */
public class GetterServiceImpl implements GetterService {
    @Override
    public Mono<Result<Bot>> getBotInfo() {
        return HttpUtil.doGetResult("/get_login_info", Bot.class);
    }
}
