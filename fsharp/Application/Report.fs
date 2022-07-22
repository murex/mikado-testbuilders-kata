module Application.Report
    
open Application
open Application.Domain

type TotalSoldBooks = Purchase.Invoice seq -> int
type NumberOfIssuedInvoices = Purchase.Invoice seq -> int
type TotalAmountInUsd = Purchase.Invoice seq -> Price

type PrintReport = TotalSoldBooks -> NumberOfIssuedInvoices -> TotalAmountInUsd -> unit
    
let totalSoldBooks (invoices: Purchase.Invoice seq) =
    invoices 
    |> Seq.collect (fun invoice -> invoice.PurchasedBooks) 
    |> Seq.map (fun purchasedBook -> purchasedBook.Quantity)
    |> Seq.sum

let numberOfIssuedInvoices invoices =
    invoices
    |> Seq.length

let totalAmountInUsd (invoices: Purchase.Invoice seq) =
    invoices 
    // BUG
    //|> Seq.map (fun invoice -> Purchase.totalAmount invoice)
    // FIX
    |> Seq.map (fun invoice -> (Purchase.totalAmount invoice) |> Finance.toUsd invoice.Country.Currency)
    |> Seq.sum
