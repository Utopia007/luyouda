package com.luyou.zhihuida.scoring;

import com.luyou.zhihuida.common.ErrorCode;
import com.luyou.zhihuida.exception.BusinessException;
import com.luyou.zhihuida.model.entity.App;
import com.luyou.zhihuida.model.entity.UserAnswer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 鹿又笑
 * @create 2024/8/29-14:16
 * @description
 */
public class ScoringStrategyExecutor {

    // 策略列表
    @Resource
    private List<ScoringStrategy> scoringStrategyList;

    /**
     * 评分
     * @param choiceList
     * @param app
     * @return
     * @throws Exception
     */
    public UserAnswer doScore(List<String> choiceList, App app) throws Exception {
        Integer appType = app.getAppType();
        Integer appScoringStrategy = app.getScoringStrategy();
        if (appType == null || appScoringStrategy == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "应用配置有误，未找到匹配的策略");
        }
        // 根据注解获取策略
        for (ScoringStrategy scoringStrategy : scoringStrategyList) {
            // isAnnotationPresent：如果被标记类上存在ScoringStrategyConfig的注释，返回true
            if (scoringStrategy.getClass().isAnnotationPresent(ScoringStrategyConfig.class)) {
                ScoringStrategyConfig scoringStrategyConfig = scoringStrategy.getClass().getAnnotation(ScoringStrategyConfig.class);
                if (scoringStrategyConfig.appType() == appType && scoringStrategyConfig.scoringStrategy() == appScoringStrategy) {
                    return scoringStrategy.doScore(choiceList, app);
                }
            }
        }
        throw new BusinessException(ErrorCode.SYSTEM_ERROR, "应用配置有误，未找到匹配的策略");
    }

}
