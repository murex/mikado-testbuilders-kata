
setlocal

set BUILD_DIR=build-dir
set BUILD_SYSTEM_DIR=%BUILD_DIR%\cmake-dl

if not exist %BUILD_DIR% (
    mkdir %BUILD_DIR%
)

if not exist %BUILD_SYSTEM_DIR% (
    mkdir %BUILD_SYSTEM_DIR%
)

.\vcpkg\vcpkg.exe install gtest

set CMAKE_VERSION=3.18.4
set CMAKE_ZIP_URL="http://github.com/Kitware/CMake/releases/download/v%CMAKE_VERSION%/cmake-%CMAKE_VERSION%-win64-x64.zip"
set CMAKE_EXPECTED_FOLDER=cmake-%CMAKE_VERSION%-win64-x64
set CMAKE_EXPECTED_ZIP_FILE=%CMAKE_EXPECTED_FOLDER%.zip


pushd %BUILD_SYSTEM_DIR%

if not exist %CMAKE_EXPECTED_ZIP_FILE% (
	powershell -command "Invoke-WebRequest %CMAKE_ZIP_URL% -OutFile %CMAKE_EXPECTED_ZIP_FILE%"
    powershell -command "Expand-Archive -Force '%~dp0\%BUILD_SYSTEM_DIR%\%CMAKE_EXPECTED_ZIP_FILE%' '%~dp0\%BUILD_SYSTEM_DIR%'"
	powershell -command "Rename-Item %CMAKE_EXPECTED_FOLDER% cmake-win-x64"
)

pushd ..
cmake-dl\cmake-win-x64\bin\cmake.exe -B . -S .. -DCMAKE_TOOLCHAIN_FILE=../vcpkg/scripts/buildsystems/vcpkg.cmake
cmake-dl\cmake-win-x64\bin\cmake.exe --build .
cmake-dl\cmake-win-x64\bin\ctest.exe -C Debug
popd

popd

