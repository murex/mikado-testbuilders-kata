#!/usr/bin/env sh

BUILD_DIR=build-dir
BUILD_SYSTEM_DIR=${BUILD_DIR}/cmake-dl

mkdir -p ${BUILD_DIR}
mkdir -p ${BUILD_SYSTEM_DIR}

echo '*** Initializing the submodules ***'
git submodule init
echo '*** Updating the submodules ***'
git submodule update

echo '*** Running vcpkg bootstrap ***'
./vcpkg/bootstrap-vcpkg.sh
echo '*** Installing GTest using vcpkg ***'
./vcpkg/vcpkg.sh install gtest 


CMAKE_VERSION=3.18.4
CMAKE_ZIP_URL="http://github.com/Kitware/CMake/releases/download/v${CMAKE_VERSION}/cmake-${CMAKE_VERSION}-Darwin-x86_64.tar.gz"
CMAKE_EXPECTED_FOLDER=cmake-${CMAKE_VERSION}-Darwin-x86_64
CMAKE_EXPECTED_ZIP_FILE=${CMAKE_EXPECTED_FOLDER}.tar.gz


cd ${BUILD_SYSTEM_DIR} || exit

if ! [ -f "${CMAKE_EXPECTED_ZIP_FILE}" ]
then
	curl -# -L ${CMAKE_ZIP_URL} -o ${CMAKE_EXPECTED_ZIP_FILE}
  tar zxf ${CMAKE_EXPECTED_ZIP_FILE}
	mv ${CMAKE_EXPECTED_FOLDER} cmake-Darwin-x86_64
fi

cd ..

CMAKE_BIN_DIR=cmake-dl/cmake-Darwin-x86_64/CMake.app/Contents/bin
${CMAKE_BIN_DIR}/cmake -G Xcode -S .. -B . -DCMAKE_TOOLCHAIN_FILE=../vcpkg/scripts/buildsystems/vcpkg.cmake
${CMAKE_BIN_DIR}/cmake --build . --config Debug
${CMAKE_BIN_DIR}/ctest -C Debug

