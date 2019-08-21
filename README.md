# Test Builders Workshop 

Developers working on legacy code are always told to write tests before fixing 
any bug. In theory, it is very nice, but in practice, it is a lot more tricky!

We know we need to add tests, but it’s more easily said than done. 
In legacy codebase, just setting up the objects for the test is most often an 
unjustifiable nightmarish 2 weeks work. Mocks are a common workaround, but 
mocking legacy codebase usually makes them more difficult to change, not less!

In this hands-on pair programming dojo, you will combine the mikado method with 
test data builders to build a baby-step plan to add your first test to a legacy  
codebase. We'll draw a graph of nested test data builders so that we can 
instantiate test data, without mocks.

## Introduction

Let us assume that we own a company that sells Books on-line in various cities 
around the world. To manage our purchases, we have developed an internal system 
that has two portals:

### 1. Customer Portal
This portal, provides our customers with features allowing them to search for 
and purchase books. 

The purchase workflow is as follows: 
1. They add the books they want to purchase to a basket.     
1. To purchase the books, they need to checkout their basket.
1. Upon checkout, our system should generate an invoice for each basket
    1. The invoice should apply the tax rates and tax reduction rules for each 
    item in the basket 
    2. The total amount of the invoice should be the sum of amount of all books 
    (after tax) in the basket
    3. The currency of the invoice is the same currency as the respective 
    country    
1. The Invoice is sent to the customer and a copy of it is saved in our 
repository for future reference   

> It is important to note that each country has its own tax rates and tax 
reduction rules. You can find a table of those rules below.  
 
### 2. Reporting Portal 
The second portal is used by administrators to generate reports of the sales 
around the world. 

The report should include the following: 
1. Accumulative sum of all the invoices in the database
1. The currency of the report should be in USD 

## Countries, Currencies, Language, Tax Rates, and Tax Reduction Rules   

| Country       | Currency          | Language  | Exchange Rate to USD  | Tax Rate | Tax Reduction Rules                              | 
| :-------------|:-----------------:| :--------:| :--------------------:|:--------:|:------------------------------------------------:|
| USA           | USD               | English   | 1.0                   | 15%      | Reduction by 2% on Novels                        |  
| France        | Euro              | French    | 1.14                  | 25%      | No Reduction on taxes                            | 
| UK            | Pound Sterling    | English   | 1.27                  | 20%      | Reduction by 7% on Novels                        |
| Spain         | Euro              | Spanish   | 1.14                  | 10%      | Removed taxes on all foreign language books      |  
| China         | Renminbi          | Mandarin  | 0.15                  | 35%      | Removed taxes on all foreign language books      |
| Japan         | YEN               | Japanese  | 0.0093                | 30%      | No Reduction on taxes                            |
| Australia     | Australian Dollar | English   | 0.70                  | 13%      | No Reduction on taxes                            |     
| Germany       | Euro              | German    | 1.14                  | 22%      | Dropped to 5% on books written by German Authors |  


## Repository

The repository is our database where we store copies of all the issued invoices. 
The repository is defined by an interface that has 2 methods: 
 1. addInvoice: adds an invoice to the repository's database 
 1. getInvoiceMap: return all the available invoices in a Map  

Having this interface enables us to have different implementations for our 
database (Json, InMemory, Relational, NoSql, etc). 

In this workshop, we wrote a JSON implementation for this Repository interface
([JsonRepository.java](./src/main/java/com/murex/tbw/storage/JsonRepository.java)). 
We assumed that we are storing our data in JSON format in a [file](./src/main/resources/repository.json) 
under the resources folder.  

On initialization, the class parses the Json file and loads the data into a Map.

The MainRepository singleton returns the currently configured Repository.

## Your Tasks 

### Input 
Under the resources folder, you can find a JSON file ([repository.json](./src/main/resources/repository.json)) 
that contains the data of issued invoices from previous transactions.

> Note that the total amount of each invoice is not included in this list. 

Our Main class ([Application.java](./src/main/java/Application.java)) does the
following: 
1. Reads the JSON file
1. Rebuilds the invoices in our current Repository instance 
1. Initializes a ReportGenerator 
1. Prints 3 values: 
    1. Total number of books sold 
    2. Total number of issued invoices
    3. Sum of total amount of all invoices 

### Tasks
We noticed that some of the numbers generated by the report are wrong. 

| Country                                 | Actual | Expected | 
|:---------------------------------------:|:------:|:--------:| 
| The total number of books sold          | 16     |    16    |
| The total number of issued invoices     | 6      |    6     |
| The total amount of all invoices in USD | 1016.04|          |

Your task is to find and fix the bugs in the code to have the application
generate a correct report. 

   