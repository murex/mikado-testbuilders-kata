package com.murex.tbw.client

import com.murex.tbw.domain.book.Book
import com.murex.tbw.purchase.Invoice

trait Order {
  def addBook(book: Book, quantity: Int): Unit
  def checkOut(): Invoice
  def getQuantityOf(book: Book): Int
}
