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
using Application.Domain.Book;

namespace Application.Purchase
{
    public sealed class PurchasedBook
    {
        public IBook Book { get; }
        public int Quantity { get; }
        public double TotalPrice => Book.Price * Quantity;

        public PurchasedBook(IBook book, int quantity)
        {
            Book = book;
            Quantity = quantity;
        }

        public override string ToString() => $"PurchasedBook [ {nameof(Book)}: '{Book}'" +
                                             $", {nameof(Quantity)}: '{Quantity}' ]";

        private bool Equals(PurchasedBook other) => Equals(Book, other.Book)
                                                    && Quantity == other.Quantity;

        public override bool Equals(object obj) => ReferenceEquals(this, obj) 
                                                   || obj is PurchasedBook other && Equals(other);

        public override int GetHashCode() => HashCode.Combine(Book, Quantity);
    }
}
