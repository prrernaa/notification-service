package com.prerna.notification_service.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}