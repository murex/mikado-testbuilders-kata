# CPP Build Manual

## Prerequisites 

### Build Tools 

[CMake](https://cmake.org/) is our main build tool for the C++ version of this Kata. 
In addition to CMake, we are using [vcpkg](https://github.com/microsoft/vcpkg) to avoid compiling our third-party libraries.  

Don't worry if you don't have those tools installed as we provided you with a script that handles compiling and building the project. 
 
### Required Versions 

#### C++ 

By default, our CMake file is referencing C++ version 17. We also tested and 
compiled the code with versions 11 and 14. 

To use a version other than 17, simply modify the below line in the [CMake](./CMakeLists.txt)
file to reference 11 or 14.  

```shell
set(CMAKE_CXX_STANDARD 17)
```

#### CMake
	1. Minimum required: 3.10.0
	1. Used: 3.18.4

### IDEs 
1. [Microsoft Visual Studio](https://visualstudio.microsoft.com/): On Windows, the script will generate a solution file 
   (SLN) for Microsoft Visual Studio
1. [Xcode](https://developer.apple.com/xcode/): On Mac, the script will generate  for Xcode.
1. [Visual Studio Code](https://code.visualstudio.com/): 

## Process 

> ***Reminder***:  You need to run the commands below from the [cpp](.) folder!

### CMake Build Command 

If you already have CMake installed on your machine, then you can simply run the below CMake command to generate the solution files:

```shell

```

### Setup Script 

As mentioned earlier, we prepared a script to help compile and build the project. 

```shell
# Windows
./cpp_setup_win.bat

# Mac & Linux 
./cpp_setup.sh
```

If executed successfully, the last 3 lines of the output should be: 

```shell
Start 1: ctest-Mikado-TestBuilders-Workshop
1/1 Test #1: ctest-Mikado-TestBuilders-Workshop ...   Passed    0.00 sec

100% tests passed, 0 tests failed out of 1
```

In addition to the above, the following folders and files should be generated:
1. A [build-dir](./build-dir) folder that includes the files outputted from running CMake.
1. For *Windows*: The **'Visual Studio 2017'** solution file [Mikado-TestBuilders-Workshop.sln](./build-dir/Mikado-TestBuilders-Workshop.sln)
1. For *Mac*: The **'Xcode'** project file [Mikado-TestBuilders-Workshop.xcodeproj](./build-dir/Mikado-TestBuilders-Workshop.xcodeproj)
1. For *Linux*: Two executable files [Mikado-TestBuilders-Workshop-app](./build-dir/Mikado-TestBuilders-Workshop-app) and [Mikado-TestBuilders-Workshop-test](./build-dir/Mikado-TestBuilders-Workshop-test)

#### Script Steps 
The script performs the following actions: 
1. Create a new directory [build-dir](./build-dir)
1. Initialize and update the vcpkg git submodule
1. Bootstrap vcpkg
1. Install [gtest](https://github.com/google/googletest) using vcpkg
1. Download CMake as a sub-folder
1. Run CMake to build the project

### Run Command

To try out the application, run the command:

```shell
# Windows
build-dir\Debug\Mikado-TestBuilders-Workshop-app.exe

# Mac
./build-dir/Debug/Mikado-TestBuilders-Workshop-app

# Linux 
./build-dir/Mikado-TestBuilders-Workshop-app
```

The following output should be generated:

```shell
****************************************************
*****************Application Report*****************
****************************************************

The total number of books sold is: 16
The total number of issued invoices is: 6
The total amount of all invoices in USD is: 1016.04

****************************************************
****************************************************
```
