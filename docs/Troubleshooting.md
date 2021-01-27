# Troubleshooting

## I am getting C++ compilation errors

Here are 2 steps you might need to go follow to solve your problem: 

#### Step 1 - Github Actions

Under the Github repository, there are [workflow actions](https://github.com/murex/mikado-testbuilders-kata/actions) 
for the C++ project to ensure that the code is compilable.  

Proceed to the second step if the state of the C++ actions is Green. Otherwise, 
contact the project maintainers as this indicates a bug in the code.

#### Step 2 - C++ Compilers 

Most probably, the error you are getting is due to a difference between your and 
our C++ compilers (version, vendor, etc.)

Check the [CPP Build Manual](../cpp/BUILD_MANUAL.md) to learn more about the
tools and compiler versions we used in this project

## I cannot get the googltest dependency in Visual Studio

If you are behind a proxy, you might need to configure your NuGet proxy. Here
are some links that helped me:

* Stackoverflow ["NuGet behind a proxy"](https://stackoverflow.com/questions/9232160/nuget-behind-a-proxy)
* [NuGet config reference](https://docs.microsoft.com/en-us/nuget/reference/nuget-config-file)
* [NuGet proxy settings](http://skolima.blogspot.com/2012/07/nuget-proxy-settings.html)

(Alternatively, you can also connect without a proxy to download the 
dependency, it should continue to build when you get back behind the proxy)