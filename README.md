## CLUSTEREDDATA WAREHOUSE
---
:scroll: **START**
## Introduction
Suppose you are part of a scrum team developing data warehouse for Bloomberg to analyze FX deals. One of customer stories is to accept deals details from and persist them into DB.

Data warehouse is a central repository of integrated data from one or more disparate sources. It is used for reporting and data analysis. Data warehouse is a subject-oriented, integrated, nonvolatile and time-variant collection of data in support of management's decision making process. 

---
### Task description
**Request Fields** should contain::
- Deal Unique Id;
- From Currency ISO Code "Ordering Currency";
- To Currency ISO Code;
- Deal timestamp;
- Deal Amount in ordering currency;
  
---
### Requirements

- System should not import same request twice.
- Validate row structure.(e.g: Missing fields, Type format..etc. 
- No rollback allowed, what every rows imported should be saved in DB

---
#### How to build
#### Requirements
- Java 11;
- Java IDE : IntelliJ (or Eclipse, Vscode, Netbeans);
- Database: Postgres;
- Postman(For testing);
  Steps by step for building and running the project locally;
  Clone the from the link git clone https://github.com/Chesca22/DealRequestAPI
- Open the cloned project in intelliJ Idea;
- Go to POM.xml the update Project to update all the maven dependencies;
- Maven Build the project and run;

#### Resource
- POST - /api/deals - Accepts deals 
- GET - /api/deals - Get all deals
- GET - /api/deals/{deal-id} Get a deal by id

---
#### Testing The API Endpoints
---
**Accepting Deal details**
- Endpoint: 'http://127.0.0.1:8080/api/deals';
```
curl --location --request POST 'http://127.0.0.1:8080/api/deals' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data-raw '{
                    "dealId": "3940046",
                    "orderingCurrency": USD",
                    "convertedCurrency": "NGN",
                    "amount": "45987"
             }'
````
**Response**
```
'{
                 "message": "Deal with Id number: 3940046 saved successfully",
                 "timeStamp": "2023-01-27T13:19:59.841533",
                 "data": "CREATED"
            }'
```
---

**Getting all deals details**
- Endpoint: '(http://localhost:8080/api/all-deals)';
      **Payload**
```
curl --location --request GET '(http://localhost:8080/api/all-deals)'
````
**Response**
```
{
    "message": "status",
    "data": [
        {
        "dealId": "3940046",
        "orderingCurrency": "USD",
        "convertedCurrency": "NGN",
        "amount": "¤45,987.00",
        "dealTimeStamp": "2023-01-27T13:19:59.722176"
    },
    {
        "dealId": "468943GH",
        "orderingCurrency": "PLN",
        "convertedCurrency": "EUR",
        "amount": "¤ 1,500.00",
        "dealTimeStamp": "2023-01-27T13:31:05.477708"
    }
    ]
}
```
---
**Documentation**
http://localhost:8080/swagger-ui.html
