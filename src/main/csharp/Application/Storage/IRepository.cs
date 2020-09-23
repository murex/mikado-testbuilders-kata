using System.Collections.Generic;
using Application.Purchase;

namespace Application.Storage
{
    public interface IRepository
    {
        void AddInvoice(Invoice invoice);

        Dictionary<int, Invoice> GetInvoiceMap();
    }
}