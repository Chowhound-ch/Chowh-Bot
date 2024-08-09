package per.chowhound.bot;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import per.chowhound.bot.entity.Bot;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;


/**
 * @author : Chowhound
 * @since : 2024/8/8 - 22:33
 */
public class ChowhBotApplication {
    public static void main(String[] args) {
        Mono<Result<Bot>> bot = Getter.getBotInfo();
        System.out.println(bot.block());
    }

}