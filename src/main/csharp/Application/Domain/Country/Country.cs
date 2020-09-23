using System;

namespace Application.Domain.Country
{
    public sealed class Country
    {
        public string Name { get; }
        public Currency Currency { get; }
        public Language Language { get; }

        public Country(string name, Currency currency, Language language)
        {
            Name = name;
            Currency = currency;
            Language = language;
        }

        public override string ToString()
            => $"Country [ {nameof(Name)}: '{Name}'" +
               $", {nameof(Currency)}: '{Currency}'" +
               $", {nameof(Language)}: '{Language}' ]";

        protected bool Equals(Country other)
        {
            return Name == other.Name
                   && Currency == other.Currency
                   && Language == other.Language;
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != this.GetType()) return false;
            return Equals((Country) obj);
        }

        public override int GetHashCode()
        {
            return HashCode.Combine(Name, (int) Currency, (int) Language);
        }
    }
}