/*******************************************************************************
 *
 * Copyright (c) {2003-2021} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.storage

import com.google.gson.stream.JsonReader
import com.murex.tbw.domain.book.*
import com.murex.tbw.domain.country.Country
import com.murex.tbw.domain.country.Currency
import com.murex.tbw.domain.country.Language
import com.murex.tbw.purchase.Invoice
import com.murex.tbw.purchase.PurchasedBook
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import kotlin.system.exitProcess

class JsonRepository : Repository {

    private val invoiceMap: HashMap<Int, Invoice> = HashMap()

    init {
        loadJsonData(getJsonReader())
    }

    override fun addInvoice(invoice: Invoice) {
        invoiceMap[invoice.id] = invoice
    }

    override fun getInvoiceMap(): Map<Int, Invoice> {
        return invoiceMap
    }

    private fun getJsonReader(): JsonReader {
        try {
            val resourceAsStream = this.javaClass.getResourceAsStream("/$REPOSITORY_FILE")
            return JsonReader(BufferedReader(InputStreamReader(resourceAsStream)))
        } catch (exp: Exception) {
            printFileNotFoundException(exp)
        }
        exitProcess(0)
    }

    private fun loadJsonData(jsonReader: JsonReader) {
        try {
            jsonReader.beginArray()
            while (jsonReader.hasNext()) {
                addInvoice(parseInvoiceDetails(jsonReader))
            }
            jsonReader.endArray()
        } catch (exp: IOException) {
            println(exp)
        }
    }

    private fun parseInvoiceDetails(jsonReader: JsonReader): Invoice {
        jsonReader.beginObject()

        var id = 0
        lateinit var clientName: String
        lateinit var invoice: Invoice
        while (jsonReader.hasNext()) {
            when (jsonReader.nextName()) {
                "id" -> {
                    id = jsonReader.nextInt()
                }
                "client" -> {
                    clientName = jsonReader.nextString()
                }
                "country" -> {
                    invoice = Invoice(clientName, parseCountryDetails(jsonReader), id)
                }
                "booksInBasket" -> {
                    jsonReader.beginArray()
                    while (jsonReader.hasNext()) {
                        invoice.addBook(parsePurchasedBookDetails(jsonReader))
                    }
                    jsonReader.endArray()
                }
            }
        }
        jsonReader.endObject()

        return invoice
    }

    private fun parsePurchasedBookDetails(jsonReader: JsonReader): PurchasedBook {
        jsonReader.beginObject()

        var price = 0.0
        var quantity = 0
        var bookCategory: Category? = null
        val genres: ArrayList<Genre> = ArrayList()

        lateinit var bookName: String
        lateinit var author: Author
        lateinit var bookLanguage: Language

        while (jsonReader.hasNext()) {
            when (jsonReader.nextName()) {
                "name" -> {
                    bookName = jsonReader.nextString()
                }
                "price" -> {
                    price = jsonReader.nextDouble()
                }
                "language" -> {
                    bookLanguage = Language.valueOf(jsonReader.nextString())
                }
                "quantity" -> {
                    quantity = jsonReader.nextInt()
                }
                "category" -> {
                    bookCategory = Category.valueOf(jsonReader.nextString())
                }
                "author" -> {
                    author = parseAuthorDetails(jsonReader)
                }
                "genre" -> {
                    jsonReader.beginArray()
                    while (jsonReader.hasNext()) {
                        genres.add(Genre.valueOf(jsonReader.nextString()))
                    }
                    jsonReader.endArray()
                }
            }
        }

        val book: Book = if (bookCategory != null) {
            EducationalBook(bookName, price, author, bookLanguage, bookCategory)
        } else {
            Novel(bookName, price, author, bookLanguage, genres)
        }

        jsonReader.endObject()

        return PurchasedBook(book, quantity)
    }

    private fun parseAuthorDetails(jsonReader: JsonReader): Author {
        jsonReader.beginObject()

        lateinit var authorName: String
        lateinit var authorNationality: Country

        while (jsonReader.hasNext()) {
            when (jsonReader.nextName()) {
                "name" -> {
                    authorName = jsonReader.nextString()
                }
                "nationality" -> {
                    authorNationality = parseCountryDetails(jsonReader)
                }
            }
        }
        jsonReader.endObject()

        return Author(authorName, authorNationality)
    }

    private fun parseCountryDetails(jsonReader: JsonReader): Country {
        jsonReader.beginObject()

        lateinit var countryName: String
        lateinit var language: Language
        lateinit var currency: Currency

        while (jsonReader.hasNext()) {
            when (jsonReader.nextName()) {
                "name" -> {
                    countryName = jsonReader.nextString()
                }
                "language" -> {
                    language = Language.valueOf(jsonReader.nextString())
                }
                "currency" -> {
                    currency = Currency.valueOf(jsonReader.nextString())
                }
            }
        }
        jsonReader.endObject()

        return Country(countryName, currency, language)
    }

    private fun printFileNotFoundException(exp: Exception) {
        println("*********************WARNING*********************")
        System.out.printf("Error reading the file '%s'%s", REPOSITORY_FILE, ".\n")
        println(exp)
        println("*************************************************")
        println("\n\n")
    }

    companion object {
        private const val REPOSITORY_FILE = "repository.json"
    }
}