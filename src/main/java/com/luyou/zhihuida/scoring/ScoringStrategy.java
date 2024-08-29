package com.luyou.zhihuida.scoring;

import com.luyou.zhihuida.model.entity.App;
import com.luyou.zhihuida.model.entity.UserAnswer;

import java.util.List;

/**
 * @author 鹿又笑
 * @create 2024/8/28-20:56
 * @description
 */
public interface ScoringStrategy {

    /**
     * 执行评分 （策略模式）
     *
     * @param choices
     * @param app
     * @return
     * @throws Exception
     */
    UserAnswer doScore(List<String> choices, App app) throws Exception;

}
