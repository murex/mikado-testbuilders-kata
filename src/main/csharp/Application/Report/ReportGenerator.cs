using System.Collections.Generic;
using System.Linq;
using Application.Purchase;
using Application.Storage;

namespace Application.Report
{
    public class ReportGenerator
    {
        private readonly IRepository _repository = MainRepository.ConfiguredRepository;

        public double GetTotalAmount()
        {
            var invoices = _repository.GetInvoiceMap().Values;
            var totalAmount = invoices.Sum(invoice => invoice.ComputeTotalAmount());
            return totalAmount;
        }

        public int GetTotalSoldBooks()
        {
            var invoices = _repository.GetInvoiceMap().Values;
            var totalSoldBooks = invoices
                .Sum(invoice => invoice.PurchasedBooks.Sum(purchasedBook => purchasedBook.Quantity));

            return totalSoldBooks;
        }

        public long GetNumberOfIssuedInvoices() => _repository.GetInvoiceMap().Count;
    }
}