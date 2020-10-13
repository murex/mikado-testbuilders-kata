/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

using System.Collections.Generic;
using System.Collections.ObjectModel;
using Application.Domain.Country;
using static Application.Domain.Country.Currency;

namespace Application.Finance
{
    public sealed class CurrencyConverter
    {
        private static readonly IReadOnlyDictionary<Currency, double> ExchangeRate =
            new ReadOnlyDictionary<Currency, double>(
                new Dictionary<Currency, double>
                {
                    {UsDollar, 1.0},
                    {Euro, 1.14},
                    {PoundSterling, 1.27},
                    {Renminbi, 0.15},
                    {Yen, 0.0093},
                    {AustralianDollar, 0.7}
                });

        public static double FromUsd(double input, Currency currency) => input / ExchangeRate[currency];

        public static double ToUsd(double input, Currency currency) => input * ExchangeRate[currency];
    }
}
