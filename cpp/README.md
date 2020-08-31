# C++

## Build with CMake

```bash
mkdir build
conan install -s build_type=Debug -if build .
cmake -DCMAKE_TOOLCHAIN_FILE=build/conan_paths.cmake -B build .
cmake --build build
```
