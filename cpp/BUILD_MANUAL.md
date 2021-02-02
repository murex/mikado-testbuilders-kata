# CPP Build Manual

The purpose of  this manual is to provide you with some information on how to compile, build, and run the C++ version of the Kata. 

## Prerequisites 

### Build Tools 

[CMake](https://cmake.org/) is our main build tool for the C++ version of this Kata.

Don't worry if you don't have CMake installed! 
We provided you with a setup script that handles compiling and building the project. 
 
### Required Versions 

#### C++ 

By default, our CMake file is referencing C++ version 17. But, we also tested and 
compiled the code with versions 11 and 14. 

To use a version other than 17, simply modify the below line in the [CMake](./CMakeLists.txt)
file to reference 11 or 14.  

```shell
set(CMAKE_CXX_STANDARD 17)
```

#### CMake
The minimum required version of CMake is "***3.10.0***". 

However, in our setup script, we are using the version "***3.19.3***"

#### Compilers 

When running on Windows, the code is compiled with [MSVC](https://docs.microsoft.com/en-us/cpp/build/reference/compiling-a-c-cpp-program?view=msvc-160). 

On other platforms, the script will be using the default C++ compiler set on the machine. 
For that, we have tested the with GCC and Clang

### IDEs 
We have successfully tested loading, compiling and running this kata on the below 3 IDEs: 
1. [Microsoft Visual Studio](https://visualstudio.microsoft.com/)
1. [Xcode](https://developer.apple.com/xcode/)
1. [Visual Studio Code](https://code.visualstudio.com/)

***Note:*** 

1. When executed on Windows and Mac, our script will, by default, generate the solution files ***Mikado-TestBuilders-Workshop.sln*** for **'Visual Studio 2017'** & ***Mikado-TestBuilders-Workshop.xxcodeproj*** for **'Xcode'** respectively. 
1. The script doesn't generate the VSCode Workspace files. However, loading and running the project into VSCode is straight forward. You can check the tutorial '[Getting started with CMake Tools on Linux](https://code.visualstudio.com/docs/cpp/cmake-linux#:~:text=ready%20to%20build.-,Open%20the%20Command%20Palette%20(Ctrl%2BShift%2BP)%20and,CMake%20Tools%20builds%20all%20targets.)' for reference. 

## Process 

> ***Reminder***:  You need to run the commands below from the [cpp](.) folder!

### Manual Build  

If you already have CMake installed on your machine, you can simply run one of the below commands to build the project. 

```shell
# For Visual Studio 2017 
> cmake -G "Visual Studio 15 2017 Win64" -S . -B build

# For XCode  
> cmake -G "XCode" -S . -B build

# For Linux (Visual Studio Code)
> cmake -G "Unix Makefiles" -S . -B build
```

### Setup Script 

As mentioned earlier, we prepared a setup script to assist you in compiling and building the project. 

You can run the script using the below commands: 

```shell
# Windows
> ./cpp_setup_win.bat

# Mac & Linux 
> ./cpp_setup.sh
```

If executed successfully, the last 3 lines of the output should be the following: 

```shell
Start 1: ctest-Mikado-TestBuilders-Workshop
1/1 Test #1: ctest-Mikado-TestBuilders-Workshop ...   Passed    0.00 sec

100% tests passed, 0 tests failed out of 1
```

### Expected Folder Structure

After running any of the above steps, the following folders and files should be generated:
1. A [build](./build) folder that includes the files outputted from running CMake.
1. For *Windows*: The **'Visual Studio 2017'** solution file [Mikado-TestBuilders-Workshop.sln](./build/Mikado-TestBuilders-Workshop.sln)
1. For *Mac*: The **'Xcode'** project file [Mikado-TestBuilders-Workshop.xcodeproj](./build/Mikado-TestBuilders-Workshop.xcodeproj)

### Run Command

To try out the application, you can either use the IDE or the command line:

#### Command Line

```shell
# Windows
> build\Debug\Mikado-TestBuilders-Workshop-app.exe

# Mac
> ./build/Debug/Mikado-TestBuilders-Workshop-app

# Linux 
> ./build/Mikado-TestBuilders-Workshop-app
```

#### IDE 

The CMake file we provided generates the target 'Mikado-TestBuilders-Workshop-app' 
which in turn runs the main class [Application.cpp](./app/Application.cpp). 

After loading the project into your IDE, set the 'Mikado-TestBuilders-Workshop-app' 
as the StartUp Project then run the project. 

#### Output 

The following output should be generated in both cases:

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
