package com.luyou.zhihuida.AITest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.luyou.zhihuida.manager.AIManager;
import com.zhipu.oapi.ClientV4;
import com.zhipu.oapi.Constants;
import com.zhipu.oapi.service.v4.model.ChatCompletionRequest;
import com.zhipu.oapi.service.v4.model.ChatMessage;
import com.zhipu.oapi.service.v4.model.ChatMessageRole;
import com.zhipu.oapi.service.v4.model.ModelApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 鹿又笑
 * @create 2024/8/31-15:36
 * @description
 */
@SpringBootTest
public class ZhiPuAITest {

    public static final String API_KEY = "c76f4c07f5915a504e2633f0b4ac7397.Bybix67tfkrI8M6Y";

    static ClientV4  client = new ClientV4.Builder(API_KEY).build();

    private static String requestIdTemplate = "zhipuai-java-sdk-%s";

    @Resource
    private ClientV4 clientV4;

    @Resource
    private AIManager aiManager;


    /**
     * 同步调用
     */
    @Test
    public void testInvoke() {
        List<ChatMessage> messages = new ArrayList<>();
        ChatMessage chatMessage = new ChatMessage(ChatMessageRole.USER.value(), "作为一名营销专家，请为智谱开放平台创作一个吸引人的slogan");
        messages.add(chatMessage);
        String requestId = String.format(requestIdTemplate, System.currentTimeMillis());

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model(Constants.ModelChatGLM4)
                .stream(Boolean.FALSE)
                .invokeMethod(Constants.invokeMethod)
                .messages(messages)
                .requestId(requestId)
                .build();
        ModelApiResponse invokeModelApiResp = clientV4.invokeModelApi(chatCompletionRequest);
        System.out.println(invokeModelApiResp.getCode());
        System.out.println(invokeModelApiResp.getData().getChoices().get(0).getMessage().getContent());
        System.out.println(invokeModelApiResp.getMsg());
    }

    @Test
    public void testInvoke2() {
        String system = "你是一位严谨的出题专家，我会给你如下信息：\n" +
                "```\n" +
                "应用名称，\n" +
                "【【【应用描述】】】，\n" +
                "应用类别，\n" +
                "要生成的题目数，\n" +
                "每个题目的选项数\n" +
                "```\n" +
                "\n" +
                "请你根据上述信息，按照以下步骤来出题：\n" +
                "1. 要求：题目和选项尽可能地短，题目不要包含序号，每题的选项数以我提供的为主，题目不能重复\n" +
                "2. 严格按照下面的 json 格式输出题目和选项\n" +
                "```\n" +
                "[{\"options\":[{\"value\":\"选项内容\",\"key\":\"A\"},{\"value\":\"\",\"key\":\"B\"}],\"title\":\"题目标题\"}]\n" +
                "```\n" +
                "title 是题目，options 是选项，每个选项的 key 按照英文字母序（比如 A、B、C、D）以此类推，value 是选项内容\n" +
                "3. 检查题目是否包含序号，若包含序号则去除序号\n" +
                "4. 返回的题目列表格式必须为 JSON 数组\n";
        String user = "小学数学测验，\n" +
                "【【【小学三年级的数学题】】】，\n" +
                "得分类，\n" +
                "10，\n" +
                "3\n";
        System.out.println(aiManager.doRequest(system, user, Boolean.FALSE, 0.5f));

    }



}
