package com.luyou.zhihuida.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 鹿又笑
 * @create 2024/9/1-20:55
 * @description
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.redis")
public class RedissonConfig {

    private String host;

    private Integer port;

    private Integer database;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + host + ":" + port)
                .setDatabase(database);
        return Redisson.create(config);
    }

}
