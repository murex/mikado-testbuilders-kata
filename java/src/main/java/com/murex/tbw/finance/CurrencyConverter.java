/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.finance;

import com.google.common.collect.ImmutableMap;
import com.murex.tbw.domain.country.Currency;

import java.util.Map;

import static com.murex.tbw.domain.country.Currency.*;

public final class CurrencyConverter {

    private static final Map<Currency, Double> EXCHANGE_RATE = ImmutableMap.<Currency, Double>builder()
            .put(US_DOLLAR, 1.0d)
            .put(EURO, 1.14d)
            .put(POUND_STERLING, 1.27d)
            .put(RENMINBI, 0.15d)
            .put(YEN, 0.0093d)
            .put(AUSTRALIAN_DOLLAR, 0.7d)
            .build();

    public static double fromUSD(double input, Currency currency) {
        return input / EXCHANGE_RATE.get(currency);
    }

    public static double toUSD(double input, Currency currency) {
        return input * EXCHANGE_RATE.get(currency);
    }
}
