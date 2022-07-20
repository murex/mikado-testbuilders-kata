﻿module Application

module Domain =

    type Currency = 
        UsDollar
        | AustralianDollar
        | Euro
        | PoundSterling
        | Yen
        | Reminbi

    type Language =
        English
        | French
        | Spanish
        | Japanese
        | Mandarin
        | Arabic
        | German

    type CountryName =
        USA
        | France
        | UK
        | Spain
        | China
        | Japan
        | Australia
        | Germany

    type Country = {
        Name: CountryName
        Currency: Currency
        Language: Language
    }

    type Author = {
        Name: string
        Nationality: Country
    }

    type Genre = 
        HorrorFiction
        | Thriller
        | DarkFantasy
        | Mystery
        | AdventureFiction
        | NonFiction
        | Romance

    type Price = float

    type Book = {
        Name: string
        Price: Price
        Author: Author
        Language: Language
    }

    type Category = Business | Language | Computer

    type BookType = 
        Novel of Book * seq<Genre> 
        | EducationalBook of Book * Category

module Finance =

    open Domain

    type FromUsd = Currency -> Price -> Price
    type ToUsd = Currency -> Price -> Price

    type ApplicableRate = Country -> BookType

    let exchangeRate currency = 
        match currency with
        | UsDollar -> 1.0
        | AustralianDollar -> 0.7
        | Euro -> 1.14
        | PoundSterling -> 1.27
        | Reminbi -> 0.15
        | Yen -> 0.0093

    let fromUsd currency (price:Price) = price / (exchangeRate currency)
    let toUsd currency (price:Price) = price * exchangeRate currency

    let taxRate (country:Country) =
        match country.Name with
        | USA -> 1.15
        | France -> 1.25
        | UK -> 1.2
        | Spain -> 1.10
        | China -> 1.35
        | Japan -> 1.30
        | Australia -> 1.13
        | Germany -> 1.22

    let taxRateForForeignLanguage (country:Country) bookLanguage =
        if country.Language <> bookLanguage then
            1.0
        else
            taxRate country

    let taxRateForForeignAuthor (country:Country) authorNationality =
        if authorNationality = country.Name then
            1.05
        else
            taxRate country

    let applicableRate (country:Country) book =
        match country.Name, book with
        | USA, Novel _ -> taxRate country * 0.98
        | UK, Novel _ -> taxRate country * 0.93
        | Germany, Novel (book,_) 
        | Germany, EducationalBook (book,_) -> taxRateForForeignAuthor country book.Author.Nationality.Name
        | China, Novel (book, _) 
        | China, EducationalBook (book, _)
        | Spain, Novel (book,_) 
        | Spain, EducationalBook (book, _) -> taxRateForForeignLanguage country book.Language
        | _, _ -> taxRate country

module Purchase =

    open Domain
    
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

module Report =
    
    open Purchase
    open Domain
    open Finance

    type TotalSoldBooks = seq<Invoice> -> int
    type NumberOfIssuedInvoices = seq<Invoice> -> int
    type TotalAmountInUsd = seq<Invoice> -> Price

    type PrintReport = TotalSoldBooks -> NumberOfIssuedInvoices -> TotalAmountInUsd -> unit
    
    let totalSoldBooks (invoices:seq<Invoice>) =
        invoices 
        |> Seq.collect (fun invoice -> invoice.PurchasedBooks) 
        |> Seq.map (fun purchasedBook -> purchasedBook.Quantity)
        |> Seq.sum

    let numberOfIssuedInvoices (invoices:seq<Invoice>) =
        invoices
        |> Seq.length

    let totalAmountInUsd (totalAmount:TotalAmount) (toUsd:ToUsd) (invoices:seq<Invoice>) =
        invoices 
        |> Seq.map (fun invoice -> (totalAmount invoice) |> toUsd invoice.Country.Currency)
        |> Seq.sum
