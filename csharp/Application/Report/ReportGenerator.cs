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
using System.Linq;
using Application.Finance;
using Application.Purchase;
using Application.Storage;

namespace Application.Report
{
    public class ReportGenerator
    {
        private readonly IRepository _repository = MainRepository.ConfiguredRepository;

        public double GetTotalAmount()
        {
            var invoices = _repository.GetInvoiceMap().Values;
            var totalAmount = invoices.Sum(invoice => invoice.ComputeTotalAmount());
            // Bugfix for ReportGenerator:
            // var totalAmount = invoices.Sum(invoice => CurrencyConverter.ToUsd(invoice.ComputeTotalAmount(), invoice.Country.Currency));
            return totalAmount;
        }

        public int GetTotalSoldBooks()
        {
            var invoices = _repository.GetInvoiceMap().Values;
            var totalSoldBooks = invoices
                .Sum(invoice => invoice.PurchasedBooks.Sum(purchasedBook => purchasedBook.Quantity));

            return totalSoldBooks;
        }

        public long GetNumberOfIssuedInvoices() => _repository.GetInvoiceMap().Count;
    }
}
