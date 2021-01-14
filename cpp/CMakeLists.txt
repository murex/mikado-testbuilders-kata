cmake_minimum_required(VERSION 3.10.0)

set(PROJECT_NAME Mikado-TestBuilders-Workshop)

set(CMAKE_TOOLCHAIN_FILE ${CMAKE_CURRENT_SOURCE_DIR}/vcpkg/scripts/buildsystems/vcpkg.cmake
  CACHE STRING "Vcpkg toolchain file")

project(${PROJECT_NAME} CXX)

enable_testing()

set_property(GLOBAL PROPERTY USE_FOLDERS ON)

if (NOT TARGET gtest)
	# Download and unpack googletest at configure time
	configure_file(thirdparty.gtest.in.txt googletest-download/CMakeLists.txt)
	execute_process(COMMAND ${CMAKE_COMMAND} -G "${CMAKE_GENERATOR}" .
	  RESULT_VARIABLE result
	  WORKING_DIRECTORY ${CMAKE_CURRENT_BINARY_DIR}/googletest-download )
	if(result)
	  message(FATAL_ERROR "CMake step for googletest failed: ${result}")
	endif()
	execute_process(COMMAND ${CMAKE_COMMAND} --build .
	  RESULT_VARIABLE result
	  WORKING_DIRECTORY ${CMAKE_CURRENT_BINARY_DIR}/googletest-download )
	if(result)
	  message(FATAL_ERROR "Build step for googletest failed: ${result}")
	endif()

	# Prevent overriding the parent project's compiler/linker
	# settings on Windows
	set(gtest_force_shared_crt ON CACHE BOOL "" FORCE)

	# Add googletest directly to our build. This defines
	# the gtest and gtest_main targets.
	add_subdirectory(${CMAKE_CURRENT_BINARY_DIR}/googletest-src
					 ${CMAKE_CURRENT_BINARY_DIR}/googletest-build
					 EXCLUDE_FROM_ALL)

	# The gtest/gtest_main targets carry header search path
	# dependencies automatically when using CMake 2.8.11 or
	# later. Otherwise we have to add them here ourselves.
	if (CMAKE_VERSION VERSION_LESS 2.8.11)
	  include_directories("${gtest_SOURCE_DIR}/include")
	endif()

   set_property(TARGET gtest PROPERTY FOLDER "Thirdparties")
   set_property(TARGET gtest_main PROPERTY FOLDER "Thirdparties")
endif()

add_library(${PROJECT_NAME} STATIC)

target_compile_definitions(${PROJECT_NAME} PRIVATE MIKADO_TESTBUILDERS_WORKSHOP_EXPORTS)

target_sources(${PROJECT_NAME}
	PRIVATE
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
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/IdGenerator.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/client/BooksOrder.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/client/Client.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/client/Order.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/domain/book/Author.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/domain/book/Book.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/domain/book/Category.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/domain/book/EducationalBook.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/domain/book/Genre.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/domain/book/Novel.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/finance/CurrencyConverter.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/finance/TaxRule.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/purchase/PurchasedBook.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib/thirdparty/json.hpp
		
    PUBLIC
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/MainRepository.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/domain/country/Country.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/domain/country/Currency.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/domain/country/Language.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/purchase/Invoice.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/report/ReportGenerator.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/storage/Repository.h
		${CMAKE_CURRENT_SOURCE_DIR}/src/include/storage/JsonRepository.h
		
)

target_link_libraries(${PROJECT_NAME}
    PRIVATE
        gtest_main)

target_include_directories(${PROJECT_NAME}
	PRIVATE
		${CMAKE_CURRENT_SOURCE_DIR}/src/lib
    PUBLIC
        ${CMAKE_CURRENT_SOURCE_DIR}/src/include
)

add_executable(${PROJECT_NAME}-test)

target_sources(${PROJECT_NAME}-test
	PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}/tests/InMemoryRepository.cpp
        ${CMAKE_CURRENT_SOURCE_DIR}/tests/Tests.cpp		
		${CMAKE_CURRENT_SOURCE_DIR}/tests/storage/InMemoryRepository.h
        ${CMAKE_CURRENT_SOURCE_DIR}/thirdparty.gtest.in.txt
)

target_include_directories(${PROJECT_NAME}-test
    PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}/tests
)

target_link_libraries(${PROJECT_NAME}-test
    PRIVATE
	    ${PROJECT_NAME}
        gtest_main)
		
add_test(NAME ctest-${PROJECT_NAME} COMMAND ${PROJECT_NAME}-test)

set_property(DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR} PROPERTY VS_STARTUP_PROJECT ${PROJECT_NAME}-test)
set_property(TARGET ${PROJECT_NAME} PROPERTY FOLDER "Workshop")
set_property(TARGET ${PROJECT_NAME}-test PROPERTY FOLDER "Workshop")

set_property(GLOBAL PROPERTY PREDEFINED_TARGETS_FOLDER "CMake Generated")