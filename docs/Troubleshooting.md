# Troubleshooting

## I am getting compilation errors (C++ or Java)

You are getting compilation errors, although you didn't change any code!  
Here are 2 steps you might need to follow to solve your problem: 

#### Step 1 - Github Actions

Under the Github repository, there are [workflow actions](https://github.com/murex/mikado-testbuilders-kata/actions) 
for the C++ and Java projects to ensure that the code is compilable.  

Check the status of the action corresponding to your preferred programming language. 
Proceed to the second step if that state is Green. Otherwise, contact the project 
maintainers as this indicates a bug in the code.

#### Step 2 - C++ Compilers 

The error might be linked to a missing build-tool or a difference in compiler versions.

Check the "***Build Manuals***" associated with your preferred language to learn
more about the build-tools and compiler versions we are using.
1. [CPP Build Manual](../cpp/BUILD_MANUAL.md)
1. [JAVA Build Manual](../java/BUILD_MANUAL.md)

## I cannot get the googltest dependency in Visual Studio

If you are behind a proxy, you might need to configure your NuGet proxy. Here
are some links that helped me:

* Stackoverflow ["NuGet behind a proxy"](https://stackoverflow.com/questions/9232160/nuget-behind-a-proxy)
* [NuGet config reference](https://docs.microsoft.com/en-us/nuget/reference/nuget-config-file)
* [NuGet proxy settings](http://skolima.blogspot.com/2012/07/nuget-proxy-settings.html)

(Alternatively, you can also connect without a proxy to download the 
dependency, it should continue to build when you get back behind the proxy)