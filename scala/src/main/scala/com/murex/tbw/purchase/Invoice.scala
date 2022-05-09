/*
 * ******************************************************************************
 *  *
 *  * Copyright (c) {2003-2022} Murex S.A.S. and its affiliates.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the MIT License
 *  * which accompanies this distribution, and is available at
 *  * https://opensource.org/licenses/MIT
 *  *
 *  ******************************************************************************
 */

package com.murex.tbw.purchase

import com.murex.tbw.IdGenerator
import com.murex.tbw.domain.country.Country
import com.murex.tbw.finance.TaxRulesOperations.getApplicableRate

import scala.collection.mutable

class Invoice(
    val clientName: String,
    val country: Country,
    val id: Int = IdGenerator.nextId()
) {
  private val purchasedBooks: mutable.MutableList[PurchasedBook] = mutable.MutableList.empty

  def addBook(book: PurchasedBook): Unit = book +=: purchasedBooks

  def getPurchasedBooks: List[PurchasedBook] = purchasedBooks.toList

  def computeTotalAmount: Double = {
    var sum = 0.0

    for (purchasedBook <- purchasedBooks) {
      // BUG: There was a bug with the below line of code
      // val totalPrice: Double = purchasedBook.getTotalPrice()

      // FIX: The above bug was fixed by the below line
      val totalPrice: Double =
        purchasedBook.getTotalPrice * getApplicableRate(country, purchasedBook.book)
      sum += totalPrice
    }
    sum
  }

  override def equals(other: Any): Boolean = {
    if (this eq other.asInstanceOf[AnyRef]) return true
    if (this.getClass != other.getClass) return false

    val otherInvoice = other.asInstanceOf[Invoice]

    if (clientName != otherInvoice.clientName) return false
    if (country != otherInvoice.country) return false
    if (id != otherInvoice.id) return false
    if (purchasedBooks != otherInvoice.purchasedBooks) return false

    true
  }

  override def hashCode(): Int = {
    var result = clientName.hashCode()
    result = 31 * result + country.hashCode()
    result = 31 * result + id
    result = 31 * result + purchasedBooks.hashCode()
    result
  }

  override def toString: String =
    s"Invoice(clientName='$clientName', country=$country, id=$id, purchasedBooks=$purchasedBooks)"
}
