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

import com.murex.tbw.domain.book.*
import com.murex.tbw.domain.country.Country
import com.murex.tbw.domain.country.Currency.*
import com.murex.tbw.domain.country.Language
import com.murex.tbw.domain.country.Language.*
import com.murex.tbw.finance.TaxRulesOperations.Converter.getApplicableRate
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

private val AUSTRALIA = Country("Australia", AUSTRALIAN_DOLLAR, ENGLISH)
private val CHINA = Country("China", RENMINBI, MANDARIN)
private val FRANCE = Country("France", EURO, FRENCH)
private val GERMANY = Country("Germany", EURO, GERMAN)
private val JAPAN = Country("Japan", YEN, JAPANESE)
private val SPAIN = Country("Spain", EURO, SPANISH)
private val UK = Country("UK", POUND_STERLING, ENGLISH)
private val USA = Country("USA", US_DOLLAR, ENGLISH)
private val FRENCH_WRITER = Author("French Author", FRANCE)

internal class TaxRulesOperationsTest {

    @ParameterizedTest(name = "By default the tax rate for \"{0}\" should be \"{1}\"")
    @MethodSource("defaultTaxRates")
    fun whenRestrictionsApplyItShouldReturnTheDefaultTaxRates(country: Country, taxRate: Double, language: Language) {
        val book = EducationalBook("Learn New Language", 20.0, FRENCH_WRITER, language, Category.LANGUAGE)
        assertEquals(taxRate, getApplicableRate(country, book))
    }

    private companion object {
        @JvmStatic
        fun defaultTaxRates(): Stream<Arguments>? {
            return Stream.of(
                Arguments.of(USA, 1.15, FRENCH),
                Arguments.of(FRANCE, 1.25, FRENCH),
                Arguments.of(UK, 1.20, FRENCH),
                Arguments.of(SPAIN, 1.10, SPANISH),
                Arguments.of(CHINA, 1.35, MANDARIN),
                Arguments.of(JAPAN, 1.30, MANDARIN),
                Arguments.of(AUSTRALIA, 1.13, FRENCH),
                Arguments.of(GERMANY, 1.22, FRENCH)
            )
        }
    }

    @Test
    fun itShouldThrowAnExceptionIfTheInvoiceCountryIsNotValid() {
        val author = Author("Gunter Grass", GERMANY)
        val novel = Novel("The Tin Drum", 20.0, author, GERMAN, emptyList())
        val invalidCountry = Country("country", POUND_STERLING, ENGLISH)
        assertThrows<IllegalArgumentException> { getApplicableRate(invalidCountry, novel) }
    }

    @Test
    fun taxShouldBeAppendedWhenBothTheAuthorAndInvoiceCountryAreFromGermany() {
        assertRateApplied(1.05, GERMANY)
    }

    @Test
    fun taxShouldBeAppendedWhenTheBookIsNovelAndTheInvoiceCountryIsUSA() {
        assertRateApplied(1.127, USA)
    }

    @Test
    fun taxShouldBeAppendedWhenTheBookIsNovelAndTheInvoiceCountryIsUK() {
        assertRateApplied(1.116, UK)
    }

    @Test
    fun noTaxShouldBeAppliedWhenTheLanguageIsForeignAndTheInvoiceCountryIsChina() {
        assertRateApplied(1.0, CHINA)
    }

    @Test
    fun noTaxShouldBeAppliedWhenTheLanguageIsForeignAndTheInvoiceCountryIsSpain() {
        assertRateApplied(1.0, SPAIN)
    }

    private fun assertRateApplied(expected: Double, country: Country) {
        val author = Author("Gunter Grass", GERMANY)
        val novel = Novel("The Tin Drum", 20.0, author, GERMAN, emptyList())
        assertEquals(expected, getApplicableRate(country, novel))
    }
}