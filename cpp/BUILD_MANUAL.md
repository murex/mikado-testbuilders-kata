# CPP Build Manual

## Prerequisites 

### Build Tools 

[CMake](https://cmake.org/) is our main build tool for the C++ version of this Kata. 
In addition to CMake, we are using [vcpkg](https://github.com/microsoft/vcpkg) to avoid compiling our third-party libraries.  

Don't worry if you don't have those tools installed as we provided you with a script that handles compiling and building the project. 
 
### Required Versions 

1. CMake 
	1. Minimum required: 3.10.0
	1. Used: 3.18.4

### IDEs 
1. [Microsoft Visual Studio](https://visualstudio.microsoft.com/): Our build script will generate a solution file (SLN) for Microsoft Visual Studio
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
1. A [build-dir](./build-dir) folder that includes the files outputted from running CMake
1. For *Windows*: A [Mikado-TestBuilders-Workshop](./build-dir/Mikado-TestBuilders-Workshop.sln) solution file that can be used to open the project with Microsot Visual Studio
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

# Mac & Linux 
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
