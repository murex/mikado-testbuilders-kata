// For more information see https://aka.ms/fsharp-console-apps
open Application.Report

let printReport (totalSoldBooks:TotalSoldBooks) (numberOfIssuedInvoices:NumberOfIssuedInvoices) (totalAmountInUsd:TotalAmountInUsd) = 
        printfn "****************************************************"
        printfn "*****************Application Report*****************"
        printfn "****************************************************"
        printfn ""
        printfn $"The total number of books sold is: {totalSoldBooks}"
        printfn $"The total number of issued invoices is: {numberOfIssuedInvoices}"
        printfn $"The total amount of all invoices in USD is: {totalAmountInUsd}"
        printfn ""
        printfn "****************************************************"
        printfn "****************************************************"
