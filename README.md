DigitalWallet
======
This repository contains skeleton code for several microservices to support a digital wallet where users can: 
* Add one or more credit cards
* Add one or more shipping addresses

The digital wallet can be accessible from any integrated merchant. During checkout users can: 
* Login to their wallet
* Choose any card and shipping address in their wallet

It can also transmit the selected payment information to the merchant for processing.

## Getting Started
### Run a .jar file
You can use the following command to run a .jar file:

    java -jar ./build/libs/commerce-config-server-0.0.1-SNAPSHOT.jar  

### Steps
You can also run this project locally by running following jar files:
* commerce-config-server-0.0.1-SNAPSHOT.jar. It will run at http://localhost:8888/
* commerce-eureka-0.0.1-SNAPSHOT.jar. It will run at http://localhost:8761/
* commerce-card-service-0.0.1-SNAPSHOT.jar. It will run at http://localhost:8091/
* commerce-address-service-0.0.1-SNAPSHOT.jar. It will run at http://localhost:8092/
* commerce-login-service-0.0.1-SNAPSHOT.jar. It will run at http://localhost:8093/
* commerce-transaction-service-0.0.1-SNAPSHOT.jar. It will run at http://localhost:8094/
* commerce-orches-checkout-0.0.1-SNAPSHOT.jar. It will run at http://localhost:8081/
* commerce-orches-userProfile-0.0.1-SNAPSHOT.jar. It will run at http://localhost:8082/

### Usages
The userProfile orchestrator will support the add/remove card/address business cases. The checkout orchestrator will support the transaction business case.

## Introduction
This project uses Spring Cloud Netflix to build the microservices and support a digital wallet. It uses Eureka to support the Service Discover and can be deployed to the Pivotal Cloud Foundry as well. You can also run this project locally.

### Eureka

### Components
We have four services and two consumers (orchestrators):
#### Services
* Card
* Address
* Login
* Transaction 

#### Consumers/Orchestrators
* userProfile 
* checkout

## Contact
Please feel free to reach out to me via bingnanz[at]andrew.cmu.edu.
