# CPP Build Manual

## Tools 

For C++, we are using the tools below to build the project: 
1. [CMake](https://cmake.org/)
1. [vcpkg](https://github.com/microsoft/vcpkg) 
1. [VisualStudio](https://visualstudio.microsoft.com/) 
 
## Process 
To make the build process easier, we built a script that wraps all the required compilation steps. 

The script performs the following: 
1. Create a new directory (build_dir)
1. Initialize and update the vcpkg git submodule
1. Bootstrap vcpkg
1. Install [gtest](https://github.com/google/googletest) using vcpkg
1. Download CMake as a sub-folder
1. Run CMake to build the project

C++ requires us to generate the binary and Dlls files separately for each platform. 
Therefore, we created several versions of the script: 

1. **Windows**: [cpp_setup_win.bat](./cpp_setup_win.bat)
1. **Mac**: [cpp_setup_mac.sh](./cpp_setup_mac.sh)

## Successful build

To ensure that the build was executed successfully, you need to verify the below folders:
1. [build-dir](./build-dir): This folder includes all the files outputted from the 
   CMake command. 
   1. **For Windows**: Use the solution file [Mikado-TestBuilders-Workshop](./build-dir/Mikado-TestBuilders-Workshop.sln) 
   to open the project in Visual Studio.   
1. [vcpkg](./vcpkg): In addition to downloading the vcpkg submodule from github, 
   you should find the vcpkg executable file ([windows](./vcpkg/vcpkg.exe), [mac](./vcpkg/vcpkg.sh)) 
   created as a result of bootstrapping vcpkg.