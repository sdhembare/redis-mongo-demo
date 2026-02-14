# 🚀 Redis + Mongo Spring Boot Demo

A production-style Spring Boot 3 application demonstrating:

- MongoDB integration
- Redis caching using @Cacheable
- Dockerized microservice setup
- Custom RedisCacheManager
- REST API for Product management

---

## 🛠 Tech Stack

- ☕ Java 17
- 🌱 Spring Boot 3.2
- 🍃 MongoDB
- 🔥 Redis
- 🐳 Docker & Docker Compose
- 📦 Maven

---

## 📦 Features

- CRUD operations using MongoDB
- Redis caching for faster responses
- Custom cache TTL configuration
- Docker-based local environment
- Clean architecture structure

---

## ⚙️ Run Locally (Without Docker)

```bash
mvn clean install
mvn spring-boot:run
```


## ⚙️ Run Locally (Using Docker)

```bash
mvn clean install
mvn clean package

docker compose up -d
```

for application logs
```bash
docker compose logs -f app
```

docker clean up operations

```bash
docker compose down -v
docker rmi app-demo
docker rmi redis:7
docker rmi mongo:7
```

