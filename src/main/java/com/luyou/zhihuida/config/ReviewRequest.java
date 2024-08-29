package com.luyou.zhihuida.config;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 鹿又笑
 * @create 2024/8/28-20:35
 * @description
 */
@Data
public class ReviewRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 状态：0-待审核, 1-通过, 2-拒绝
     */
    private Integer reviewStatus;

    /**
     * 审核信息
     */
    private String reviewMessage;


    private static final long serialVersionUID = 1L;

}
