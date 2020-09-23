﻿using System;
using System.Collections.Generic;
using System.Linq;
using Application.Domain.Country;

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

        public double ComputeTotalAmount()
        {
            var totalAmount = 0.0;
            totalAmount = PurchasedBooks.Sum(book => book.TotalPrice);
            return totalAmount;
        }

        public override string ToString() 
            => $"Invoice [ {nameof(Id)}: '{Id}'" +
               $", {nameof(ClientName)}: '{ClientName}'" +
               $", {nameof(Country)}: '{Country}'" +
               $", {nameof(PurchasedBooks)}: '{PurchasedBooks}' ]";

        private bool Equals(Invoice other)
        {
            return Id == other.Id
                   && ClientName == other.ClientName
                   && Equals(Country, other.Country) 
                   && Equals(PurchasedBooks, other.PurchasedBooks);
        }

        public override bool Equals(object obj)
        {
            return ReferenceEquals(this, obj) || obj is Invoice other && Equals(other);
        }

        public override int GetHashCode() => HashCode.Combine(Id, ClientName, Country, PurchasedBooks);
    }
}