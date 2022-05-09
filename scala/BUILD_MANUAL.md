# Scala Build Manual

## Prerequisites

### Build Tools
We provided the necessary to build the project with [sbt](https://www.scala-sbt.org/)!

### Scala Version
The source code of this project is in scala 2.
In the [build.sbt](build.sbt), you can notice that the source version has been set to `2.11.12`. 
Remember to change that configuration to your preferred version if needed :

```scala
scalaVersion := "2.11.12"
```

### IDEs
We are using [IntelliJ](https://www.jetbrains.com/idea/), but you can choose any IDE that
supports loading `sbt` projects!

## Process

> ***Reminder***:  You need to run the commands below from the [scala](.) folder!

To build and run the project, you can either use the build features in IntelliJ
or the sbt build command lines (as shown below):

### IntelliJ

After loading the project into IntelliJ, you should be able to build the project
using `sbt` built-in build tools.

To run the application from IntelliJ, simply run the main method in the
[Application](./src/main/scala/com/murex/Application.scala) class.

The 'Run' tool window should display the following output:
```shell
****************************************************
*****************Application Report*****************
****************************************************

The total number of books sold is: 16
The total number of issued invoices is: 6
The total amount of all invoices in USD is: 424.54

****************************************************
****************************************************
```

### Sbt
```shell
# Open an sbt console
> sbt

# Then run your sbt command
> compile

# Run the Application
> run
```
The following output should be generated:
```shell
****************************************************
*****************Application Report*****************
****************************************************

The total number of books sold is: 16
The total number of issued invoices is: 6
The total amount of all invoices in USD is: 424.54

****************************************************
****************************************************
```
