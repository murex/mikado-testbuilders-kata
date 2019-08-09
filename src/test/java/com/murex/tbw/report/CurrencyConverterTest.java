package com.murex.tbw.report;

import com.murex.tbw.domain.country.Currency;
import org.junit.jupiter.api.Test;

import static com.murex.tbw.finance.CurrencyConverter.fromUSD;
import static com.murex.tbw.finance.CurrencyConverter.toUSD;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyConverterTest {

    @Test
    public void
    WhenConvertingFromUSDToOtherCurrency_TheInputValueShouldBeDividedByTheExchangeRate() {
        assertEquals(2d, fromUSD(2d, Currency.US_DOLLAR));
        assertEquals(1d, fromUSD(1.14d, Currency.EURO));
    }

    @Test
    public void
    WhenConvertingFromACurrencyToUSD_TheInputValueShouldBeMultipliedByTheExchangeRate() {
        assertEquals(2d, toUSD(2d, Currency.US_DOLLAR));
        assertEquals(0.0186d, toUSD(2d, Currency.YEN));
    }

}