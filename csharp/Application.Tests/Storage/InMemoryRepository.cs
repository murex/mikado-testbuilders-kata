/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

using System.Collections.Generic;
using Application.Purchase;
using Application.Storage;

namespace Application.Tests.Storage
{
    public class InMemoryRepository : IRepository
    {
        private readonly Dictionary<int, Invoice> _invoiceMap;

        public InMemoryRepository()
        {
           _invoiceMap = new Dictionary<int, Invoice>();
        }

        public void AddInvoice(Invoice invoice)
        {
            _invoiceMap.Add(invoice.Id, invoice);
        }

        public Dictionary<int, Invoice> GetInvoiceMap() => _invoiceMap;
    }
}
