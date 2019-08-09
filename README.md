# Test Builders Workshop 

The purpose of this project is to illustrate how we can use TestBuilder and 
Mikado in code refactoring. 

## Introduction

We own a company that sells Books in various cities around the world.

The price of the book is the same across all the countries (ex: a 2$ book in 
the US costs 2 Euros in France).

An invoice should be generated upon each purchase of books.

`FIXME Don't understand why there is a conversion when the price is the same everywhere?`
In addition to this conversion, each country has defined its own tax rules 
that we need to apply in order to get the final price of each book. 

## Countries, Currencies, Language and Tax Rates 

| Country       | Currency          | Language  | Exchange Rate to USD  | Tax Rate | 
| :-------------|:-----------------:| :--------:| :--------------------:|:--------:|
| USA           | USD               | English   | 1.0                   | 15%      |
| France        | Euro              | French    | 1.14                  | 25%      |
| UK            | Pound Sterling    | English   | 1.27                  | 20%      |
| Spain         | Euro              | Spanish   | 1.14                  | 10%      |
| China         | Renminbi          | Mandarin  | 0.15                  | 35%      |
| Japan         | YEN               | Japanese  | 0.0093                | 30%      |
| Australia     | Australian Dollar | English   | 0.70                  | 13%      |
| Germany       | Euro              | German    | 1.14                  | 22%      |


## Features

### Customers 

The customers of this application do the following: 

1. Add books to their basket 
2. Checkout basket to purchase the selected books 
3. The system generates an invoice following any purchase
4. The invoice is saved in the System's repository

### Invoice

1. The invoice takes into consideration the tax regulation for the respective
 countries
 
#### Tax Rules

1. To encourage their citizens to learn a second language, China & Spain 
decided to exclude all 2nd language books from taxes (i.e. no additional taxes 
will be applied to those books)
2. Germany dropped down the taxes to 5% on all books written by German Authors 
3. USA is reducing the taxes by 2% for all Novels, whereas UK is dropping that
by 7%

### Repository

The system has a Repository interface to save all the generated invoices.

The InMemoryRepository is one implementation of that interface to store the 
invoices in a HashMap in memory.

The MainRepository singleton returns the currently configured Repository.

### Report Generator 
1. The report generated should be based on all the items in the repository
2. The total sum in the report should be displayed in USD 

  