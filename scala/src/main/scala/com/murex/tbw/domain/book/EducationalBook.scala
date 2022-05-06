package com.murex.tbw.domain.book

import com.murex.tbw.domain.book.Categories.Category
import com.murex.tbw.domain.country.Languages.Language

case class EducationalBook(
    name: String,
    price: Double,
    author: Author,
    language: Language,
    category: Category
) extends Book {}
