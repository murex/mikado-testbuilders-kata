namespace Application.Domain

type Author = {
    Name: string
    Nationality: Country
}

type Genre = 
    | HorrorFiction
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
    | Novel of Book * seq<Genre> 
    | EducationalBook of Book * Category