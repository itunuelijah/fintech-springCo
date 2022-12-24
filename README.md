#     Fintech SpringCo

Technology stack:
• Java 11 
• Spring boot
• MySQL

A Fintech application with the following use cases:
Create customer CRUD
- Create account  CRUD
- Create API for customers to create accounts
- Create API for customers to fund/debit their different accounts
- Create API for customers to get the interest on their accounts assuming customers maintained a minimum balance of NGN 20,000.00 .
Create customer CRUD

Create abilities for users to view all relationships between customers, accounts and balances
+ Filter all customers with a specific account type
+ Filter all accounts for a specific customer
+ Filter all accounts without any customer
+ Filter all customers with zero balance in their accounts.

 Technology stack:
• Java Spring boot
• MySQL


Endpoints :

API Endpoints

• | GET  | /api/account/get/{accountId}               - To display a specific account by account id.

• | GET  | /api/account/list                          - To get the list of all created accounts.

• | POST | /api/account/debit                         - To withdraw money from an account.

• | GET  | /api/account/credit                        - To deposite money to an account.

• | GET  | /api/account/get/{duration}                - To get the interest on an account with minimum balance of 20,000 fo a number of year.

• | GET  | /api/customer/list                         - To get the list of saved customers.

• | GET  | /api/customer/get/{id}                     - To get a particular customer by customer id.

• | POST | /api/customer/save                         - To save of register customer.

• | PUT  | /api/customer/update/{customerId}          - To update customer information.

• |DELETE| /api/customer/delete/{id}                  - To delete customer. 

• | GET  | /api/account/get/{accountType}             - To ilter all customers with a specific account type.

• | GET  | /api/account/get/{specificCustomer}        - To filter all accounts for a specific customeraccounts.

• | GET  | /api/account/get/noCustomer                - To filter all accounts without any customer.

• | GET  | /api/account/get/zeroBalance               - Filter all customers with zero balance in their accounts.

