package com.prerna.notification_service.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FCMService {

    public void sendPushNotification(String deviceToken, String title, String body) {
        try {
            Message message = Message.builder()
                    .setNotification(Notification.builder()
                            .setTitle(title)
                            .setBody(body)
                            .build())
                    .setToken(deviceToken)
                    .build();

            String response = FirebaseMessaging.getInstance().send(message);
            log.info("Push notification sent successfully. FCM response: {}", response);

        } catch (Exception e) {
            log.error("Failed to send push notification: {}", e.getMessage());
        }
    }
}