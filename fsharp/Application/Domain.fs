module Application

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

module Purchase =

    open Domain
    
    type PurchasedBook = { 
        Book: Book
        Quantity: int
    }

    type Invoice = {
        Id: int
        ClientName: string
        Country: Country
        PurchasedBooks: seq<PurchasedBook>
    }

module Finance =

    open Domain

    type FromUsd = Price -> Currency -> Price
    type ToUsd = Price -> Currency -> Price

    type ApplicableRate = Country -> BookType

    let exchangeRate currency = 
        match currency with
        | UsDollar -> 1.0
        | AustralianDollar -> 0.7
        | Euro -> 1.14
        | PoundSterling -> 1.27
        | Reminbi -> 0.15
        | Yen -> 0.0093

    let fromUsd (price:Price) currency = price / (exchangeRate currency)
    let toUsd price currency = price * exchangeRate currency

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
        if not (country.Language = bookLanguage) then
            1.0
        else
            taxRate country

    let taxRateForForeignAuthor (country:Country) authorNationality =
        if authorNationality = country.Name then
            1.05
        else
            taxRate country

    let applicableRate (country:Country) book =
        match country.Name with
        | USA -> 
            match book with
            | Novel _ -> taxRate country * 0.98
            | _ -> taxRate country
        | UK ->
            match book with
            | Novel _ -> taxRate country * 0.93
            | _ -> taxRate country
        | Germany -> 
            match book with
            | Novel (book,_) -> 
                taxRateForForeignAuthor country book.Author.Nationality.Name
            | EducationalBook (book,_) -> 
                taxRateForForeignAuthor country book.Author.Nationality.Name
        | China ->
            match book with
            | Novel (book,_) ->
                taxRateForForeignLanguage country book.Language
            | EducationalBook (book, _) ->
                taxRateForForeignLanguage country book.Language
        | Spain ->
            match book with
            | Novel (book,_) ->
                taxRateForForeignLanguage country book.Language
            | EducationalBook (book, _) ->
                taxRateForForeignLanguage country book.Language
        | _ -> taxRate country
            