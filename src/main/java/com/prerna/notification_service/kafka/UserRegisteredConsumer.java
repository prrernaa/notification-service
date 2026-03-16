package com.prerna.notification_service.kafka;

import com.prerna.notification_service.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRegisteredConsumer {

    private final EmailService emailService;

    @KafkaListener(
            topics = "user.registered",
            groupId = "notification-group"
    )
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        log.info("Received user.registered event for: {}", event.getEmail());

        emailService.sendWelcomeEmail(event.getEmail(), event.getName());

        log.info("Notification processed for userId: {}", event.getUserId());
    }
}