package com.luyou.zhihuida.scoring;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 鹿又笑
 * @create 2024/8/29-14:09
 * @description
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface ScoringStrategyConfig {

    /**
     * 应用类型
     * @return
     */
    int appType();

    /**
     * 评分策略
     * @return
     */
    int scoringStrategy();

}
