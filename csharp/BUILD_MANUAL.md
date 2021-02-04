# C# Build Manual

## Prerequisites

### .NET Core version
We're using [.NET Core 3.1](https://dotnet.microsoft.com/download/dotnet-core) and the [dotnet CLI](https://docs.microsoft.com/fr-fr/dotnet/core/tools/#cli-commands).

### IDEs
We're using [Rider](https://www.jetbrains.com/rider/), but you can choose any IDE that
supports building .NET Core!  
 
## Build and Run 

The process is very easy using the `dotnet CLI`.

From the [`chsarp`](.) directory, run:
```shell
> cd Application
> dotnet run 
```

This should restore the required NuGet packages, compile and run the App.

The following output should be generated: 
```shell
****************************************************
*****************Application Report*****************
****************************************************

The total number of books sold is: 16
The total number of issued invoices is: 6
The total amount of all invoices in USD is: 424,57

****************************************************
****************************************************
```