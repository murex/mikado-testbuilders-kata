package com.murex.tbw.finance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FinanceConstantsTest {
    @Test
    public void
    ItShouldReturnTheTaxValueOfTheSelectedCountry() {
        Assertions.assertEquals(1.15d, FinanceConstants.getTaxRate("USA"));
    }

}