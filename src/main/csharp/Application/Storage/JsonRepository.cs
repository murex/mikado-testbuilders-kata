using System;
using System.Collections.Generic;
using System.Data;
using System.Diagnostics.CodeAnalysis;
using System.IO;
using System.Linq;
using System.Text.Json;
using System.Text.Json.Serialization;
using Application.Domain.Book;
using Application.Domain.Country;
using Application.Purchase;
using static Application.Domain.Book.Genre;
using static Application.Domain.Country.Currency;

namespace Application.Storage
{
    public sealed class JsonRepository : IRepository
    {
        public Dictionary<int, Invoice> Invoices { get; }

        public JsonRepository()
        {
            Invoices = new Dictionary<int, Invoice>();
            LoadJsonData();
        }

        private void LoadJsonData()
        {
            var records = JsonSerializer.Deserialize<Record[]>(
                File.ReadAllText("../../../../../../main/resources/repository.json"),
                new JsonSerializerOptions()
                {
                    PropertyNameCaseInsensitive = true,
                    Converters = {new JsonStringEnumConverter()}
                });

            foreach (var record in records)
            {
                var invoice = new Invoice(
                    record.Id,
                    record.Client,
                    record.Country.ToDomain());

                var purchasedBooks = record.BooksInBasket
                    .Select(b =>
                    {
                        IBook book = b.Category.HasValue
                            ? (IBook) new EducationalBook(b.Name, b.Price, b.Author.ToDomain(), b.Language,
                                b.Category.Value)
                            : (IBook) new Novel(b.Name, b.Price, b.Author.ToDomain(), b.Language, b._Genre);


                        return new PurchasedBook(book, b.Quantity);
                    })
                    .ToList();

                invoice.AddPurchasedBooks(purchasedBooks);

                AddInvoice(invoice);
            }
        }

        public void AddInvoice(Invoice invoice)
        {
            Invoices.Add(invoice.Id, invoice);
        }

        public Dictionary<int, Invoice> GetInvoiceMap() => Invoices;

        public class Record
        {
            public int Id { get; set; }
            public string Client { get; set; }
            public Country Country { get; set; }
            public BookInBasket[] BooksInBasket { get; set; }
        }

        public class Country
        {
            public string Name { get; set; }
            public Language Language { get; set; }
            public string Currency { get; set; }

            public Currency _Currency => Convert.ToCurrency(Currency);

            public Domain.Country.Country ToDomain() => new Domain.Country.Country(Name, _Currency, Language);
        }

        public class BookInBasket
        {
            public string Name { get; set; }
            public float Price { get; set; }
            public int Quantity { get; set; }
            public Language Language { get; set; }
            public Category? Category { get; set; }
            public Author Author { get; set; }
            public string[] Genre { get; set; } = new string[0];

            public List<Genre> _Genre => Convert.ToGenre(Genre);
        }

        public class Author
        {
            public string Name { get; set; }
            public Nationality Nationality { get; set; }

            public Domain.Book.Author ToDomain() => new Domain.Book.Author(Name, Nationality.ToCountry());
        }

        public class Nationality
        {
            public string Name { get; set; }
            public Language Language { get; set; }
            public string Currency { get; set; }
            public Currency _Currency => Convert.ToCurrency(Currency);

            public Domain.Country.Country ToCountry() => new Domain.Country.Country(Name, _Currency, Language);
        }

        public class Convert
        {
            private static readonly Dictionary<string, Currency> CurrencyByName = new Dictionary<string, Currency>
            {
                {"US_DOLLAR", UsDollar},
                {"EURO", Euro},
                {"RENMINBI", Renminbi},
                {"POUND_STERLING", PoundSterling},
            };

            public static Currency ToCurrency(string currency) => CurrencyByName[currency];

            private static readonly Dictionary<string, Genre> Mapping = new Dictionary<string, Genre>
            {
                {"HORROR_FICTION", HorrorFiction},
                {"THRILLER", Thriller},
                {"DARK_FANTASY", DarkFantasy},
                {"MYSTERY", Mystery},
                {"ADVENTURE_FICTION", AdventureFiction},
                {"NON_FICTION", NonFiction},
                {"ROMANCE", Romance},
            };

            public static List<Genre> ToGenre(string[] g) => g.Select(g => Mapping[g]).ToList();
        }
    }
}