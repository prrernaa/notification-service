package com.prerna.notification_service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRegisteredConsumer {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "user.registered", groupId = "notification-group")
    public void consumeUserRegisteredEvent(String message) {
        try {
            UserRegisteredEvent event = objectMapper.readValue(message, UserRegisteredEvent.class);
            log.info("Received user.registered event for: {} ({})", event.getName(), event.getEmail());
            // Email sending will be added in Module 4
        } catch (Exception e) {
            log.error("Failed to process event: {}", e.getMessage());
        }
    }
}