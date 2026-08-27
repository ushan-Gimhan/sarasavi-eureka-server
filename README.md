# SARASAVI Eureka Server

```
Student Name:   S.K.M Ushan Gimhan
Student ID:     241711098
Slack Handle: Ushan Gimhan
GCP Project ID: project-af908f5b-1cbf-40dc-9a7
Course: ITS 2130 — Enterprise Cloud Architecture
```

## Project Description
Netflix Eureka Service Registry for the SARASAVI Enterprise Bookshop Management System. All microservices register here and discover each other through this registry, enabling dynamic load-balanced service-to-service communication.

## Technology Stack
- Java 25
- Spring Boot 3.5.3
- Spring Cloud Netflix Eureka Server 2025.0.1
- Spring Boot Actuator

## Port
`8761`

## Setup / Getting Started

### Prerequisites
- Java 25+
- Maven 3.9+
- Config Server must be running on port `8888`

### Build
```bash
mvn clean package -DskipTests
```

### Run
```bash
java -jar target/eureka-server-1.0.0.jar
```

### Environment Variables
| Variable | Default | Description |
|----------|---------|-------------|
| `PORT` | `8761` | Server port |
| `EUREKA_HOSTNAME` | `localhost` | Hostname for this Eureka instance |

### Dashboard
```
http://localhost:8761
```
