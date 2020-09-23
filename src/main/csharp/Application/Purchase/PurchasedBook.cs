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

        public override string ToString() 
            => $"PurchasedBook [ {nameof(Book)}: '{Book}'" +
               $", {nameof(Quantity)}: '{Quantity}' ]";

        private bool Equals(PurchasedBook other)
        {
            return Equals(Book, other.Book) 
                   && Quantity == other.Quantity;
        }

        public override bool Equals(object obj)
        {
            return ReferenceEquals(this, obj) || obj is PurchasedBook other && Equals(other);
        }

        public override int GetHashCode() => HashCode.Combine(Book, Quantity);
    }
}