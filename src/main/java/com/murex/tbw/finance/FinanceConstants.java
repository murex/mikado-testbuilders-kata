package com.murex.tbw.finance;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public final class FinanceConstants {
    private static final Map<String, Double> TAX_RATES = ImmutableMap.<String, Double>builder()
            .put("USA", 1.15d)
            .put("France", 1.25d)
            .put("UK", 1.20d)
            .put("Spain", 1.10d)
            .put("China", 1.35d)
            .put("Japan", 1.30d)
            .put("Australia", 1.13d)
            .put("Germany", 1.22d)
            .build();

    private static final Map<String, Double> EXCHANGE_RATE_TO_USD = ImmutableMap.<String, Double>builder()
            .put("USD", 1.00d)
            .put("Euro", 1.14d)
            .put("Pound Sterling", 1.27d)
            .put("Renminbi", 0.15d)
            .put("YEN", 0.0093d)
            .put("Australian Dollar", 0.70d)
            .build();

    public static double getTaxRate(String country) {
        return TAX_RATES.get(country);
    }

    public static double getExchangeRateToUSDFor(String currency) {
        return EXCHANGE_RATE_TO_USD.get(currency);
    }

}
