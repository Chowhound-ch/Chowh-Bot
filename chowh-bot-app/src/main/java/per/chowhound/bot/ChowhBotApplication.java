package per.chowhound.bot;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import per.chowhound.bot.entity.*;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

import java.util.List;


/**
 * @author : Chowhound
 * @since : 2024/8/8 - 22:33
 */
public class ChowhBotApplication {
    public static void main(String[] args) {
//        Mono<Result<Bot>> bot = Getter.getBotInfo();
//        Mono<?> mono = Getter.getGroupInfo(811545265L, true);
//        Mono<?> mono = Getter.getGroupList();
//        Mono<?> mono = Getter.getGroupMemberInfo(811545265L, 825352674L, true);
//        Mono<?> mono = Getter.getGroupMemberList(811545265L);
//        Mono<?> mono = Getter.getGroupHonorInfo(811545265L, GroupHonor.TYPE_ALL);
//        Mono<?> mono = Getter.getCookies();
//        Mono<?> mono = Getter.getCsrfToken();
//        Mono<?> mono = Getter.getCredentials();
//        Mono<?> mono = Getter.getRecord("1f0b1851392eb90a81a736fcb61b165d.silk", "mp3");
//        Mono<?> mono = Getter.getImage("1f0b1851392eb90a81a736fcb61b165d.jpg");
//        Mono<?> mono = Getter.getStatus();
        Mono<?> mono = Getter.getVersionInfo();


        Object block = mono.block();
        System.out.println(block);

        System.out.println();
    }

}