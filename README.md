# 🚀 Factory Tracking System

A microservices-based factory production monitoring system with real-time analytics, built using Spring Boot WebFlux, Spring Cloud (Eureka + API Gateway), and React.

---

## 📌 Features

- Real-time production dashboard  
- Line & bar charts for analytics (Production, Machine, Shift)  
- Full CRUD operations (Create, Read, Update, Delete)  
- Microservices architecture (Production + Machine Services)  
- Service discovery using Eureka Server  
- Centralized routing using API Gateway  
- Optimized frontend rendering using memoization  
- Table view with inline editing  

---

## 🏗️ Architecture
```text
Frontend (React)
      ↓
API Gateway (Spring Cloud Gateway)
      ↓
-----------------------------------
↓                                 ↓
Production Service           Machine Service
(Spring Boot WebFlux)        (Spring Boot WebFlux)
      ↓                                 ↓
------------- MySQL Database -------------
```
---

## 🛠️ Tech Stack

### Backend
- Java 21  
- Spring Boot WebFlux  
- Spring Cloud Gateway  
- Netflix Eureka  
- R2DBC (Reactive MySQL)  
- REST APIs  

### Frontend
- React.js  
- Recharts  
- JavaScript  

### Database
- MySQL  

---

## 📂 Project Structure
```text
factory-tracking-system/
├── eureka-server/
├── api-gateway/
├── production-service/
├── machine-service/
├── factory-ui/
```
---

## ▶️ How to Run

### Start Eureka
```bash
cd eureka-server  
mvn spring-boot:run
```

### Start Services
```bash
cd production-service  
mvn spring-boot:run
```

```bash
cd machine-service  
mvn spring-boot:run
```

### Start Gateway
```bash
cd api-gateway  
mvn spring-boot:run  
```

### Start Frontend
```bash
cd factory-ui  
npm install  
npm start  
```

---

## 🌐 API Endpoints

### Production
GET /production/full  
POST /production  
PUT /production/{id}  
DELETE /production/{id}  

### Machine
GET /machine  
POST /machine  
GET /machine/{id}  
DELETE /machine/{id}  

---

## 📈 Future Enhancements

- JWT Authentication  
- Docker Deployment  
- Advanced Analytics  
- Circuit Breaker  

---

## 🧠 Learnings

- Microservices architecture  
- Service discovery with Eureka  
- API Gateway routing  
- Reactive programming  
- Frontend performance optimization  
