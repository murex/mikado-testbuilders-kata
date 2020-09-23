using Application.Domain.Book;
using Application.Domain.Country;
using Application.Storage;
using Xunit;
using static Application.Domain.Book.Genre;

namespace Application.Tests
{
    public class JsonRepositoryTests
    {
        [Fact]
        public void JsonDeserializationIsWorking()
        {
            var repository = new JsonRepository();
            Assert.Equal(6, repository.Records.Length);
            
            Assert.Equal(123, repository.Records[0].Id);
            Assert.Equal(Language.English, repository.Records[0].Country.Language);
            Assert.Equal(Currency.UsDollar, repository.Records[0].Country._Currency);

            Assert.Equal(Language.English, repository.Records[0].BooksInBasket[0].Language);
            Assert.Equal(Category.Language, repository.Records[0].BooksInBasket[0].Category);

            Assert.Empty(repository.Records[0].BooksInBasket[0].Genre);
            Assert.Contains(Mystery, repository.Records[0].BooksInBasket[1]._Genre);
        }
    }
}