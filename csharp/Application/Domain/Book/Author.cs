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

namespace Application.Domain.Book
{
    public sealed class Author
    {
        public string Name { get; }
        public Country.Country Nationality { get; }

        public Author(string name, Country.Country nationality)
        {
            Name = name;
            Nationality = nationality;
        }

        public override string ToString() => $"Author [ {nameof(Name)}: '{Name}', " +
                                             $"{nameof(Nationality)}: '{Nationality}' ]";

        private bool Equals(Author other) => Name == other.Name
                                             && Equals(Nationality, other.Nationality);

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
