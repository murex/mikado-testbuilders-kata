using System;

namespace Application.Domain.Book
{
    public class Author
    {
        public string Name { get; }
        public Country.Country Nationality { get; }

        public Author(string name, Country.Country nationality)
        {
            Name = name;
            Nationality = nationality;
        }

        public override string ToString() 
            => $"Author [ {nameof(Name)}: '{Name}', " +
               $"{nameof(Nationality)}: '{Nationality}' ]";

        protected bool Equals(Author other)
        {
            return Name == other.Name && Equals(Nationality, other.Nationality);
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != this.GetType()) return false;
            return Equals((Author) obj);
        }

        public override int GetHashCode() => HashCode.Combine(Name, Nationality);
    }
}