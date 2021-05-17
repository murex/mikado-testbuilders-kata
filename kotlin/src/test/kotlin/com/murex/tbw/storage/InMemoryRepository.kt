package com.murex.tbw.storage

import com.murex.tbw.purchase.Invoice

class InMemoryRepository : Repository {
    private var invoiceMap: MutableMap<Int, Invoice> = HashMap()

    override fun addInvoice(invoice: Invoice) {
        invoiceMap[invoice.id] = invoice
    }

    override fun getInvoiceMap(): Map<Int, Invoice> {
        return invoiceMap
    }
}