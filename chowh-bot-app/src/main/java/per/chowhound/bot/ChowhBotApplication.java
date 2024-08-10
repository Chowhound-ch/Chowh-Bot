package per.chowhound.bot;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import per.chowhound.bot.entity.*;
import per.chowhound.bot.msg.Image;
import per.chowhound.bot.msg.Messages;
import per.chowhound.bot.msg.Text;
import per.chowhound.bot.utils.Result;
import reactor.core.publisher.Mono;

import java.util.List;


/**
 * @author : Chowhound
 * @since : 2024/8/8 - 22:33
 */
public class ChowhBotApplication {
    public static void main(String[] args) {
        // Sender
        Messages messageTest = Messages.builder()
                .text("瑟图")
                .image("https://multimedia.nt.qq.com.cn/download?appi" +
                        "d=1406&fileid=Cgk4MjUzNTI2NzQSFGq64fM19whJk6BSNJL-7rkq" +
                        "lu97GK6FfSD-Cijgsee30uqHA1CAuy8&spec=0&rkey=CAISKKSBek" +
                        "jVG1fMAcBxLG5StXeRFGyAM4jZBZWkLNv4AHO4mgf-IUQP76s"
                ).build();
//        Mono<?> mono = Sender.sendPrivateMsg(825352674L,
//                messageTest, false);
//        Mono<?> mono = Sender.sendGroupMsg(811545265L, messageTest, false);
        Mono<?> mono = Sender.sendMsg(Sender.GROUP_MSG, 811545265L, messageTest, false);

        Object block = mono.block();
        System.out.println(block);

        System.out.println();
/*
        // Getter
        Mono<?> mono = Getter.getBotInfo();
        Mono<?> mono = Getter.getBotInfo();
        Mono<?> mono = Getter.getMsg(97151221L);
        Mono<?> mono = Getter.getFriendList();
        Mono<?> mono = Getter.getGroupList();
        Mono<?> mono = Getter.getGroupMemberInfo(811545265L, 825352674L, true);
        Mono<?> mono = Getter.getGroupMemberList(811545265L);
        Mono<?> mono = Getter.getGroupHonorInfo(811545265L, GroupHonor.TYPE_ALL);
        Mono<?> mono = Getter.getCookies();
        Mono<?> mono = Getter.getCsrfToken();
        Mono<?> mono = Getter.getCredentials();
        Mono<?> mono = Getter.getRecord("1f0b1851392eb90a81a736fcb61b165d.silk", "mp3");
        Mono<?> mono = Getter.getImage("1f0b1851392eb90a81a736fcb61b165d.jpg");
        Mono<?> mono = Getter.getStatus();
        Mono<?> mono = Getter.getVersionInfo();
        Object block = mono.block();
        System.out.println(block);
*/
    }

}