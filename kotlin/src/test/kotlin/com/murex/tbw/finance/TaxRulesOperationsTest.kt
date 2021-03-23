package com.murex.tbw.finance

import com.murex.tbw.domain.country.Country
import com.murex.tbw.domain.country.Currency
import com.murex.tbw.domain.country.Language
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class TaxRulesOperationsTest {

    @ParameterizedTest(name = "By default the tax rate for \"{0}\" should be \"{1}\"")
    @MethodSource("defaultTaxRates")
    fun `itShouldConvertFromACurrencyToUSD`(country: Country, taxRate: Double) {
        assertEquals(taxRate, TaxRulesOperations.getApplicableRate(country, null))
    }

    private companion object {
        @JvmStatic
        fun defaultTaxRates() = Stream.of(
            Arguments.of(Country("USA", Currency.US_DOLLAR, Language.ENGLISH), 1.15),
            Arguments.of(Country("France", Currency.EURO, Language.FRENCH), 1.25),
            Arguments.of(Country("UK", Currency.POUND_STERLING, Language.ENGLISH), 1.20),
            Arguments.of(Country("Spain", Currency.EURO, Language.SPANISH), 1.10),
            Arguments.of(Country("China", Currency.RENMINBI, Language.MANDARIN), 1.35),
            Arguments.of(Country("Japan", Currency.YEN, Language.JAPANESE), 1.30),
            Arguments.of(Country("Australia", Currency.AUSTRALIAN_DOLLAR, Language.ENGLISH), 1.13),
            Arguments.of(Country("Germany", Currency.EURO, Language.GERMAN), 1.22)
        )
    }
}