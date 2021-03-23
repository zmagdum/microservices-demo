# Microservice Using Spring Boot
This project illustrate how spring boot can be used to implement two of the patterns for microservices.

* Central Configuration Server 
* Service Registry and Discovery Server

This project has 5 modules 
### config-server
This project provides functionality for central configuration server. You can simply turn a spring boot application 
to a config server by adding `@EnableConfigServer` annotation and adding appropriate dependencies. 
To properly run this copy files in config-files to a outside directory somewhere on your disk 
and run `git init` `git add .` and `git commit -m "init"` to add files to the local git repository 
Update application.resources file for property `spring.cloud.config.server.git.uri`
Once you are done with this you can simple run `mvn spring-boot:run` and config server will be up on port 8081

### discovery-server 
This is Eureka Server. You turn any spring boot application to registry and discovery server by adding `@EnableEurekaServer`
and adding appropriate dependencies.
You can run this project using `mvn spring-boot:run`
It will come up on port 8761

### exchange-rate-service
This is a simple service to get exchange rates. Exchanges rates are stored in in-memory H2 database and initialized using liquibase.
You can run this project using `mvn spring-boot:run` 

### stock-price-service 
This is a simple service to stock price. Stock prices are stored in a in-memory H2 database which is again intialized using liquibase. 
You can run this project using `mvn spring-boot:run`

### stock-trade-service 
This is a simple service that calculate cost of a trade. It uses stock-price-service and exchange-rate-service to calculate the cost
Look at ExchangeRateServiceClient and StockPriceServiceClient classes. 
If you notice there is no configuration for these services in the application. The client gets the service address from the Eureka Server and makes calls to those 
services. 

You can test this service using test.json file provided
 
`curl -i -X POST http://localhost:8085/cost -H "Content-Type: application/json" --data-binary @test.json`

Again goal of this is to illustrate how you can use config and discovery servers. 
Do not think this to be a stock trading service or how to implement controllers.  
