module Application.Finance

open Application.Domain

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