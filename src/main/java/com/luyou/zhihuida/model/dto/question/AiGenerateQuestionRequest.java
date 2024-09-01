package com.luyou.zhihuida.model.dto.question;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 鹿又笑
 * @create 2024/8/31-21:30
 * @description
 */
@Data
public class AiGenerateQuestionRequest implements Serializable {

    /**
     * 应用id
     */
    private Long appId;

    /**
     * 题目数
     */
    int questionNumber = 10;

    /**
     * 选项数
     */
    int optionNumber = 2;

    private static final long serialVersionUID = 1L;

}
