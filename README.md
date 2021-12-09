# On Demand Car Wash [![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This a on demand car wash service made using microservice architecture
with the following tools.

- IntelliJ IDEA Community edition 2021.2.3
- MongoDB Atlas
- Eureka Discovery Server
- API-Gateway

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
