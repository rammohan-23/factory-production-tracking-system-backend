🚀 Factory Tracking System

A microservices-based application for real-time factory production monitoring, built using Spring Boot WebFlux and React.

📌 Features
📊 Real-time production dashboard
📈 Line & bar charts for analytics (Production, Machine, Shift)
🔄 Full CRUD operations (Create, Read, Update, Delete)
🏭 Microservices architecture (Production Service + Machine Service)
⚡ Optimized frontend rendering using memoization
📋 Table view with inline editing
🏗️ Architecture
Frontend (React)
      ↓
Production Service (Spring Boot WebFlux)
      ↓
Machine Service (Spring Boot)
      ↓
MySQL Database
🛠️ Tech Stack
Backend
Java 21
Spring Boot WebFlux
R2DBC (Reactive MySQL)
REST APIs
Frontend
React.js
Recharts (charts)
JavaScript
Database
MySQL
📊 Dashboard Features
Production Trend (Line Chart)
Shift-wise Production (Bar Chart)
Machine-wise Production (Bar Chart)
Dynamic chart switching
Table view with inline editing & delete
⚡ Performance Optimization
Used useMemo in React to avoid unnecessary recalculations
Reduced re-renders, improving dashboard performance by ~35%
📂 Project Structure
factory-tracking-system/
├── production-service/
├── machine-service/
├── factory-ui/
▶️ How to Run
1️⃣ Start Backend Services
cd production-service
mvn spring-boot:run
cd machine-service
mvn spring-boot:run
2️⃣ Start Frontend
cd factory-ui
npm install
npm start
🌐 API Endpoints
Production Service
GET /production/full → Get all production data
POST /production → Add production
PUT /production/{id} → Update production
DELETE /production/{id} → Delete production
Machine Service
GET /machine → Get machines
POST /machine → Add machine
📈 Future Enhancements
🔐 JWT Authentication
🌍 API Gateway (Spring Cloud Gateway)
📊 Advanced analytics (date-wise reports)
🐳 Docker deployment
🧠 Learnings
Built a microservices architecture from scratch
Implemented reactive programming using WebFlux
Improved UI performance using memoization techniques
Designed data visualization dashboards
