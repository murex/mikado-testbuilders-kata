package com.murex.tbw.finance

import com.murex.tbw.domain.book.Author
import com.murex.tbw.domain.book.Novel
import com.murex.tbw.domain.country.Country
import com.murex.tbw.domain.country.Currency.*
import com.murex.tbw.domain.country.Language.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.IllegalArgumentException
import java.util.stream.Stream

internal class TaxRulesOperationsTest {

    @ParameterizedTest(name = "By default the tax rate for \"{0}\" should be \"{1}\"")
    @MethodSource("defaultTaxRates")
    fun `itShouldConvertFromACurrencyToUSD`(country: Country, taxRate: Double) {
        assertEquals(taxRate, TaxRulesOperations.getApplicableRate(country))
    }

    private companion object {
        @JvmStatic
        fun defaultTaxRates() = Stream.of(
            Arguments.of(Country("USA", US_DOLLAR, ENGLISH), 1.15),
            Arguments.of(Country("France", EURO, FRENCH), 1.25),
            Arguments.of(Country("UK", POUND_STERLING, ENGLISH), 1.20),
            Arguments.of(Country("Spain", EURO, SPANISH), 1.10),
            Arguments.of(Country("China", RENMINBI, MANDARIN), 1.35),
            Arguments.of(Country("Japan", YEN, JAPANESE), 1.30),
            Arguments.of(Country("Australia", AUSTRALIAN_DOLLAR, ENGLISH), 1.13),
            Arguments.of(Country("Germany", EURO, GERMAN), 1.22)
        )
    }

    @Test
    fun taxShouldBeAppendedWhenBothTheAuthorAndInvoiceCountryAreFromGermany() {
        val germany = Country("Germany", EURO, GERMAN)
        val grass = Author("Gunter Grass", germany)
        val theTinDrum = Novel("The Tin Drum", 20.0, grass, GERMAN, emptyList())
        assertEquals(1.05, TaxRulesOperations.getApplicableRate(germany, theTinDrum))
    }

    @Test
    fun taxShouldBeAppendedWhenTheBookIsNovelAndTheInvoiceCountryIsUSA() {
        val usa = Country("USA", US_DOLLAR, ENGLISH)
        val germany = Country("Germany", EURO, GERMAN)
        val grass = Author("Gunter Grass", germany)
        val theTinDrum = Novel("The Tin Drum", 20.0, grass, GERMAN, emptyList())
        assertEquals(1.127, TaxRulesOperations.getApplicableRate(usa, theTinDrum))
    }

    @Test
    fun taxShouldBeAppendedWhenTheBookIsNovelAndTheInvoiceCountryIsUK() {
        val uk = Country("UK", POUND_STERLING, ENGLISH)
        val germany = Country("Germany", EURO, GERMAN)
        val grass = Author("Gunter Grass", germany)
        val theTinDrum = Novel("The Tin Drum", 20.0, grass, GERMAN, emptyList())
        assertEquals(1.116, TaxRulesOperations.getApplicableRate(uk, theTinDrum))
    }

    @Test
    fun noTaxShouldBeAppliedWhenTheLanguageIsForeignAndTheInvoiceCountryIsChina() {
        val china = Country("China", RENMINBI, MANDARIN)
        val germany = Country("Germany", EURO, GERMAN)
        val grass = Author("Gunter Grass", germany)
        val theTinDrum = Novel("The Tin Drum", 20.0, grass, GERMAN, emptyList())
        assertEquals(1.0, TaxRulesOperations.getApplicableRate(china, theTinDrum))
    }

    @Test
    fun noTaxShouldBeAppliedWhenTheLanguageIsForeignAndTheInvoiceCountryIsSpain() {
        val spain = Country("Spain", EURO, SPANISH)
        val germany = Country("Germany", EURO, GERMAN)
        val grass = Author("Gunter Grass", germany)
        val theTinDrum = Novel("The Tin Drum", 20.0, grass, GERMAN, emptyList())
        assertEquals(1.0, TaxRulesOperations.getApplicableRate(spain, theTinDrum))
    }

    @Test
    fun itShouldThrowAnExceptionIfTheInvoiceCountryIsNotValid() {
        val country = Country("country", POUND_STERLING, ENGLISH)
        assertThrows<IllegalArgumentException> { TaxRulesOperations.getApplicableRate(country) }
    }
}