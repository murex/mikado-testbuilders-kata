/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package com.murex.tbw.storage;

import com.murex.tbw.purchase.Invoice;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository implements Repository {
    private final Map<Integer, Invoice> invoiceMap;

    public InMemoryRepository() {
        this.invoiceMap = new HashMap<>();
    }

    @Override
    public void addInvoice(Invoice invoice) {
        invoiceMap.put(invoice.getId(), invoice);
    }

    @Override
    public Map<Integer, Invoice> getInvoiceMap() {
        return invoiceMap;
    }


}
