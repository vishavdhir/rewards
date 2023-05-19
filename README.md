# rewards
Problem Statement -

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase. 
 
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction.
(e.g., a $120 purchase = 2x$20 + 1x$50 = 90 points).
 
Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total.
 
•	Solve using Spring Boot
•	Create a RESTful endpoint
•	Make up a data set to best demonstrate your solution
•	Check solution into GitHub

---------------------------------------------------------------------------------------------------------------------------------
Steps to use the API - 
1) clone the repository using below command (Git bash requried)
    git clone https://github.com/vishavdhir/rewards.git

2) To build - run clean install from IDE or execute "mvn clean install" from the inside of rewards directory. (use java 1.8)

3) To run the application execute command "mvn spring-boot:run" once build is success.

API End Point - http://localhost:8080/rewards/customers/{customerId}
e.g. http://localhost:8080/rewards/customers/1004


-----------------------------------------------------------------------------------------------------------------------------------
Note - 
* API supports only java 1.8
* As requirements did not provide any contract or specifications of the input/output, Simplest input/output objects have been used
* As requirements did not specified any validation or error conditions, no validation or error condidtion is handled by this repository.
* It is assumed, user will always pass a valid customer id. Refer resources/static/transactions.json to get the valid customer Ids for testing.
* Repository is created only for the demoonstration purpose. Lot of the things are requiring corrections, e.g project structure, input/output objects etc
* Repository is using static data embedded as json document.
* Code is working and tested manually using the static data used for mocking. (Only SANITY Test cases executed). 
* Will be adding JUnit Test cases at later stage if time permitted.
* Suggest to check the git commit history to see the approach used in implementation

