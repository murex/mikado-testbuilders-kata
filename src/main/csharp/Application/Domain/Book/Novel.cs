using System;
using System.Collections.Generic;
using Application.Domain.Country;

namespace Application.Domain.Book
{
    public sealed class Novel : IBook
    {
        public string Name { get; }
        public double Price { get; }
        public Author Author { get; }
        public Language Language { get; }
        public List<Genre> Genres { get; }

        public Novel(string name, double price, Author author, Language language, List<Genre> genres)
        {
            Name = name;
            Price = price;
            Author = author;
            Language = language;
            Genres = genres;
        }

        public override string ToString()
            => $"Novel [ {nameof(Name)}: '{Name}'" +
               $", {nameof(Price)}: '{Price}'" +
               $", {nameof(Author)}: '{Author}'" +
               $", {nameof(Language)}: '{Language}'" +
               $", {nameof(Genres)}: '{Genres}' ]";

        private bool Equals(Novel other)
        {
            return Name == other.Name 
                   && Price.Equals(other.Price)
                   && Equals(Author, other.Author)
                   && Language == other.Language 
                   && Equals(Genres, other.Genres);
        }

        public override bool Equals(object obj)
        {
            return ReferenceEquals(this, obj) || obj is Novel other && Equals(other);
        }

        public override int GetHashCode() => HashCode.Combine(Name, Price, Author, (int) Language, Genres);
    }
}