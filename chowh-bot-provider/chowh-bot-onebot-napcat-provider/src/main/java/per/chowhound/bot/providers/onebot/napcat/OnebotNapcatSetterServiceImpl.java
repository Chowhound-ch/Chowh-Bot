package per.chowhound.bot.providers.onebot.napcat;

import per.chowhound.bot.entity.VoidRes;
import per.chowhound.bot.providers.onebot.OnebotSetterServiceImpl;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 0:10
 */
public class OnebotNapcatSetterServiceImpl extends OnebotSetterServiceImpl {
    @Override
    public Mono<Result<VoidRes>> setGroupAnonymousBan(Long groupId, Integer duration, Object anonymousOrFlag) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Mono<Result<VoidRes>> setGroupAnonymous(Long groupId, boolean enable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Mono<Result<VoidRes>> setGroupSpecialTitle(Long groupId, Long userId, String specialTitle, Integer duration) {
        throw new UnsupportedOperationException();
    }
}
