using System;
using Application.Domain.Country;

namespace Application.Client
{
    public class Client
    {
        public string Name { get; }
        public Country Country { get; }

        public Client(string name, Country country)
        {
            Name = name;
            Country = country;
        }

        public override string ToString()
            => $"Client [ {nameof(Name)}: '{Name}'" +
               $", {nameof(Country)}: '{Country}' ]";

        protected bool Equals(Client other)
        {
            return Name == other.Name 
                   && Equals(Country, other.Country);
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != this.GetType()) return false;
            return Equals((Client) obj);
        }

        public override int GetHashCode() => HashCode.Combine(Name, Country);
    }
}