package com.entitylogic.github.extractor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class GlobalConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
