package com.murex.tbw.storage

import com.murex.tbw.purchase.Invoice

trait Repository {
  def addInvoice(invoice: Invoice): Unit
  def getInvoiceMap: Map[Int, Invoice]
}
