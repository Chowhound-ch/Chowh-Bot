# 基于Java SPI、能对接多种qq bot实现的机器人
## 支持的框架
- [x] [OneBot标准] [chowh-bot-onebot-provider](chowh-bot-provider%2Fchowh-bot-onebot-provider)
- [x] [Napcat] (基于Onebot标准) [chowh-bot-onebot-napcat-provider](chowh-bot-provider%2Fchowh-bot-onebot-napcat-provider)
## 不同实现间切换方法
若bot使用的功能仅靠[chowh-bot-common](chowh-bot-common)中的类实现则修改pom.xml中的依赖即可
#### 注意
- 请确保只有一个实现在classpath中
- 不同实现可能涉及不同的功能，这部分功能会单独定义在provider中单独的class，若涉及则切换实现时需要修改代码
```xml
    <dependencies>
        <!-- OneBot标准下的Napcat -->
        <dependency>
            <groupId>per.chowhound.bot</groupId>
            <artifactId>chowh-bot-onebot-napcat-provider</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!-- OneBot标准 -->
        <dependency>
            <groupId>per.chowhound.bot</groupId>
            <artifactId>chowh-bot-onebot-provider</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

```
## 使用方法
```java
    public static void main(String[] args) {
//        Mono<?> mono = Setter.deleteMsg(2067246370L);
//        Mono<?> mono = Setter.setGroupKick(811545265L, 2854203740L, false);
//        Mono<?> mono = Setter.setGroupBan(811545265L, 2411214338L, 60 * 5);
//        Mono<?> mono = Setter.setGroupAnonymousBan(811545265L, 60 * 5, "flag");
//        Mono<?> mono = Setter.setGroupWholeBan(811545265L);
//        Mono<?> mono = Setter.setGroupAdmin(811545265L, 825352674L, true);
//        Mono<?> mono = Setter.setGroupAnonymous(811545265L, true);
//        Mono<?> mono = Setter.setGroupCard(811545265L, 825352674L, "给你换个群昵称");
//        Mono<?> mono = Setter.setGroupName(811545265L, "这是新的群名");
//        Mono<?> mono = Setter.setGroupLeave(640751780L);
//        Mono<?> mono = Setter.setGroupSpecialTitle(640751780L, 825352674L, "群专属头衔");
//        Mono<?> mono = Setter.setFriendAddRequest("暂时不知道", true, "好友备注");
//        Mono<?> mono = Setter.setGroupAddRequest("暂时不知道", Setter.GROUP_ADD_REQUEST, false, "拒绝理由");



    // Sender
//        Messages messageTest = Messages.builder()
//                .text("瑟图")
//                .image("https://multimedia.nt.qq.com.cn/download?appi" +
//                        "d=1406&fileid=Cgk4MjUzNTI2NzQSFGq64fM19whJk6BSNJL-7rkq" +
//                        "lu97GK6FfSD-Cijgsee30uqHA1CAuy8&spec=0&rkey=CAISKKSBek" +
//                        "jVG1fMAcBxLG5StXeRFGyAM4jZBZWkLNv4AHO4mgf-IUQP76s"
//                ).build();
//        Mono<?> mono = Sender.sendPrivateMsg(825352674L, messageTest, false);
//        Mono<?> mono = Sender.sendGroupMsg(811545265L, messageTest, false);
//        Mono<?> mono = Sender.sendMsg(Sender.GROUP_MSG, 811545265L, messageTest, false);
//        Mono<?> mono = Sender.canSendImage();
//        Mono<?> mono = Sender.canSendRecord();

//        // Getter
//        Mono<?> mono = Getter.getBotInfo();
//        Mono<?> mono = Getter.getBotInfo();
//        Mono<?> mono = Getter.getMsg(97151221L);
//        Mono<?> mono = Getter.getFriendList();
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
//        Mono<?> mono = Getter.getVersionInfo();

    Object block = mono.block();
    System.out.println(block);

    System.out.println();
}
```