module Application.Purchase

open Application.Domain
    
type PurchasedBook = { 
    Book: BookType
    Quantity: int
}

type Invoice = {
    Id: int
    ClientName: string
    Country: Country
    PurchasedBooks: seq<PurchasedBook>
}

type TotalAmount = Invoice -> Price

let totalAmount (invoice:Invoice) =
    let bookPrice bookType =
        match bookType with
        | Novel (book, _) -> book.Price
        | EducationalBook (book, _) -> book.Price

    invoice.PurchasedBooks
    // BUG
    //|> Seq.map (fun purchasedBook -> bookPrice purchasedBook.Book * float purchasedBook.Quantity)

    // FIX
    |> Seq.map (fun purchasedBook -> 
        bookPrice purchasedBook.Book * float purchasedBook.Quantity * (Finance.applicableRate invoice.Country purchasedBook.Book))
    |> Seq.sum
