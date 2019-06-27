# Test Builders Workshop 

The purpose of this project is to illustrate how we can use TestBuilder and Mikado in code refactoring. 

## Introduction 
We own a company that sells Books in various cities around the world. 
The price of the book is saved in USD but upon sale it is converted to the local currency.
In addition to this conversion, each country has defined a its own tax rules that we need to apply in order to get the final price of each book. 

## Countries & Currencies 

| Country       | Currency          | Language  | Exchange Rate to USD  | Tax Rate | 
| --------------|:-----------------:| :--------:| :--------------------:|:--------:|
| USA           | USD               | English   | 1.0                   | 15%      |
| France        | Euro              | French    | 1.14                  | 25%      |
| UK            | Pound Sterling    | English   | 1.27                  | 20%      |
| Spain         | Euro              | Spanish   | 1.14                  | 10%      |
| China         | Renminbi          | Chinese   | 0.15                  | 35%      |
| Japan         | YEN               | Japanese  | 0.0093                | 30%      |
| Australia     | Australian Dollar | English   | 0.70                  | 13%      |
| Germany       | Euro              | German    | 1.14                  | 22%      |


## Tax Rules
1. To encourage their citizens to learn a second language, China & Spain decided to exclude all 2nd language books from taxes (i.e. no additional taxes will be applied to those books)
2. Germany dropped down the taxes to 5% on all books written by German Authors 
3. USA is reducing the taxes by 2% for all Novels, whereas UK is dropping that by 7%
  