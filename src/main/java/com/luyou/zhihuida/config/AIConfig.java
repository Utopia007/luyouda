package com.luyou.zhihuida.config;

import com.zhipu.oapi.ClientV4;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 鹿又笑
 * @create 2024/8/31-16:25
 * @description
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "ai")
public class AIConfig {

    private String apiKey;

    @Bean
    public ClientV4 getClientV4() {
        return new ClientV4.Builder(apiKey).build();
    }

}
