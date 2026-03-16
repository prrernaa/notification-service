package com.prerna.notification_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendWelcomeEmail(String toEmail, String name) {
        log.info("Sending welcome email to: {}", toEmail);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("prernajangra02@gmail.com");
        message.setTo(toEmail);
        message.setSubject("Welcome to Expense Tracker! 🎉");
        message.setText(
                "Hi " + name + ",\n\n" +
                        "Welcome to Expense Tracker!\n" +
                        "Your account has been successfully created.\n\n" +
                        "Start tracking your expenses smarter today.\n\n" +
                        "Cheers,\n" +
                        "Expense Tracker Team"
        );

        mailSender.send(message);
        log.info("Welcome email sent successfully to: {}", toEmail);
    }
}