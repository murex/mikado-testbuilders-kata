package com.murex.tbw.domain.book

import com.murex.tbw.domain.country.Languages.Language

trait Book {
  val name: String
  val price: Double
  val author: Author
  val language: Language
}
