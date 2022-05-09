package com.murex.tbw.storage

import com.murex.tbw.purchase.Invoice

class InMemoryRepository extends Repository {
  private val invoiceMap: scala.collection.mutable.Map[Int, Invoice] =
    scala.collection.mutable.Map[Int, Invoice]()

  override def addInvoice(invoice: Invoice): Unit = invoiceMap(invoice.id) = invoice

  override def getInvoiceMap: Map[Int, Invoice] = invoiceMap.toMap
}
