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

        public override string ToString() => $"Novel [ {nameof(Name)}: '{Name}'" +
                                             $", {nameof(Price)}: '{Price}'" +
                                             $", {nameof(Author)}: '{Author}'" +
                                             $", {nameof(Language)}: '{Language}'" +
                                             $", {nameof(Genres)}: '{Genres}' ]";

        private bool Equals(Novel other) => Name == other.Name
                                            && Price.Equals(other.Price)
                                            && Equals(Author, other.Author)
                                            && Language == other.Language
                                            && Equals(Genres, other.Genres);

        public override bool Equals(object obj) => ReferenceEquals(this, obj)
                                                   || obj is Novel other && Equals(other);

        public override int GetHashCode() => HashCode.Combine(Name, Price, Author, (int) Language, Genres);
    }
}
