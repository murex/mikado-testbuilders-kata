package com.murex.tbw.purchase

import com.murex.tbw.domain.book.Author
import com.murex.tbw.domain.book.Novel
import com.murex.tbw.domain.country.Country
import com.murex.tbw.domain.country.Currency
import com.murex.tbw.domain.country.Language
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class PurchasedBookTest {

    @Test
    fun theTotalPriceOfPurchasedBookIsThePriceTimesTheQuantity(){
        val germany = Country("Germany", Currency.EURO, Language.GERMAN)
        val grass = Author("Gunter Grass", germany)
        val theTinDrum = Novel("The Tin Drum", 20.0, grass, Language.GERMAN, emptyList())
        val purchasedBook = PurchasedBook(theTinDrum, 2)

        Assertions.assertEquals(40.0, purchasedBook.getTotalPrice())
    }

}