open Application

let invoices = Dto.InvoiceProvider.Load("Storage/repository.json")

let printReport invoices = 
        printfn "****************************************************"
        printfn "*****************Application Report*****************"
        printfn "****************************************************"
        printfn ""
        printfn $"The total number of books sold is: {Report.totalSoldBooks invoices}"
        printfn $"The total number of issued invoices is: {Report.numberOfIssuedInvoices invoices}"
        printfn $"The total amount of all invoices in USD is: {Report.totalAmountInUsd invoices}"
        printfn ""
        printfn "****************************************************"
        printfn "****************************************************"

invoices 
|> Array.map Dto.Invoice.toDomain 
|> printReport 
 