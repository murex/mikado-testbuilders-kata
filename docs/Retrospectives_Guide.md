# Retrospectives

![Rear view in the mirror of a car](./images/retro.jpg)

*[Image Source](https://pixabay.com/fr/photos/miroir-r%C3%A9trospective-auto-r%C3%A9flexion-4992200/)*

Here are the topics that usually come up during mini-retros

## 2 - Easy Fix, Difficult Test

| The good                   | The bad                                      |
|----------------------------|----------------------------------------------|
| We managed to fix and test | We see a lot of duplication in the tests     |
|                            | Tests took more time to write than the fixes |
|                            | Rollback was painful                         |
|                            | Minimal Coverage                             |
|                            | Tests are ugly                               |

What issues did you face while writing your tests?  
Do you face the same problems with your existing legacy code?    
How can you tackle those problems to avoid having them in the future?  

## 3 - Building Test Data

| The good                            | The bad                                        |
|-------------------------------------|------------------------------------------------|
| Tests are more readable             | Writing the test data builders is even slower  |
| Less duplication in tests           | Not sure how to apply this in other code bases |
| Would make adding new tests easier  |                                                |

What issues did you face while writing your tests with Test Data Builders?  
How can you compare this approach of writing tests to the previous section?   
How could you apply this in your team?

## 4 - Mikado Method

| The good                            | The bad                                       |
|-------------------------------------|-----------------------------------------------|
| We don't have to stop for 3 weeks to add a test | Test for the bug is postponed     |
| We can split testing in small tasks | Tests are the same as in the default approach |

What issues did you face while writing your tests by following the Mikado Method?     
How can you compare this approach of writing tests to the previous section?   
How could you apply this in your team?

## 5 - Mikado Method plus Test Data Builders

Here is the typical feedback about combining the mikado method and test data
builders.

| The good                                      | The bad                           |
|-----------------------------------------------|-----------------------------------|
| Tests are more readable                       | Test for the bug is postponed     |
| Less duplication in tests                     | Cyclic dependencies remain tricky |
| Testability increases at every step           |                                   |
| People are more likely to add tests           |                                   |
| People are more likely to improve the builders|                                   |
| You don't need full-fledged builders to start |                                   |
| It can become viral!                          |                                   |
| Avoids mocks                                  |                                   |

What issues did you face while writing your tests by following the Mikado Method?     
How can you compare this approach of writing tests to the previous 2 sections?     
Can you use this method with your team?   

Ideas to apply this in your daily work: 
* Stick test mikado graphs on the wall, so that everyone can contribute
* Use an online mind-map software and share it with the team (especially with 
a remote team)
* Try it on the next bug you have to deal with, while pairing with a buddy
* Try [mob programming](https://en.wikipedia.org/wiki/Mob_programming), to quickly
  agree on a shared way of working
