# CPP Build Manual

## Prerequisites 

### Build Tools 

[CMake](https://cmake.org/) is our main build tool for the C++ version of this Kata. 
In addition to CMake, we are using [vcpkg](https://github.com/microsoft/vcpkg) to avoid compiling our third-party libraries.  

Don't worry if you don't have those tools installed! We provided you with a setup script that handles compiling and building the project. 
 
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
	1. Minimum required: 3.10.0
	1. Used: 3.18.4

### IDEs 
We have tested this kata on the below 3 IDEs: 
1. [Microsoft Visual Studio](https://visualstudio.microsoft.com/): On Windows, our setup script generates a solution file 
   (SLN) for Microsoft Visual Studio.
1. [Xcode](https://developer.apple.com/xcode/): On Mac, our setup script generates an "xcodeproj" file for Xcode.
1. [Visual Studio Code](https://code.visualstudio.com/): Our script doesn't generate the VSCode Workspace files. However, loading and running the project into VSCode is straight forward. You can check the tutorial '[Getting started with CMake Tools on Linux](https://code.visualstudio.com/docs/cpp/cmake-linux#:~:text=ready%20to%20build.-,Open%20the%20Command%20Palette%20(Ctrl%2BShift%2BP)%20and,CMake%20Tools%20builds%20all%20targets.)' for reference. 

## Process 

> ***Reminder***:  You need to run the commands below from the [cpp](.) folder!

### Setup Script 

As mentioned earlier, we prepared a setup script to assist you in compiling and building the project. 

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
1. A [build](./build) folder that includes the files outputted from running CMake.
1. A [vcpkg](./vcpkg) folder that includes the files cloned from the vcpkg repository. 
1. For *Windows*: The **'Visual Studio 2017'** solution file [Mikado-TestBuilders-Workshop.sln](./build/Mikado-TestBuilders-Workshop.sln)
1. For *Mac*: The **'Xcode'** project file [Mikado-TestBuilders-Workshop.xcodeproj](./build/Mikado-TestBuilders-Workshop.xcodeproj)
1. For *Linux*: Two executable files [Mikado-TestBuilders-Workshop-app](./build/Mikado-TestBuilders-Workshop-app) and [Mikado-TestBuilders-Workshop-test](./build/Mikado-TestBuilders-Workshop-test)

#### Script Detailed Steps 

<details>
	<summary markdown='span'>
	Actions performed by the script
	</summary>

	1. Create a new directory "build"
	1. Initialize and update the vcpkg git submodule
	1. Bootstrap vcpkg
	1. Install "gtest" using vcpkg
	1. Download CMake as a sub-folder
	1. Run CMake to build the project.
</details>

### Run Command

To try out the application, run the command:

```shell
# Windows
build\Debug\Mikado-TestBuilders-Workshop-app.exe

# Mac
./build/Debug/Mikado-TestBuilders-Workshop-app

# Linux 
./build/Mikado-TestBuilders-Workshop-app
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
