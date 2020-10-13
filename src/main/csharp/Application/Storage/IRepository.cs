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

namespace Application.Storage
{
    public interface IRepository
    {
        void AddInvoice(Invoice invoice);

        Dictionary<int, Invoice> GetInvoiceMap();
    }
}
