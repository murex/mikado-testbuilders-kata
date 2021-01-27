# Homework

![Pictures of sparrows](images/homework.jpg)

*[Image Source](https://pixabay.com/illustrations/board-school-homework-slate-928381/)*

To ensure a smooth start of the workshop, we highly recommend that you go over 
the below two preparation steps before the training day.

This should only take few minutes of your time, but would save a lot of the 
workshop's time!  

## Configure your Dev Environment 

Firstly, let's configure the dev environment on your machine.

Configuration Steps: 
1. Pick the programming language of your preference ([C++](../cpp), [Java](../java), or [C#](../csharp))
1. Follow the steps defined in the BUILD_MANUAL corresponding to your preferred
   language. These manuals contain information on the required tools, versions, 
   and processes to configure and run the project:
    1. [C++ Build Manual](../cpp/BUILD_MANUAL.md)
    1. [Java Build Manual](../java/BUILD_MANUAL.md)
1. Your environment will be ready when you can: 
    1. Open, compile, and run tests from your IDE
    1. Run the application from the command-line (i.e., "Run Command" section of the BUILD_MANUAL)
1. If you face any issue, you can refer to the [Troubleshooting](./Troubleshooting.md) page. 

## Pick your Constraint 

For the second iteration of the code retreat, you will have to pick a special 
constraint to try to fix the problem again. 

We propose 3 constraints:

1. The Test Data Builders pattern: this technique let you factorize test data setup and make your tests more readable
1. The Mikado Method: this technique lets you split large code changes in small independent steps that you can code, commit, integrate, and deploy independently, without blocking the feature delivery
1. Test Data Builders + Mikado Method: mixing both techniques lets you write your tests incrementally, without blocking feature delivery and by increasing your overall code's testability at every step

Here are heuristics to pick the right constraint:

1. Pick a technique you don't yet know
1. If you know neither of the techniques, pick whichever you want, or just follow your group
1. Don't try the combination of the 2 techniques if you do not already know the 2 techniques
