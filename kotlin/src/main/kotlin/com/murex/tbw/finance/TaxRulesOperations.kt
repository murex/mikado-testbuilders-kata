package com.murex.tbw.finance

import com.murex.tbw.domain.book.Book
import com.murex.tbw.domain.country.Country

class TaxRulesOperations {

    companion object Converter {
        private val TAX_RATES = mapOf(
            "USA" to 1.15,
            "France" to 1.25,
            "UK" to 1.20,
            "Spain" to 1.10,
            "China" to 1.35,
            "Japan" to 1.30,
            "Australia" to 1.13,
            "Germany" to 1.22
        )

        @JvmStatic
        fun getApplicableRate(invoiceCountry: Country, book: Book?): Double {
            return TAX_RATES.get(invoiceCountry.name)!!
        }
    }
}