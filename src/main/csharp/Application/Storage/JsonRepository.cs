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
        public Record[] Records { get; private set; }

        public JsonRepository()
        {
            LoadJsonData();
        }

        private void LoadJsonData()
        {
            Records = JsonSerializer.Deserialize<Record[]>(
                File.ReadAllText("../../../../../../main/resources/repository.json"),
                new JsonSerializerOptions()
                {
                    PropertyNameCaseInsensitive = true,
                    Converters = {new JsonStringEnumConverter()}
                });
        }

        public void AddInvoice(Invoice invoice)
        {
        }

        public Dictionary<int, Invoice> GetInvoiceMap()
        {
            return new Dictionary<int, Invoice>();
        }

        public class Record
        {
            public int Id { get; set; }
            public string Client { get; set; }
            public Country Country { get; set; }
            public BooksInBasket[] BooksInBasket { get; set; }
        }

        public class Country
        {
            public string Name { get; set; }
            public Language Language { get; set; }
            public string Currency { get; set; }

            public Currency _Currency => Convert.ToCurrency(Currency);
        }

        public class BooksInBasket
        {
            public string Name { get; set; }
            public float Price { get; set; }
            public int Quantity { get; set; }
            public Language Language { get; set; }
            public Category Category { get; set; }
            public Author Author { get; set; }
            public string[] Genre { get; set; } = new string[0];

            public List<Genre> _Genre => Convert.ToGenre(Genre);
        }

        public class Author
        {
            public string Name { get; set; }
            public Nationality Nationality { get; set; }
        }

        public class Nationality
        {
            public string Name { get; set; }
            public Language Language { get; set; }
            public string Currency { get; set; }
            public Currency _Currency => Convert.ToCurrency(Currency);
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