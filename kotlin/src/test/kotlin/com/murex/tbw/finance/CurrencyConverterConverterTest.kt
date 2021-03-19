package com.murex.tbw.finance


import com.murex.tbw.domain.country.Currency
import com.murex.tbw.domain.country.Currency.*
import com.murex.tbw.finance.CurrencyConverter.Converter.fromUSD
import com.murex.tbw.finance.CurrencyConverter.Converter.toUSD
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream.of

internal class CurrencyConverterConverterTest {

    @ParameterizedTest(name = "Converting an amount of \"{0}\" USD to \"{1}\" should return {2}")
    @MethodSource("fromUSDArguments")
    fun `itShouldConvertFromUSDToACurrency`(amount: Double, currency: Currency, result: Double) {
        assertEquals(result, fromUSD(amount, currency))
    }

    @ParameterizedTest(name = "Converting an amount of \"{0}\" \"{1}\" to USD should return {2}")
    @MethodSource("toUSDArguments")
    fun `itShouldConvertFromACurrencyToUSD`(amount: Double, currency: Currency, result: Double) {
        assertEquals(result, toUSD(amount, currency))
    }

    private companion object {
        @JvmStatic
        fun fromUSDArguments() = of(
            Arguments.of(20.0, US_DOLLAR, 20.0),
            Arguments.of(20.0, EURO, 17.54),
            Arguments.of(20.0, POUND_STERLING, 15.74),
            Arguments.of(20.0, RENMINBI, 133.33),
            Arguments.of(20.0, YEN, 2150.53),
            Arguments.of(20.0, AUSTRALIAN_DOLLAR, 28.57)
        )

        @JvmStatic
        fun toUSDArguments() = of(
            Arguments.of(20.0, US_DOLLAR, 20.0),
            Arguments.of(20.0, EURO, 22.79),
            Arguments.of(20.0, POUND_STERLING, 25.4),
            Arguments.of(20.0, RENMINBI, 3.0),
            Arguments.of(20.0, YEN, 0.18),
            Arguments.of(20.0, AUSTRALIAN_DOLLAR, 14.0)
        )
    }

}