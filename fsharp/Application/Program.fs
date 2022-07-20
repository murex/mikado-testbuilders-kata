// For more information see https://aka.ms/fsharp-console-apps
open Application.Report
open Application.Purchase
open Application.Domain

//#r "nuget: FSharp.Data"
open FSharp.Data

type JsonBook = JsonProvider<"Storage/repository.json">

let jsonBooks = JsonBook.Load("Storage/repository.json")

let mapCountryName country = 
    match country with
    | "USA" -> USA
    | "France" -> France
    | "Spain" -> Spain
    | "UK" -> UK
    | "Germany" -> Germany
    | "China" -> China
    | "Japan" -> Japan
    | "Australia" | _ -> Australia

let mapCurrency currency =
    match currency with
    | "US_DOLLAR" -> UsDollar
    | "RENMINBI" -> Reminbi
    | "EURO" -> Euro
    | "POUND_STERLING" | _ -> PoundSterling

let mapLanguage language =
    match language with
    | "ENGLISH" -> English
    | "MANDARIN" -> Mandarin
    | "SPANISH" -> Spanish
    | "GERMAN" | _ -> German

let mapCategory category =
    match category with
    | "LANGUAGE" -> Language
    | "COMPUTER" -> Computer
    | "BUSINESS" | _ -> Business

let mapGenre genre =
    match genre with
    | "MYSTERY" -> Mystery
    | "ADVENTURE_FICTION" -> AdventureFiction
    | "DARK_FANTASY" -> DarkFantasy
    | "ROMANCE" | _ -> Romance

let mapBookInBasket (bookInBasket:JsonBook.BooksInBasket) =
    let book = {
        Name = bookInBasket.Name
        Price = float bookInBasket.Price
        Author = { 
            Name = bookInBasket.Author.Name
            Nationality = {
                Name = mapCountryName bookInBasket.Author.Nationality.Name
                Currency = mapCurrency bookInBasket.Author.Nationality.Currency
                Language = mapLanguage bookInBasket.Author.Nationality.Language
            }
        }
        Language = mapLanguage bookInBasket.Language
    }
    match bookInBasket.Category, bookInBasket.Genre with
    | Some category, _ -> EducationalBook (book, mapCategory category)
    | None , genres -> Novel (book, genres |> Array.map (fun genre -> mapGenre genre))
        

let invoices = jsonBooks |> Array.map (fun invoice -> {
    Id = invoice.Id
    ClientName = invoice.Client
    Country = {
        Name = mapCountryName invoice.Country.Name
        Currency = mapCurrency invoice.Country.Currency
        Language = mapLanguage invoice.Country.Language
    }
    PurchasedBooks = invoice.BooksInBasket |> Array.map (fun book -> {
        Quantity = book.Quantity
        Book = mapBookInBasket book
    })
})

let printReport invoices = 
        printfn "****************************************************"
        printfn "*****************Application Report*****************"
        printfn "****************************************************"
        printfn ""
        printfn $"The total number of books sold is: {totalSoldBooks invoices}"
        printfn $"The total number of issued invoices is: {numberOfIssuedInvoices invoices}"
        printfn $"The total amount of all invoices in USD is: {Application.Report.totalAmountInUsd invoices}"
        printfn ""
        printfn "****************************************************"
        printfn "****************************************************"

printReport invoices
 