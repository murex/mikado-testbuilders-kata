/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using Application.Domain.Country;
using Application.Finance;

namespace Application.Purchase
{
    public sealed class Invoice
    {
        public int Id { get; }
        public string ClientName { get; }
        public Country Country { get; }
        public List<PurchasedBook> PurchasedBooks { get; }


        public Invoice(string clientName, Country country)
            : this(IdGenerator.NextId(), clientName, country)
        {
        }

        public Invoice(int id, string clientName, Country country)
        {
            Id = id;
            ClientName = clientName;
            Country = country;
            PurchasedBooks = new List<PurchasedBook>();
        }

        public void AddPurchasedBooks(List<PurchasedBook> books)
        {
            PurchasedBooks.AddRange(books);
        }

        public void AddPurchasedBook(PurchasedBook book)
        {
            PurchasedBooks.Add(book);
        }

        public double ComputeTotalAmount()
        {
            var totalAmount = 0.0;

            // BUG: There was a bug with the following line of code
            // totalAmount = PurchasedBooks.Sum(book => book.TotalPrice);

            // FIX: The above bug was fixed by the following line of code
            totalAmount = PurchasedBooks.Sum(book => book.TotalPrice * TaxRule.GetApplicableRate(Country, book.Book));

            return totalAmount;
        }

        public override string ToString() => $"Invoice [ {nameof(Id)}: '{Id}'" +
                                             $", {nameof(ClientName)}: '{ClientName}'" +
                                             $", {nameof(Country)}: '{Country}'" +
                                             $", {nameof(PurchasedBooks)}: '{PurchasedBooks}' ]";

        private bool Equals(Invoice other) => Id == other.Id
                                              && ClientName == other.ClientName
                                              && Equals(Country, other.Country)
                                              && Equals(PurchasedBooks, other.PurchasedBooks);

        public override bool Equals(object obj) => ReferenceEquals(this, obj)
                                                   || obj is Invoice other && Equals(other);

        public override int GetHashCode() => HashCode.Combine(Id, ClientName, Country, PurchasedBooks);
    }
}