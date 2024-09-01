package com.luyou.zhihuida.model.dto.question;

import lombok.Data;

/**
 * @author 鹿又笑
 * @create 2024/9/1-9:47
 * @description
 */
@Data
public class QuestionAnswerDTO {

    /**
     * 题目
     */
    private String title;

    /**
     * 用户答案
     */
    private String userAnswer;

}
