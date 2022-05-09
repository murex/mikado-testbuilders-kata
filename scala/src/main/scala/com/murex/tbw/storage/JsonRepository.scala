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

package com.murex.tbw.storage

import com.google.gson.stream.JsonReader
import com.murex.tbw.domain.book.Categories.Category
import com.murex.tbw.domain.book.Genres.Genre
import com.murex.tbw.domain.book._
import com.murex.tbw.domain.country.Currencies.Currency
import com.murex.tbw.domain.country.Languages.Language
import com.murex.tbw.domain.country.{Country, Currencies, Languages}
import com.murex.tbw.purchase.{Invoice, PurchasedBook}
import com.murex.tbw.storage.JsonRepository.REPOSITORY_FILE

import java.io.{BufferedReader, IOException, InputStreamReader}
import scala.collection.mutable

class JsonRepository extends Repository {
  private val invoiceMap: scala.collection.mutable.Map[Int, Invoice] =
    scala.collection.mutable.Map[Int, Invoice]()

  loadJsonData(getJsonReader)

  override def addInvoice(invoice: Invoice): Unit = invoiceMap(invoice.id) = invoice

  override def getInvoiceMap: Map[Int, Invoice] = invoiceMap.toMap

  private def getJsonReader: JsonReader = {
    try {
      val resourceAsStream = this.getClass.getResourceAsStream(s"/$REPOSITORY_FILE")
      new JsonReader(new BufferedReader(new InputStreamReader(resourceAsStream)))
    } catch {
      case exp: Exception =>
        printFileNotFoundException(exp)
        throw exp
    }
  }

  private def loadJsonData(jsonReader: JsonReader): Unit = {
    try {
      jsonReader.beginArray()
      while (jsonReader.hasNext) {
        addInvoice(parseInvoiceDetails(jsonReader))
      }
      jsonReader.endArray()
    } catch {
      case exp: IOException => println(exp)
    }
  }

  def parseInvoiceDetails(jsonReader: JsonReader): Invoice = {
    jsonReader.beginObject()

    var id = 0
    var clientName: String = ""
    var invoice: Invoice = null

    while (jsonReader.hasNext) {
      jsonReader.nextName() match {
        case "id"      => id = jsonReader.nextInt()
        case "client"  => clientName = jsonReader.nextString()
        case "country" => invoice = new Invoice(clientName, parseCountryDetails(jsonReader), id)
        case "booksInBasket" =>
          jsonReader.beginArray()
          while (jsonReader.hasNext) {
            invoice.addBook(parsePurchasedBookDetails(jsonReader))
          }
          jsonReader.endArray()
      }
    }
    jsonReader.endObject()
    invoice
  }

  def parsePurchasedBookDetails(jsonReader: JsonReader): PurchasedBook = {
    jsonReader.beginObject()

    var price = 0.0
    var quantity = 0
    var bookCategory: Category = null
    val genres: mutable.MutableList[Genre] = mutable.MutableList.empty

    var bookName: String = ""
    var author: Author = null
    var bookLanguage: Language = null

    while (jsonReader.hasNext) {
      jsonReader.nextName() match {
        case "name"     => bookName = jsonReader.nextString()
        case "price"    => price = jsonReader.nextDouble()
        case "language" => bookLanguage = Languages.withName(jsonReader.nextString())
        case "quantity" => quantity = jsonReader.nextInt()
        case "category" => bookCategory = Categories.withName(jsonReader.nextString())
        case "author"   => author = parseAuthorDetails(jsonReader)
        case "genre" =>
          jsonReader.beginArray()
          while (jsonReader.hasNext) {
            Genres.withName(jsonReader.nextString()) +=: genres
          }
          jsonReader.endArray()
      }
    }

    val book: Book =
      if (bookCategory != null) {
        EducationalBook(bookName, price, author, bookLanguage, bookCategory)
      } else {
        Novel(bookName, price, author, bookLanguage, genres.toList)
      }

    jsonReader.endObject()
    new PurchasedBook(book, quantity)
  }

  def parseAuthorDetails(jsonReader: JsonReader): Author = {
    jsonReader.beginObject()

    var authorName: String = ""
    var authorNationality: Country = null

    while (jsonReader.hasNext) {
      jsonReader.nextName() match {
        case "name"        => authorName = jsonReader.nextString()
        case "nationality" => authorNationality = parseCountryDetails(jsonReader)
      }
    }
    jsonReader.endObject()
    Author(authorName, authorNationality)
  }

  def parseCountryDetails(jsonReader: JsonReader): Country = {
    jsonReader.beginObject()

    var countryName: String = ""
    var language: Language = null
    var currency: Currency = null

    while (jsonReader.hasNext) {
      jsonReader.nextName() match {
        case "name" =>
          countryName = jsonReader.nextString()
        case "language" => language = Languages.withName(jsonReader.nextString())
        case "currency" => currency = Currencies.withName(jsonReader.nextString())
      }
    }
    jsonReader.endObject()
    Country(countryName, currency, language)
  }

  private def printFileNotFoundException(exp: Exception): Unit = {
    println("*********************WARNING*********************")
    System.out.printf("Error reading the file '%s'%s", REPOSITORY_FILE, ".\n")
    println(exp)
    println("*************************************************")
    println("\n\n")
  }
}

object JsonRepository {
  private val REPOSITORY_FILE = "repository.json"
}
