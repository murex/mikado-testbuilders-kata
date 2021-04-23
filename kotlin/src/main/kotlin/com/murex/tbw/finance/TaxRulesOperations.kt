/*******************************************************************************
 *
 * Copyright (c) {2003-2021} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.finance

import com.murex.tbw.domain.book.Book
import com.murex.tbw.domain.book.Novel
import com.murex.tbw.domain.country.Country
import com.murex.tbw.domain.country.Language.*

class TaxRulesOperations {

    companion object Converter {
        private const val USA = "USA"
        private const val FRANCE = "France"
        private const val UK = "UK"
        private const val SPAIN = "Spain"
        private const val CHINA = "China"
        private const val JAPAN = "Japan"
        private const val AUSTRALIA = "Australia"
        private const val GERMANY = "Germany"

        private val TAX_RATES = mapOf(
            USA to 1.15,
            FRANCE to 1.25,
            UK to 1.20,
            SPAIN to 1.10,
            CHINA to 1.35,
            JAPAN to 1.30,
            AUSTRALIA to 1.13,
            GERMANY to 1.22
        )

        @JvmStatic
        fun getApplicableRate(invoiceCountry: Country, book: Book? = null): Double {
            val invoiceCountryName = invoiceCountry.name
            val taxRate = TAX_RATES[invoiceCountryName]
                ?: throw  IllegalArgumentException("Country $invoiceCountryName is not valid!")
            if (book != null) {
                if (invoiceCountryName == GERMANY) {
                    if (book.author.nationality.name == GERMANY) {
                        return 1.05;
                    }
                }
                if (invoiceCountryName == USA) {
                    if (book is Novel)
                        return taxRate.times(0.98)
                }
                if (invoiceCountryName == UK) {
                    if (book is Novel)
                        return taxRate.times(0.93)
                }
                if(invoiceCountryName == CHINA) {
                    if(book.language != MANDARIN) {
                        return 1.0
                    }
                }
                if(invoiceCountryName == SPAIN) {
                    if(book.language != SPANISH) {
                        return 1.0
                    }
                }
            }
            return taxRate
        }
    }
}