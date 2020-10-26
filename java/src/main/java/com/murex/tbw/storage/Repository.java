/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.storage;

import com.murex.tbw.purchase.Invoice;

import java.util.Map;

public interface Repository {
    void addInvoice(Invoice invoice);

    Map<Integer, Invoice> getInvoiceMap();
}
