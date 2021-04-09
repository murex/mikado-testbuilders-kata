/*******************************************************************************
 *
 * Copyright (c) {2003-2021} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.client

import com.murex.tbw.domain.book.Author
import com.murex.tbw.domain.book.Novel
import com.murex.tbw.domain.country.Country
import com.murex.tbw.domain.country.Currency
import com.murex.tbw.domain.country.Currency.EURO
import com.murex.tbw.domain.country.Language
import com.murex.tbw.domain.country.Language.GERMAN
import com.murex.tbw.purchase.Invoice
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BooksOrderTest {
    private val germany = Country("Germany", EURO, GERMAN)
    private val grass = Author("Gunter Grass", germany)
    private val theTinDrum = Novel("The Tin Drum", 20.0, grass, GERMAN, emptyList())

    private val usa = Country("USA", Currency.US_DOLLAR, Language.ENGLISH)

    @Test
    fun theQuantityOfUnAddedBookShouldBe0() {
        val client = Client("Client A", usa)
        val order = BooksOrder(client)

        assertEquals(0, order.getQuantityOf(theTinDrum))
    }

    @Test
    fun whenAddedForTheFirstTimeTheQuantityShouldBeMaintained() {
        val client = Client("Client A", usa)
        val order = BooksOrder(client)
        order.addBook(theTinDrum, 2)

        assertEquals(2, order.getQuantityOf(theTinDrum))
    }

    @Test
    fun whenAddedMultipleTimesTheQuantitiesShouldBeAppended() {
        val client = Client("Client A", usa)
        val order = BooksOrder(client)
        order.addBook(theTinDrum, 2)
        order.addBook(theTinDrum, 3)

        assertEquals(5, order.getQuantityOf(theTinDrum))
    }
}