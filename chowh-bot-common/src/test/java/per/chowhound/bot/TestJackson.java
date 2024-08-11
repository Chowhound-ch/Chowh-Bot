package per.chowhound.bot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import per.chowhound.bot.event.PrivateMessageEvent;
import per.chowhound.bot.utils.JacksonUtil;

/**
 * @author : Chowhound
 * @since : 2024/8/11 - 16:27
 */
@Slf4j
public class TestJackson {
    public static final String JSON = "{\"self_id\":2177621094,\"user_id\":825352674,\"time\":1723364374,\"message_id\":197839942,\"message_seq\":197839942,\"real_id\":197839942,\"message_type\":\"private\",\"sender\":{\"user_id\":825352674,\"nickname\":\"原来这也行？\",\"card\":\"\"},\"raw_message\":\"111、\",\"font\":14,\"sub_type\":\"friend\",\"message\":[{\"data\":{\"text\":\"111、\"},\"type\":\"text\"}],\"message_format\":\"array\",\"post_type\":\"message\",\"raw\":{\"msgId\":\"7401793626162580189\",\"msgRandom\":\"363613710\",\"msgSeq\":\"3247\",\"cntSeq\":\"0\",\"chatType\":1,\"msgType\":2,\"subMsgType\":1,\"sendType\":0,\"senderUid\":\"u_Jb9aZMbp7S6EssrXnDo1fw\",\"peerUid\":\"u_Jb9aZMbp7S6EssrXnDo1fw\",\"channelId\":\"\",\"guildId\":\"\",\"guildCode\":\"0\",\"fromUid\":\"0\",\"fromAppid\":\"0\",\"msgTime\":\"1723364374\",\"msgMeta\":\"0x\",\"sendStatus\":2,\"sendRemarkName\":\"\",\"sendMemberName\":\"\",\"sendNickName\":\"\",\"guildName\":\"\",\"channelName\":\"\",\"elements\":[{\"elementType\":1,\"elementId\":\"7401793626162580188\",\"extBufForUI\":\"0x\",\"textElement\":{\"content\":\"111、\",\"atType\":0,\"atUid\":\"0\",\"atTinyId\":\"0\",\"atNtUid\":\"\",\"subElementType\":0,\"atChannelId\":\"0\",\"linkInfo\":null,\"atRoleId\":\"0\",\"atRoleColor\":0,\"atRoleName\":\"\",\"needNotify\":0},\"faceElement\":null,\"marketFaceElement\":null,\"replyElement\":null,\"picElement\":null,\"pttElement\":null,\"videoElement\":null,\"grayTipElement\":null,\"arkElement\":null,\"fileElement\":null,\"liveGiftElement\":null,\"markdownElement\":null,\"structLongMsgElement\":null,\"multiForwardMsgElement\":null,\"giphyElement\":null,\"walletElement\":null,\"inlineKeyboardElement\":null,\"textGiftElement\":null,\"calendarElement\":null,\"yoloGameResultElement\":null,\"avRecordElement\":null,\"structMsgElement\":null,\"faceBubbleElement\":null,\"shareLocationElement\":null,\"tofuRecordElement\":null,\"taskTopMsgElement\":null,\"recommendedMsgElement\":null,\"actionBarElement\":null}],\"records\":[],\"emojiLikesList\":[],\"commentCnt\":\"0\",\"directMsgFlag\":0,\"directMsgMembers\":[],\"peerName\":\"\",\"freqLimitInfo\":null,\"editable\":false,\"avatarMeta\":\"\",\"avatarPendant\":\"\",\"feedId\":\"\",\"roleId\":\"0\",\"timeStamp\":\"0\",\"clientIdentityInfo\":null,\"isImportMsg\":false,\"atType\":0,\"roleType\":0,\"fromChannelRoleInfo\":{\"roleId\":\"0\",\"name\":\"\",\"color\":0},\"fromGuildRoleInfo\":{\"roleId\":\"0\",\"name\":\"\",\"color\":0},\"levelRoleInfo\":{\"roleId\":\"0\",\"name\":\"\",\"color\":0},\"recallTime\":\"0\",\"isOnlineMsg\":true,\"generalFlags\":\"0x\",\"clientSeq\":\"894\",\"fileGroupSize\":null,\"foldingInfo\":null,\"multiTransInfo\":null,\"senderUin\":\"825352674\",\"peerUin\":\"825352674\",\"msgAttrs\":{},\"anonymousExtInfo\":null,\"nameType\":0,\"avatarFlag\":0,\"extInfoForUI\":null,\"personalMedal\":null,\"categoryManage\":0,\"msgEventInfo\":null,\"id\":197839942}}";

    public static void main(String[] args) {
        PrivateMessageEvent privateMessageEvent = JacksonUtil.readValue(JSON, PrivateMessageEvent.class);
        System.out.println(privateMessageEvent);
    }
    @Test
    public void test() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Human.Man man = new Human.Man();
        man.setManField("男人");
        man.setDistrict("北京");

        String manJson = mapper.writeValueAsString(man);
        log.info("序列化Man ：【 {} 】", manJson);
        Human human = mapper.readValue(manJson, Human.class);
        log.info("子类转父类 ======================");
        String humanJson = mapper.writeValueAsString(human);
        log.info("反序列化man -> per.chowhound.bot.Human ：【 {} 】", humanJson);
        log.info("human.getDistrict()  ：【 {} 】",  human.getDistrict());
    }

}
