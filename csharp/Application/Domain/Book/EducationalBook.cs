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
using Application.Domain.Country;

namespace Application.Domain.Book
{
    public sealed class EducationalBook : IBook
    {
        public string Name { get; }
        public double Price { get; }
        public Author Author { get; }
        public Language Language { get; }
        public Category Category { get; }

        public EducationalBook(string name, double price, Author author, Language language, Category category)
        {
            Name = name;
            Price = price;
            Author = author;
            Language = language;
            Category = category;
        }

        public override string ToString() => $"EducationalBook [ {nameof(Name)}: {Name}" +
                                             $", {nameof(Price)}: '{Price}'" +
                                             $", {nameof(Author)}: '{Author}'" +
                                             $", {nameof(Language)}: '{Language}'" +
                                             $", {nameof(Category)}: '{Category}' ]";

        private bool Equals(EducationalBook other) => Name == other.Name
                                                      && Price.Equals(other.Price)
                                                      && Equals(Author, other.Author)
                                                      && Language == other.Language
                                                      && Category == other.Category;

        public override bool Equals(object obj) => ReferenceEquals(this, obj)
                                                   || obj is EducationalBook other && Equals(other);

        public override int GetHashCode() => HashCode.Combine(Name, Price, Author, (int) Language, (int) Category);
    }
}
