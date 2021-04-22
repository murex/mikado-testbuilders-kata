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
            println("*********************WARNING*********************")
            System.out.printf("Error reading the file '%s'%s", REPOSITORY_FILE, ".\n")
            println(exp)
            println("*************************************************")
            println("\n\n")
        }
        exitProcess(0)
    }

    private fun loadJsonData(jsonReader: JsonReader) {
        try {
            jsonReader.beginArray()
            while (jsonReader.hasNext()) {
                lateinit var invoice: Invoice
                var clientName = ""
                var id: Int = 0
                var invoiceCountry: Country

                jsonReader.beginObject()
                while (jsonReader.hasNext()) {
                    val clientKeyName = jsonReader.nextName()
                    if (clientKeyName == "id") {
                        id = jsonReader.nextInt()
                    } else if (clientKeyName == "client") {
                        clientName = jsonReader.nextString()
                    } else if (clientKeyName == "country") {
                        jsonReader.beginObject()
                        var countryName = ""
                        var language: Language? = null
                        var currency: Currency? = null
                        while (jsonReader.hasNext()) {
                            val countryKeyName = jsonReader.nextName()
                            if (countryKeyName == "name") {
                                countryName = jsonReader.nextString()
                            } else if (countryKeyName == "language") {
                                language = Language.valueOf(jsonReader.nextString())
                            } else if (countryKeyName == "currency") {
                                currency = Currency.valueOf(jsonReader.nextString())
                            }
                        }
                        jsonReader.endObject()
                        invoiceCountry = Country(countryName, currency!!, language!!)
                        invoice = Invoice(clientName, invoiceCountry, id)
                    } else if (clientKeyName == "booksInBasket") {
                        jsonReader.beginArray()
                        while (jsonReader.hasNext()) {
                            var book: Book
                            var bookName = ""
                            var price = 0.0
                            var bookLanguage: Language? = null
                            var bookCategory: Category? = null
                            var author: Author? = null
                            var quantity = 0
                            val genres: ArrayList<Genre> = ArrayList()

                            jsonReader.beginObject()

                            while (jsonReader.hasNext()) {
                                val bookKeyName = jsonReader.nextName()
                                if (bookKeyName == "name") {
                                    bookName = jsonReader.nextString()
                                } else if (bookKeyName == "price") {
                                    price = jsonReader.nextDouble()
                                } else if (bookKeyName == "language") {
                                    bookLanguage = Language.valueOf(jsonReader.nextString())
                                } else if (bookKeyName == "quantity") {
                                    quantity = jsonReader.nextInt()
                                } else if (bookKeyName == "category") {
                                    bookCategory = Category.valueOf(jsonReader.nextString())
                                } else if (bookKeyName == "author") {
                                    jsonReader.beginObject()
                                    while (jsonReader.hasNext()) {
                                        val authorKeyName = jsonReader.nextName()
                                        var authorName: String? = ""
                                        var authorNationality: Country? = null
                                        if (authorKeyName == "name") {
                                            authorName = jsonReader.nextString()
                                        } else if (authorKeyName == "nationality") {
                                            jsonReader.beginObject()
                                            var countryName: String? = ""
                                            var countryLanguage: Language? = null
                                            var countryCurrency: Currency? = null
                                            while (jsonReader.hasNext()) {
                                                val authorNatKeyName = jsonReader.nextName()
                                                when (authorNatKeyName) {
                                                    "name" -> {
                                                        countryName = jsonReader.nextString()
                                                    }
                                                    "language" -> {
                                                        countryLanguage = Language.valueOf(jsonReader.nextString())
                                                    }
                                                    "currency" -> {
                                                        countryCurrency = Currency.valueOf(jsonReader.nextString())
                                                    }
                                                }
                                            }
                                            authorNationality = Country(
                                                countryName!!,
                                                countryCurrency!!, countryLanguage!!
                                            )
                                            jsonReader.endObject()
                                        }
                                        author = Author(authorName!!, authorNationality!!)
                                    }
                                    jsonReader.endObject()
                                } else if (bookKeyName == "genre") {
                                    jsonReader.beginArray()
                                    while (jsonReader.hasNext()) {
                                        genres.add(Genre.valueOf(jsonReader.nextString()))
                                    }
                                    jsonReader.endArray()
                                }
                            }

                            jsonReader.endObject()

                            book = if (bookCategory != null) {
                                EducationalBook(bookName, price, author!!, bookLanguage!!, bookCategory)
                            } else {
                                Novel(bookName, price, author!!, bookLanguage!!, genres)
                            }

                            invoice.addBook(PurchasedBook(book, quantity))
                        }
                        jsonReader.endArray()
                    }
                }
                addInvoice(invoice)
                jsonReader.endObject()
            }
            jsonReader.endArray()
        } catch (exp: IOException) {
            println(exp)
        }
    }

    companion object {
        private const val REPOSITORY_FILE = "repository.json"
    }
}