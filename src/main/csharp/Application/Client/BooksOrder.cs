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
using Application.Domain.Book;
using Application.Purchase;

namespace Application.Client
{
   public sealed class BooksOrder : IOrder
    {
        private readonly Dictionary<IBook, int> _booksInBasket;
        private readonly Client _client;

        public BooksOrder(Client client)
        {
            _client = client;
            _booksInBasket = new Dictionary<IBook, int>();
        }

        public void AddBook(IBook book, int quantity)
        {
            var existingQuanty =  _booksInBasket.GetValueOrDefault(book,0);
            _booksInBasket[book] = existingQuanty + quantity;
        }

        public Invoice CheckOut()
        {
            var invoice = new Invoice(_client.Name, _client.Country);
            
            foreach (var (book, quantity) in _booksInBasket)
                invoice.AddPurchasedBook(new PurchasedBook(book, quantity));

            MainRepository.ConfiguredRepository.AddInvoice(invoice);
            return invoice;
        }

        public int GetQuantityOf(IBook book) => _booksInBasket.GetValueOrDefault(book, 0);
    }
}
