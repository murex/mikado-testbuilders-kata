module Application.Test.ReportTests

open Xunit

[<Fact>]
let ``No Constraint Converts total amount to usd``() =
    // Instantiate a ReportGenerator
    // It needs to use a data source that contains one invoice in a non-USD currency
    // Assert that the amount returned by ReportGenerator is converted to USD currency
    //
    // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
    // Don't forget to reset the data source at the end of your test!
    ()

[<Fact>]
let ``Test Data Builders Constraint Converts total amount to usd``() =
    // Using the Test Data Builder pattern:
    // Instantiate a ReportGenerator
    // It needs to use a data source that contains one invoice in a non-USD currency
    // Assert that the amount returned by ReportGenerator is converted to USD currency
    //
    // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
    // Don't forget to reset the data source at the end of your test!
    ()

[<Fact>]
let ``Mikado Method Constraint Converts total amount to usd``() =
    // Using the Mikado method:
    // Instantiate a ReportGenerator
    // It needs to use a data source that contains one invoice in a non-USD currency
    // Assert that the amount returned by ReportGenerator is converted to USD currency
    //
    // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
    // Don't forget to reset the data source at the end of your test!
    ()

[<Fact>]
let ``Mikado Method And Test Data Builders Constraint Converts total amount to usd``() =
    // Using the Mikado method and the Test Data Builder pattern:
    // Instantiate a ReportGenerator
    // It needs to use a data source that contains one invoice in a non-USD currency
    // Assert that the amount returned by ReportGenerator is converted to USD currency
    //
    // Regarding the data source, take a look at MainRepository: it'll allow you to plug a test data source to ReportGenerator
    // Don't forget to reset the data source at the end of your test!
    ()
