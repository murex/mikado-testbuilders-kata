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
using Application.Domain.Book;
using Application.Domain.Country;
using static Application.Domain.Country.Language;

namespace Application.Finance
{
    public static class TaxRule
    {
        private static readonly IReadOnlyDictionary<string, double> TaxRates =
            new ReadOnlyDictionary<string, double>(
                new Dictionary<string, double>
                {
                    {"USA", 1.15},
                    {"France", 1.25},
                    {"UK", 1.20d},
                    {"Spain", 1.10d},
                    {"China", 1.35d},
                    {"Japan", 1.30d},
                    {"Australia", 1.13d},
                    {"Germany", 1.22d},
                });

        public static double GetApplicableRate(Country invoiceCountry, IBook book)
        {
            if (invoiceCountry.Name.Equals("Germany"))
                if (book.Author.Nationality.Name.Equals("Germany"))
                    return 1.05;

            if (invoiceCountry.Name.Equals("USA"))
                if (book is Novel)
                    return GetTaxRate(invoiceCountry.Name) * 0.98;

            if (invoiceCountry.Name.Equals("UK"))
                if (book is Novel)
                    return GetTaxRate(invoiceCountry.Name) * 0.93;


            if (invoiceCountry.Name.Equals("China"))
                if (!book.Language.Equals(Mandarin))
                    return 1;

            if (invoiceCountry.Name.Equals("Spain"))
                if (!book.Language.Equals(Spanish))
                    return 1;

            return GetTaxRate(invoiceCountry.Name);
        }

        private static double GetTaxRate(string country) => TaxRates[country];
    }
}
