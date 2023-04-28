cmake_minimum_required(VERSION 3.10.0)

set(PROJECT_NAME Mikado-TestBuilders-Workshop)

set(CMAKE_CXX_STANDARD 17)

project(${PROJECT_NAME} CXX)

enable_testing()

set_property(GLOBAL PROPERTY USE_FOLDERS ON)

set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib CACHE PATH "Where to place compiled static libraries.")
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib CACHE PATH "Where to place compiled shared libraries.")
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin CACHE PATH "Where to place compiled executables.")


include(cmake/CPM.cmake)
include(cmake/FindGoogleTest.cmake)

# Library

add_library(${PROJECT_NAME} STATIC)

target_compile_definitions(${PROJECT_NAME} PRIVATE MIKADO_TESTBUILDERS_WORKSHOP_EXPORTS)

set(PRIVATE_LIBRARY_SOURCES
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/Author.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/Book.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/BooksOrder.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/Client.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/Country.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/CurrencyConverter.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/EducationalBook.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/IdGenerator.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/Invoice.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/JsonRepository.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/MainRepository.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/Novel.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/Order.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/PurchasedBook.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/ReportGenerator.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/Repository.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/TaxRule.cpp
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/thirdparty/json.hpp
)

set(PUBLIC_LIBRARY_SOURCES
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/MainRepository.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/domain/country/Country.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/domain/country/Currency.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/domain/country/Language.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/purchase/Invoice.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/report/ReportGenerator.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/storage/Repository.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/storage/JsonRepository.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/IdGenerator.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/client/BooksOrder.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/client/Client.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/client/Order.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/domain/book/Author.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/domain/book/Book.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/domain/book/Category.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/domain/book/EducationalBook.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/domain/book/Genre.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/domain/book/Novel.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/finance/CurrencyConverter.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/finance/TaxRule.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/purchase/PurchasedBook.h
)

set(DOCS_SOURCES
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/1_Introduction.md
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/2_Easy_Fix_Difficult_Test.md
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/3_Building_Test_Data.md
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/4_Mikado_Method.md
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/5_Mikado_Method_plus_Test_Data_Builders.md
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/6_Conclusion.md
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/Facilitation_Guide.md
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/Retrospectives_Guide.md
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/references/References.md
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/references/Test_Data_Builders.md
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/references/The_Mikado_Method.md	
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/facilitation/2h.md
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/facilitation/2h30.md	
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/facilitation/CoLocalized.md	
        ${CMAKE_CURRENT_SOURCE_DIR}/../docs/facilitation/Remote.md	
        ${CMAKE_CURRENT_SOURCE_DIR}/../README.md
)

target_compile_definitions(${PROJECT_NAME} 
	PRIVATE 
		DEFAULT_JSON_PATH="${CMAKE_CURRENT_SOURCE_DIR}/src/resources/repository.json"
)

target_sources(${PROJECT_NAME}
	PRIVATE
		${PRIVATE_LIBRARY_SOURCES}
		${DOCS_SOURCES}
		${CMAKE_CURRENT_SOURCE_DIR}/BUILD_MANUAL.md
    PUBLIC
		${PUBLIC_LIBRARY_SOURCES}
)

target_include_directories(${PROJECT_NAME}
	PRIVATE
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib
    PUBLIC
        ${CMAKE_CURRENT_SOURCE_DIR}/src/include
)

source_group(TREE ${CMAKE_CURRENT_SOURCE_DIR}/src/lib PREFIX private FILES ${PRIVATE_LIBRARY_SOURCES})
source_group(TREE ${CMAKE_CURRENT_SOURCE_DIR}/src/include PREFIX public FILES ${PUBLIC_LIBRARY_SOURCES})
source_group(TREE ${CMAKE_CURRENT_SOURCE_DIR}/.. PREFIX docs FILES ${DOCS_SOURCES})
source_group(TREE ${CMAKE_CURRENT_SOURCE_DIR}/ PREFIX docs FILES ${CMAKE_CURRENT_SOURCE_DIR}/BUILD_MANUAL.md)

# Console Executable

add_executable(${PROJECT_NAME}-app) 

set(APP_SOURCES
	${CMAKE_CURRENT_SOURCE_DIR}/app/Application.cpp
)

target_sources(${PROJECT_NAME}-app 
	PRIVATE 
		${APP_SOURCES}
)

target_link_libraries(${PROJECT_NAME}-app
    PRIVATE
	    ${PROJECT_NAME}
)

# Test Executable

add_executable(${PROJECT_NAME}-test)

set(TEST_SOURCES
        ${CMAKE_CURRENT_SOURCE_DIR}/tests/InMemoryRepository.cpp
        ${CMAKE_CURRENT_SOURCE_DIR}/tests/Tests.cpp		
		${CMAKE_CURRENT_SOURCE_DIR}/tests/storage/InMemoryRepository.h
)

target_sources(${PROJECT_NAME}-test
	PRIVATE
		${TEST_SOURCES}
)

target_include_directories(${PROJECT_NAME}-test
    PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}/tests
)

source_group(TREE ${CMAKE_CURRENT_SOURCE_DIR}/tests PREFIX tests FILES ${TEST_SOURCES})

target_link_libraries(${PROJECT_NAME}-test
    PRIVATE
	    ${PROJECT_NAME}
        gtest_main)
		
add_test(NAME ctest-${PROJECT_NAME} COMMAND ${PROJECT_NAME}-test)

set_property(DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR} PROPERTY VS_STARTUP_PROJECT ${PROJECT_NAME}-test)
set_property(DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR} PROPERTY XCODE_STARTUP_PROJECT ${PROJECT_NAME}-test)

set_property(TARGET ${PROJECT_NAME} PROPERTY FOLDER "Workshop")
set_property(TARGET ${PROJECT_NAME}-test PROPERTY FOLDER "Workshop")
set_property(TARGET ${PROJECT_NAME}-app PROPERTY FOLDER "Workshop")

set_property(TARGET gtest gtest_main PROPERTY FOLDER "Third-Party/GoogleTest")

set_property(GLOBAL PROPERTY PREDEFINED_TARGETS_FOLDER "CMake Generated")
