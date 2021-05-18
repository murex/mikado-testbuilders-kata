# Get ready for Legacy Code Retreat with test data builders and the Mikado method

![Homework writton on a chalk board](https://github.com/murex/mikado-testbuilders-kata/raw/master/docs/images/homework.jpg)

*[Image Source](https://pixabay.com/illustrations/board-school-homework-slate-928381/)*

To ensure a smooth start of the workshop, we highly recommend that you go over the below two preparation steps before the training day.

This should only take few minutes of your time, but would save a lot of the workshop's time!  

## Configure your Dev Environment 

Firstly, let's configure the dev environment on your machine.

Configuration Steps:
1. First, you'll need to clone the [repo from github](https://github.com/murex/mikado-testbuilders-kata) to your machine
2. Pick the programming language of your preference ([C++](https://github.com/murex/mikado-testbuilders-kata/tree/master/cpp), [Java](https://github.com/murex/mikado-testbuilders-kata/tree/master/java), or [C#](https://github.com/murex/mikado-testbuilders-kata/tree/master/csharp))
3. Follow the steps defined in the BUILD_MANUAL corresponding to your preferred language. These manuals contain information on the required tools, versions, and processes to configure and run the project:
    1. [C++ Build Manual](https://github.com/murex/mikado-testbuilders-kata/blob/master/cpp/BUILD_MANUAL.md)
    1. [Java Build Manual](https://github.com/murex/mikado-testbuilders-kata/blob/master/java/BUILD_MANUAL.md)
    1. [C# Build Manual](https://github.com/murex/mikado-testbuilders-kata/blob/master/csharp/BUILD_MANUAL.md)
    1. [Kotlin Build Manual](https://github.com/murex/mikado-testbuilders-kata/blob/master/kotlin/BUILD_MANUAL.md)
4. Your environment will be ready when you can: 
    1. Open, compile, and run tests from your IDE
    2. Run the application from the command-line (i.e., "Run Command" section of the BUILD_MANUAL)
5. If you face any issue, you can refer to the [Troubleshooting](https://github.com/murex/mikado-testbuilders-kata/blob/master/docs/Troubleshooting.md) page. 

## Think of your Constraint 

During a Code Retreat, you often try to go through the same problem multiple times using different 'constraints'. For the second iteration of this code retreat, you will have the opportunity to choose your preferred constraint. 

We propose 3 constraints:

1. The [Test Data Builders](https://github.com/murex/mikado-testbuilders-kata/blob/master/docs/references/Test_Data_Builders.md) pattern: this technique let you factorize test data setup and make your tests more readable
2. The [Mikado Method](https://github.com/murex/mikado-testbuilders-kata/blob/master/docs/references/The_Mikado_Method.md): this technique lets you split large code changes into small independent steps that you can code, commit, integrate, and deploy independently, without blocking the feature delivery
3. [Test Data Builders](https://github.com/murex/mikado-testbuilders-kata/blob/master/docs/references/Test_Data_Builders.md) + [Mikado Method](https://github.com/murex/mikado-testbuilders-kata/blob/master/docs/references/The_Mikado_Method.md): mixing both techniques lets you write your tests incrementally, without blocking feature delivery and by increasing your overall code's testability at every step

Don't hesitate to have a look at this material before joining. Here are heuristics to pick the right constraint:

1. Pick a technique you don't yet know
2. If you know neither of the techniques, pick whichever you want, or just follow your group
3. Don't try the combination of the 2 techniques if you do not already know the 2 techniques

## Make sure you have everything ready

TODO Insert any additional requirments you would like your participants to check before the workshop: access an online tool, register to a meeting...