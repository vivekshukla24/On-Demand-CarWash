# On Demand Car Wash [![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This a on demand car wash service made using microservice architecture
with the following tools.

- IntelliJ IDEA Community edition 2021.2.3
- MongoDB Atlas
- Eureka Discovery Server - Port 8761
- API-Gateway - Port 9000
- Swagger API

## Microservices
- Admin Service - Port 8081
- Order Service - Port 8082
- User Service - Port 8083
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
- 4 Unique Microservices
- 7 DB models - 1 Embedded Document
- 2 Wrapper models
- 7 Repositories
