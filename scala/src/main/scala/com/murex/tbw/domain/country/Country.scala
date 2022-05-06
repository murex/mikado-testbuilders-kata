package com.murex.tbw.domain.country

import com.murex.tbw.domain.country.Currencies.Currency
import com.murex.tbw.domain.country.Languages.Language

case class Country(name: String, currency: Currency, language: Language)
