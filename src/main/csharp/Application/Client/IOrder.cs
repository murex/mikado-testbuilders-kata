using Application.Domain.Book;
using Application.Purchase;

namespace Application.Client
{
    public interface IOrder
    {
        void AddBook(IBook book, int quantity);

        Invoice CheckOut();

        int GetQuantityOf(IBook book);
    }
}