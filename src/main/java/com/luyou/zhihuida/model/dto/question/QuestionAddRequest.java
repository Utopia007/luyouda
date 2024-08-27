package com.luyou.zhihuida.model.dto.question;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 创建题目请求
 */
@Data
public class QuestionAddRequest implements Serializable {

    /**
     * 题目内容（json格式）因为是json格式，此处封装 QuestionContentDTO
     */
    private QuestionContentDTO questionContent;

    /**
     * 应用 id
     */
    private Long appId;

    private static final long serialVersionUID = 1L;
}