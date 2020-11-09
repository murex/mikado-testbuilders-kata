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

        public override string ToString() => $"Country [ {nameof(Name)}: '{Name}'" +
                                             $", {nameof(Currency)}: '{Currency}'" +
                                             $", {nameof(Language)}: '{Language}' ]";

        private bool Equals(Country other) => Name == other.Name
                                              && Currency == other.Currency
                                              && Language == other.Language;

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != this.GetType()) return false;
            return Equals((Country) obj);
        }

        public override int GetHashCode() => HashCode.Combine(Name, (int) Currency, (int) Language);
    }
}
