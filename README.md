Quiz Application - Microservices Architecture
A scalable Quiz Application built using Java Spring Boot and Spring Cloud Microservices. This project demonstrates a distributed system architecture featuring Service Discovery (Eureka), an API Gateway, and Client-side Load Balancing.

🚀 Architecture Overview
The application is split into decoupled microservices that communicate with each other. All client requests are routed through a central API Gateway.
Service Registry (Eureka Server): Acts as a phonebook where all microservices register themselves.
API Gateway: The single entry point for all external requests. It handles routing and load balancing to the appropriate microservices.
Question Service: Backend service responsible for managing the question bank (CRUD operations).
Quiz Service: Backend service responsible for creating and managing quizzes.

🛠️ Tech Stack
Language: Java  21
Framework: Spring Boot 3.x
Build Tool: Maven
Database: MySQL
Spring Cloud Components:
  Netflix Eureka: Service Discovery
  Spring Cloud Gateway: API Gateway (Reactive/Netty)
  Spring Cloud LoadBalancer: Client-side load balancing


⚙️ Setup & Installation
1. Prerequisites
JDK 17 or higher
Maven installed
MySQL Server running
2. Database Setup
Create the required database in MySQL before starting the Question Service:
CREATE DATABASE questiondb;
3. Installation Steps
Step 1: Start the Service Registry (Eureka)
This must be started first so other services can register.
cd service-registry
mvn spring-boot:run
Access Eureka Dashboard at: http://localhost:8761

Step 2: Start the API Gateway
cd api-gateway
mvn spring-boot:run
Gateway running at: http://localhost:8765

Step 3: Start the Microservices
Open separate terminals for each:
cd question-service
mvn spring-boot:run
cd quiz-service
mvn spring-boot:run

🔌 API Usage
All API requests should be directed to the API Gateway (localhost:8765). The gateway handles routing based on the service name.
Base URL: http://localhost:8765
Question Service Endpoints:
  Get All Questions:GET /question-service/question/allQuestions
  Add Question:POST /question-service/question/add

Quiz Service Endpoints
  Get Quiz by ID:GET /quiz-service/quiz/get/{id}
  Create Quiz:POST /quiz-service/quiz/create

🔧 Configuration Highlights
API Gateway (application.properties)
The Gateway uses manual routes with StripPrefix to ensure clean URL forwarding.

server.port=8765
spring.application.name=api-gateway
spring.cloud.gateway.server.webflux.discovery.locator.enabled=false

# Route: Quiz Service
spring.cloud.gateway.server.webflux.routes[0].id=quiz-service
spring.cloud.gateway.server.webflux.routes[0].uri=lb://QUIZ-SERVICE
spring.cloud.gateway.server.webflux.routes[0].predicates[0]=Path=/quiz-service/**
spring.cloud.gateway.server.webflux.routes[0].filters[0]=StripPrefix=1

# Route: Question Service
spring.cloud.gateway.server.webflux.routes[1].id=question-service
spring.cloud.gateway.server.webflux.routes[1].uri=lb://QUESTION-SERVICE
spring.cloud.gateway.server.webflux.routes[1].predicates[0]=Path=/question-service/**
spring.cloud.gateway.server.webflux.routes[1].filters[0]=StripPrefix=1


📝 License
This project is open-source and available for learning purposes.
