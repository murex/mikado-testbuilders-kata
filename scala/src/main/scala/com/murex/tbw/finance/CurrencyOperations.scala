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

import com.murex.tbw.domain.country.Currencies._

import scala.math.floor

object CurrencyOperations {
  private val EXCHANGE_RATE = Map(
    US_DOLLAR -> 1.0,
    EURO -> 1.14,
    POUND_STERLING -> 1.27,
    RENMINBI -> 0.15,
    YEN -> 0.0093,
    AUSTRALIAN_DOLLAR -> 0.7
  )

  def fromUSD(input: Double, toCurrency: Currency): Double = {
    val value: Double =
      input / EXCHANGE_RATE.getOrElse(toCurrency, throw new IllegalStateException(""))
    floor(value * 100) / 100
  }

  def toUSD(input: Double, toCurrency: Currency): Double = {
    val value: Double =
      input * EXCHANGE_RATE.getOrElse(toCurrency, throw new IllegalStateException(""))
    floor(value * 100) / 100
  }
}
