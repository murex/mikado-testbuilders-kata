package com.murex.tbw.domain.book

import com.murex.tbw.domain.book.Genres.Genre
import com.murex.tbw.domain.country.Languages.Language

case class Novel(
    name: String,
    price: Double,
    author: Author,
    language: Language,
    genres: List[Genre] = List.empty
) extends Book {}
