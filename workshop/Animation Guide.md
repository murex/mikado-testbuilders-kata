# Animation Guide

## Time Table

TODO

## Retrospectives

Here are the topics that usually come up during mini-retros

### 2 - Easy Fix, Difficult Test

| The good                   | The bad                                      |
|----------------------------|----------------------------------------------|
| We managed to fix and test | We see a lot of duplication in the tests     |
|                            | Tests took more time to write than the fixes |

How would these problems become in the legacy code base you deal with everyday?
What took so long about adding the test?
What could we do against these problems?

### 3 - Building Test Data

| The good                  | The bad                                        |
|---------------------------|------------------------------------------------|
| Tests are more readable   | Writing the test data builders is even slower  |
| Less duplication in tests | Not sure how to apply this in other code bases |

How would these problems become in the legacy code base you deal with everyday?
What could we do against these problems?

### 4 - Mikado Method to the Rescue

Here is the typical feedback about combining the mikado method and test data
builders.

| The good                                      | The bad                           |
|-----------------------------------------------|-----------------------------------|
| Tests are more readable                       | Test for the bug is postponed     |
| Less duplication in tests                     | Cyclic dependencies remain tricky |
| Testability increases at every step           |                                   |
| It snowballs                                  |                                   |
| Avoids mocks                                  |                                   |
| You don't need full-fledged builders to start |                                   |

Ideas to apply this in your daily work:

* Do this workshop with your team
* Stick test mikado graphs on the wall, so that everyone can contribute
* Try it on the next bug you have to deal with, while pairing with a buddy

## Pedagogy

`TODO` 

Training from the back of the room
* Turn and talk
* rapid response
* paired work
* Teach back in mini-retros
* Wall and Web centers
* Learning logs
