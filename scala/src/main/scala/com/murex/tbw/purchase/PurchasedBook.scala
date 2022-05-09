package com.murex.tbw.purchase

import com.murex.tbw.domain.book.Book

class PurchasedBook(val book: Book, val quantity: Int) {
  def getTotalPrice: Double = book.price * quantity

  override def equals(other: Any): Boolean = {
    if (this eq other.asInstanceOf[AnyRef]) return true
    if (getClass != other.getClass) return false

    val otherBook = other.asInstanceOf[PurchasedBook]

    if (book != otherBook.book) return false
    if (quantity != otherBook.quantity) return false

    true
  }

  override def hashCode(): Int = {
    var result = book.hashCode()
    result = 31 * result + quantity
    result
  }

  override def toString: String = s"PurchasedBook(book=$book, quantity=$quantity)"
}
