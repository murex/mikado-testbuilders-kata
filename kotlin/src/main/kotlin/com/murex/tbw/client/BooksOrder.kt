package com.murex.tbw.client

import com.murex.tbw.domain.book.Book
import com.murex.tbw.purchase.Invoice

class BooksOrder(val client: Client) : Order {
    private val booksInBasket: Map<Book, Int> = HashMap()

    override fun addBook(book: Book, quantity: Int) {
        TODO("Not yet implemented")
    }

    override fun checkOut(): Invoice {
        TODO("Not yet implemented")
    }

    override fun getQuantityOf(book: Book): Int? {
        TODO("Not yet implemented")
    }


}

