package com.murex.tbw.client;

import com.murex.tbw.domain.book.Book;
import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.CountryBuilder;
import com.murex.tbw.purchase.Invoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.murex.tbw.domain.book.builders.EducationalBookBuilder.newEducationalBookBuilder;
import static com.murex.tbw.domain.book.builders.NovelBuilder.newNovelBuilder;
import static com.murex.tbw.domain.country.Currency.EURO;
import static com.murex.tbw.domain.country.Language.FRENCH;
import static com.murex.tbw.purchase.PurchasedBookBuilder.newPurchasedBookBuilder;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class BooksOrderTest {

    private Order booksOrder;
    private Book novelA;
    private Book englishBook;
    private Client clientA;
    private Country france;

    @BeforeEach
    public void
    setUp() {
        france = CountryBuilder.newCountryBuilder()
                .setCountryName("France")
                .setLanguage(FRENCH)
                .setCurrency(EURO)
                .createCountry();
        clientA = new Client("User_A", france);
        booksOrder = new BooksOrder(clientA);
        novelA = newNovelBuilder()
                .setName("NovelA")
                .setPrice(10.0)
                .createNovel();

        englishBook = newEducationalBookBuilder()
                .setName("English Language")
                .setPrice(20.5)
                .createEducationalBook();
    }

    @Test
    public void
    AddingNewBooksToTheBasket_ShouldAddNewBooksToTheHashMap() {
        booksOrder.addBook(novelA, 1);

        assertEquals((Integer) 1, booksOrder.getQuantityOf(novelA));
    }

    @Test
    public void
    AddingMoreQuantityOfExistingBooks_ShouldIncrementTheExistingQuantity() {
        booksOrder.addBook(novelA, 1);
        booksOrder.addBook(englishBook, 3);
        booksOrder.addBook(novelA, 4);

        assertEquals((Integer) 5, booksOrder.getQuantityOf(novelA));
    }

    @Test
    public void
    CallingCheckOut_ShouldGenerateAnInvoiceOfAllBooksInTheBasket() {
        booksOrder.addBook(novelA, 1);
        booksOrder.addBook(englishBook, 3);
        booksOrder.addBook(novelA, 4);

        Invoice invoice = booksOrder.checkOut();
        assertIterableEquals(
                asList(
                        newPurchasedBookBuilder()
                                .setBook(englishBook)
                                .setQuantity(3)
                                .createPurchasedBook(),
                        newPurchasedBookBuilder()
                                .setBook(novelA)
                                .setQuantity(5)
                                .createPurchasedBook()),
                invoice.getPurchasedBooks());
    }
}