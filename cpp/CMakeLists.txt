cmake_minimum_required (VERSION 3.12.0)
project (MikadoKata)

include(GoogleTest)
enable_testing()


file(GLOB source_files lib/*.cpp)

add_subdirectory(lib)

add_executable(${PROJECT_NAME} bin/Application.cpp)
target_link_libraries(${PROJECT_NAME} Client Domain Finance Purchase Report Storage MainRepository IdGenerator)

find_package(GTest REQUIRED)

set(TEST_NAME "${PROJECT_NAME}Test")
add_executable("${TEST_NAME}" test/Tests.cpp)
target_link_libraries("${TEST_NAME}" GTest::GTest Report)
gtest_discover_tests("${TEST_NAME}")
