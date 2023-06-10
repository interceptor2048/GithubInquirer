package com.entitylogic.github.extractor.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Getter
public class GlobalConfiguration {

    @Value("${github.api.url}")
    private String githubApiUrl;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
