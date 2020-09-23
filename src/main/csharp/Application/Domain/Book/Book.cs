using Application.Domain.Country;

namespace Application.Domain.Book
{
    public interface IBook
    {
        string Name { get; }
        double Price { get; }
        Author Author { get; }
        Language Language { get; }
    }
}