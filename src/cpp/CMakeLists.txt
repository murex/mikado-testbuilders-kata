cmake_minimum_required (VERSION 3.12.0)
project (MikadoKata)

file (GLOB source_files lib/*.cpp)

include_directories(lib)

add_executable(
    ${PROJECT_NAME}
    bin/Application.cpp
    ${source_files}
)