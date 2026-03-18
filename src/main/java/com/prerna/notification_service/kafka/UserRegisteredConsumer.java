package com.prerna.notification_service.kafka;

import com.prerna.notification_service.service.EmailService;
import com.prerna.notification_service.service.FCMService;
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
    private final FCMService fcmService;

    @KafkaListener(topics = "user.registered", groupId = "notification-group")
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        log.info("Received user.registered event for: {}", event.getEmail());

        // Send welcome email
        emailService.sendWelcomeEmail(event.getEmail(), event.getName());

        // Send push notification if device token is present
        if (event.getDeviceToken() != null && !event.getDeviceToken().isBlank()) {
            fcmService.sendPushNotification(
                    event.getDeviceToken(),
                    "Welcome to Expense Tracker! 🎉",
                    "Hi " + event.getName() + "! Your account is ready."
            );
        }

        log.info("All notifications processed for userId: {}", event.getUserId());
    }
}