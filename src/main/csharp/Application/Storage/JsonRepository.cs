using System.Collections.Generic;
using Application.Purchase;

namespace Application.Storage
{
    public sealed class JsonRepository : IRepository
    {
        public void AddInvoice(Invoice invoice)
        {
            
        }

        public Dictionary<int, Invoice> GetInvoiceMap()
        {
            return new Dictionary<int, Invoice>();
        }
    }
}