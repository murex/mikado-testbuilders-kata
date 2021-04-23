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

import com.murex.tbw.domain.country.Currency
import com.murex.tbw.domain.country.Currency.*
import kotlin.math.floor

class CurrencyOperations {

    companion object Converter {
        private val EXCHANGE_RATE = mapOf(
            US_DOLLAR to 1.0,
            EURO to 1.14,
            POUND_STERLING to 1.27,
            RENMINBI to 0.15,
            YEN to 0.0093,
            AUSTRALIAN_DOLLAR to 0.7
        )

        @JvmStatic
        fun fromUSD(input: Double, toCurrency: Currency): Double {
            val value = input / (EXCHANGE_RATE[toCurrency] ?: error(""))
            return floor(value * 100) / 100
        }

        @JvmStatic
        fun toUSD(input: Double, fromCurrency: Currency): Double {
            val value = input * (EXCHANGE_RATE[fromCurrency] ?: error(""))
            return floor(value * 100) / 100
        }
    }
}