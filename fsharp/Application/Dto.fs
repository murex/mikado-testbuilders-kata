namespace Application.Dto

open Application.Domain
open Application

//#r "nuget: FSharp.Data"
open FSharp.Data

type InvoiceProvider = JsonProvider<"Storage/repository.json", RootName = "Invoice">

module private Country =
    let toCountryName country = 
        match country with
        | "USA" -> USA
        | "France" -> France
        | "Spain" -> Spain
        | "UK" -> UK
        | "Germany" -> Germany
        | "China" -> China
        | "Japan" -> Japan
        | "Australia" | _ -> Australia

    let toCurrency currency =
        match currency with
        | "US_DOLLAR" -> UsDollar
        | "RENMINBI" -> Reminbi
        | "EURO" -> Euro
        | "POUND_STERLING" | _ -> PoundSterling

    let toLanguage language =
        match language with
        | "ENGLISH" -> English
        | "MANDARIN" -> Mandarin
        | "SPANISH" -> Spanish
        | "GERMAN" | _ -> German

module private Book = 
    let toCategory category =
        match category with
        | "LANGUAGE" -> Language
        | "COMPUTER" -> Computer
        | "BUSINESS" | _ -> Business

    let toGenre genre =
        match genre with
        | "MYSTERY" -> Mystery
        | "ADVENTURE_FICTION" -> AdventureFiction
        | "DARK_FANTASY" -> DarkFantasy
        | "ROMANCE" | _ -> Romance

    let toBook (bookInBasket: InvoiceProvider.BooksInBasket) =
        let book = {
            Name = bookInBasket.Name
            Price = float bookInBasket.Price
            Author = { 
                Name = bookInBasket.Author.Name
                Nationality = {
                    Name = Country.toCountryName bookInBasket.Author.Nationality.Name
                    Currency = Country.toCurrency bookInBasket.Author.Nationality.Currency
                    Language = Country.toLanguage bookInBasket.Author.Nationality.Language
                }
            }
            Language = Country.toLanguage bookInBasket.Language
        }
        match bookInBasket.Category, bookInBasket.Genre with
        | Some category, _ -> EducationalBook (book, toCategory category)
        | None , genres -> Novel (book, genres |> Array.map (fun genre -> toGenre genre))
      
module Invoice =
    let toDomain (invoice: InvoiceProvider.Invoice) : Purchase.Invoice = 
        {
            Id = invoice.Id
            ClientName = invoice.Client
            Country = {
                Name = Country.toCountryName invoice.Country.Name
                Currency = Country.toCurrency invoice.Country.Currency
                Language = Country.toLanguage invoice.Country.Language
            }
            PurchasedBooks = invoice.BooksInBasket |> Array.map (fun book -> {
                Quantity = book.Quantity
                Book = Book.toBook book
            })
        }

