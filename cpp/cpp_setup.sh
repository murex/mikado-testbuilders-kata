#!/usr/bin/env sh

case $(uname -s) in
Darwin)
    os="Darwin"
    arch="x86_64"
    archive_extension="tar.gz"
    cmake_bin_dir="CMake.app/Contents/bin"
    cmake="cmake"
    ctest="ctest"
    cmake_generator_options="-G Xcode -DCMAKE_TOOLCHAIN_FILE=../vcpkg/scripts/buildsystems/vcpkg.cmake"
    ;;
Linux)
    os="Linux"
    arch="x86_64"
    archive_extension="tar.gz"
    cmake_bin_dir="bin"
    cmake="cmake"
    ctest="ctest"
    cmake_generator_options="-G \"Unix Makefiles\" -DCMAKE_TOOLCHAIN_FILE=../vcpkg/scripts/buildsystems/vcpkg.cmake"
    ;;
MINGW64_NT-*)
    os="win64"
    arch="x64"
    archive_extension="zip"
    cmake_bin_dir="bin"
    cmake="cmake.exe"
    ctest="ctest.exe"
    cmake_generator_options="-G \"Visual Studio 15 2017 Win64\" -DCMAKE_TOOLCHAIN_FILE=../vcpkg/scripts/buildsystems/vcpkg.cmake"
    ;;
*)
    echo "os $(uname -s) is currently not supported."
    exit
    ;;
esac

start_dir=$(pwd)
base_dir=$(dirname -- "$0")
git_repo_root_dir=$(git rev-parse --show-toplevel)

cd "${git_repo_root_dir}" || exit
echo '*** Initializing the submodules ***'
git submodule init
echo '*** Updating the submodules ***'
git submodule update

cd "${start_dir}" || exit
cd "${base_dir}" || exit

echo '*** Running vcpkg bootstrap ***'
./vcpkg/bootstrap-vcpkg.sh
echo '*** Installing GTest using vcpkg ***'
./vcpkg/vcpkg install gtest

cmake_version="3.18.4"
cmake_expected_dir="cmake-${cmake_version}-${os}-${arch}"
cmake_expected_archive_file="${cmake_expected_dir}.${archive_extension}"
cmake_archive_url="http://github.com/Kitware/CMake/releases/download/v${cmake_version}/${cmake_expected_archive_file}"
cmake_home="cmake-${os}-${arch}"

build_dir="build"
mkdir -p "${build_dir}"
cd "${build_dir}" || exit

cmake_build_dir="cmake"
mkdir -p "${cmake_build_dir}"
cd "${cmake_build_dir}" || exit


if ! [ -f "${cmake_expected_archive_file}" ]
then
	curl -# -L "${cmake_archive_url}" -o "${cmake_expected_archive_file}"

  case "${archive_extension}" in
  zip)
    unzip -q -o "${cmake_expected_archive_file}"
    ;;
  tar.gz)
    tar zxf "${cmake_expected_archive_file}"
    ;;
  *)
    echo "Archive format ${archive_extension} is currently not supported."
    exit
    ;;
  esac

  [ -d "${cmake_home}" ] && rm -Rf "${cmake_home}"
	mv "${cmake_expected_dir}" "${cmake_home}"
fi

cd ..

cmake_bin_path="${cmake_build_dir}/${cmake_home}/${cmake_bin_dir}"

[ -n "${cmake_generator_options}" ] && eval ${cmake_bin_path}/${cmake} "${cmake_generator_options}" -S .. -B .
${cmake_bin_path}/${cmake} --build . --config Debug
${cmake_bin_path}/${ctest} -C Debug
