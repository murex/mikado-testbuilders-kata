# Java Build Manual

## Prerequisites

### Build Tools 
We provided the necessary to build the project with either [Maven](https://maven.apache.org/) 
or [Gradle](https://gradle.org/)!

Please ensure that you have at-least one of them installed on your machine.  

### Java Version 
The source code of this project is compatible with [Java-8](https://www.oracle.com/java/technologies/java8.html) and above. 
In the [pom.xml](pom.xml) and [build.gradle](build.gradle), you can notice that the source version 
has been set to 1.8. Remember to change that configuration to your preferred version if needed. 

### IDEs
We are using [IntelliJ](https://www.jetbrains.com/idea/), but you can choose any IDE that
supports loading Maven or Gradle projects!
 
## Process 

> ***Reminder***:  You need to run the commands below from the [java](.) folder!

To build and run the project, you can either use the build features in IntelliJ
or the Maven & Gradle build command lines (as shown below):

### IntelliJ 

After loading the project into IntelliJ, you should be able to build the project
using either the Maven or Gradle built-in build tools. 

To run the application from IntelliJ, simply run the main method in the 
[Application](src/main/java/com/murex/Application.java) class.

The 'Run' tool window should display the following output:
```shell
****************************************************
*****************Application Report*****************
****************************************************

The total number of books sold is: 16
The total number of issued invoices is: 6
The total amount of all invoices in USD is: 424.57

****************************************************
****************************************************
```

### Maven
#### Build Command 
```shell
> mvn clean install 
```

If executed successfully, the above command should generate the following: 
1. The typical maven [target](target) folder
1. The executable jar file [MikadoTestBuilderKata](target/MikadoTestBuilderKata.jar) 
   under the [target](target) folder.
   
#### Run Command
To try out the application, run the command: 
```shell
# Windows
  > java -jar target\MikadoTestBuilderKata.jar

# Mac & Linux
  > java -jar target/MikadoTestBuilderKata.jar
```

The following output should be generated: 
```shell
****************************************************
*****************Application Report*****************
****************************************************

The total number of books sold is: 16
The total number of issued invoices is: 6
The total amount of all invoices in USD is: 424.57

****************************************************
****************************************************
```

### Gradle
#### Build Command
```shell
# Option 1: Gradle is already installed on your machine 
> gradle clean build 

# Option 2: Gradle is NOT installed on your machine
# Windows  
> .\gradlew.bat clean build

# Mac & Linux
> ./gradlew clean build
```

If executed successfully, the above command should generate the following:
1. The typical gradle [build](build) folder
1. The executable jar file [MikadoTestBuilderKata](build/libs/MikadoTestBuilderKata.jar)
   under the [build/libs](build/libs) folder.

#### Run Command
To try out the application, run the command:

```shell
# Windows 
  > java -jar build\libs\MikadoTestBuilderKata.jar

# Mac & Linux 
  > java -jar build/libs/MikadoTestBuilderKata.jar
```

The following output should be generated:
```shell
****************************************************
*****************Application Report*****************
****************************************************

The total number of books sold is: 16
The total number of issued invoices is: 6
The total amount of all invoices in USD is: 424.57

****************************************************
****************************************************
```


