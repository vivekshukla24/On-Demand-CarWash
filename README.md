# On Demand Car Wash [![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This a on demand car wash service made using microservice architecture
with the following tools.

- IntelliJ IDEA Community edition 2021.2.3
- MongoDB Atlas
- Eureka Discovery Server - Port 8761
- Zuul Gateway-API - Port 9000
- Swagger API
- Spring Security (JWT Tokens)

## Microservices
- Admin Service - Port 8081
- Order Service - Port 8082
- User Service - Port 8083
- Payment Service - Port 8084
- Washer Service - Port 8085

### Mongo Databases
- AdminDetails DB
- User DB
- Order DB - Embedded Document of Car model
- Washer DB
- Ratings DB
- WashPacks DB

### Some Details
- 3 Entities (Those microservices that act as front-end interact with methods)
- 4 Unique Microservices (Mentioned in microservices section above)
- 7 DB models - 1 Embedded Document(Car)
- 2 Wrapper models (OrderReceipt, WasherRatings)
- 7 Repositories

### Websites for swagger UI's for three Microservice Entities
- Admin Service -> http://localhost:8081/swagger-ui.html
- User Service -> http://localhost:8083/swagger-ui.html
- Washer Service -> http://localhost:8085/swagger-ui.html
