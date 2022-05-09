/*
 * ******************************************************************************
 *  *
 *  * Copyright (c) {2003-2022} Murex S.A.S. and its affiliates.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the MIT License
 *  * which accompanies this distribution, and is available at
 *  * https://opensource.org/licenses/MIT
 *  *
 *  ******************************************************************************
 */

package com.murex.tbw.finance

import com.murex.tbw.domain.book.{Book, Novel}
import com.murex.tbw.domain.country.Country
import com.murex.tbw.domain.country.Languages._

object TaxRulesOperations {
  private val USA = "USA"
  private val FRANCE = "France"
  private val UK = "UK"
  private val SPAIN = "Spain"
  private val CHINA = "China"
  private val JAPAN = "Japan"
  private val AUSTRALIA = "Australia"
  private val GERMANY = "Germany"

  private val TAX_RATES = Map(
    USA -> 1.15,
    FRANCE -> 1.25,
    UK -> 1.20,
    SPAIN -> 1.10,
    CHINA -> 1.35,
    JAPAN -> 1.30,
    AUSTRALIA -> 1.13,
    GERMANY -> 1.22
  )

  def getApplicableRate(invoiceCountry: Country, book: Book): Double = {
    val invoiceCountryName = invoiceCountry.name
    val taxRate = TAX_RATES.getOrElse(
      invoiceCountryName,
      throw new IllegalArgumentException(s"Country $invoiceCountryName is not valid!")
    )

    if (invoiceCountryName == GERMANY) {
      if (book.author.nationality.name == GERMANY) {
        return 1.05
      }
    }
    if (invoiceCountryName == USA) {
      if (book.isInstanceOf[Novel]) {
        return taxRate * 0.98
      }
    }
    if (invoiceCountryName == UK) {
      if (book.isInstanceOf[Novel]) {
        return taxRate * 0.93
      }
    }
    if (invoiceCountryName == CHINA) {
      if (book.language != MANDARIN) {
        return 1.0
      }
    }
    if (invoiceCountryName == SPAIN) {
      if (book.language != SPANISH) {
        return 1.0
      }
    }
    taxRate
  }
}
