# apexTest_8_23_2021
Notes: Used Springboot to develop api. DB is not used so created test data to act like Repository layer. Written Junit Test classes as well.
/*Problem Statement
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase. 
 
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction 
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
 
Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.
 
•	Solve using Spring Boot
•	Make up a data set to best demonstrate your solution
•	Check solution into GitHub
*/

Created microservices module(Rest/JSON api) using springboot(SpringMVC)
Sample Endpoint URL:  http://localhost:8081/api/rewards/100
Takes customer ID in path variable and provide summary of total points earn break down by each month
Sample Response:
{
    "customerId": 100,
    "customerName": "Tango",
    "summary": [
        {
            "month": "6/2021",
            "total": 340.0
        },
        {
            "month": "8/2021",
            "total": 20.0
        },
        {
            "month": "7/2021",
            "total": 1100.0
        }
    ]
}
