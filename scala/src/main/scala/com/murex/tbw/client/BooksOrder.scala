package com.murex.tbw.client

import com.murex.tbw.MainRepository
import com.murex.tbw.domain.book.Book
import com.murex.tbw.purchase.{Invoice, PurchasedBook}

class BooksOrder(private val client: Client) extends Order {
  private val booksInBasket: scala.collection.mutable.Map[Book, Int] =
    scala.collection.mutable.Map[Book, Int]()

  override def addBook(book: Book, quantity: Int): Unit = {
    booksInBasket(book) = quantity
  }

  override def checkOut(): Invoice = {
    val invoice = new Invoice(client.name, client.country)
    booksInBasket.foreach {
      case (book, quantity) => invoice.addBook(new PurchasedBook(book, quantity))
    }
    MainRepository.configuredRepository().addInvoice(invoice)
    invoice
  }

  override def getQuantityOf(book: Book): Int = booksInBasket.getOrElse(book, 0)
}
