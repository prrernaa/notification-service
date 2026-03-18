package com.prerna.notification_service.controller;

import com.prerna.notification_service.service.FCMService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class FCMController {

    private final FCMService fcmService;

    @PostMapping("/test-push")
    public ResponseEntity<String> testPushNotification(
            @RequestParam String deviceToken,
            @RequestParam String name) {

        fcmService.sendPushNotification(
                deviceToken,
                "Welcome to Expense Tracker! 🎉",
                "Hi " + name + "! Your account is ready."
        );

        return ResponseEntity.ok("Push notification triggered for token: " + deviceToken);
    }
}