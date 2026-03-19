# Notification Service 📧

A Kafka-based microservice that listens for `user.registered` events
and sends welcome emails via Gmail SMTP and push notifications via Firebase FCM.

## Architecture
```
Expense Tracker API → Kafka (user.registered) → Notification Service
                                                        ├── Gmail SMTP (Welcome Email)
                                                        └── Firebase FCM (Push Notification)
```

## Tech Stack

- Java 21
- Spring Boot 3.4.x
- Apache Kafka
- JavaMailSender (Gmail SMTP)
- Firebase Admin SDK (FCM)
- Docker & Docker Compose
- Lombok

## Prerequisites

- Docker & Docker Compose
- Gmail account with App Password enabled
- Firebase project with service account key

## Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/prrernaa/notification-service.git
cd notification-service
```

### 2. Create `.env` file in project root
```
MAIL_USERNAME=your-email@gmail.com
MAIL_PASSWORD=your-16-char-app-password
```

### 3. Add Firebase service account
Place your `firebase-service-account.json` in:
```
src/main/resources/firebase-service-account.json
```

### 4. Run with Docker Compose
```bash
cd docker
docker-compose up --build
```

Service starts on **port 9093**

### 5. Run locally (without Docker)
```bash
./mvnw spring-boot:run
```

## Kafka Topic

| Topic | Producer | Consumer |
|---|---|---|
| `user.registered` | Expense Tracker API | Notification Service |

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/notifications/test-push` | Test FCM push notification |

## Environment Variables

| Variable | Description |
|---|---|
| `MAIL_USERNAME` | Gmail address to send from |
| `MAIL_PASSWORD` | Gmail App Password (16 chars, no spaces) |
| `SPRING_KAFKA_BOOTSTRAP_SERVERS` | Kafka broker address |

## Related Project

- [Expense Tracker API](https://github.com/prrernaa/expense-trcker-api)