cmake_minimum_required (VERSION 3.12.0)
project (MikadoKata)

file (GLOB source_files lib/*.cpp)

add_subdirectory(lib)

add_executable(
    ${PROJECT_NAME}
    bin/Application.cpp
)

target_link_libraries(${PROJECT_NAME} Client Domain Finance Purchase Report Storage MainRepository IdGenerator)