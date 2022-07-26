module Application.Tests.Purchase.InvoiceTests

open Xunit

[<Fact>]
let ``No Constraint Applies tax rules when computing total amount``() =
    // Instantiate an Invoice sent to USA
    // Add it a purchased novel costing 50
    // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    ()

[<Fact>]
let ``Test Data Builders Constraint Applies tax rules when computing total amount``() =
    // Using the Test Data Builder pattern:
    // Instantiate an Invoice sent to USA
    // Add it a purchased novel costing 50
    // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    ()

[<Fact>]
let ``Mikado Method Constraint Applies tax rules when computing total amount``() =
    // Using the Mikado method:
    // Instantiate an Invoice sent to USA
    // Add it a purchased novel costing 50
    // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    ()

[<Fact>]
let ``Mikado Method And Test Data Builders Constraint Applies tax rules when computing total amount``() =
    // Using the Mikado method and the Test Data Builder pattern:
    // Instantiate an Invoice sent to USA
    // Add it a purchased novel costing 50
    // Assert the total amount of the invoice is 56,35 : 15% of taxes plus a 2% reduction on novels
    ()