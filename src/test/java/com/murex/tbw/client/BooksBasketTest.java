package com.murex.tbw.client;

import com.murex.tbw.domain.book.Book;
import com.murex.tbw.purchase.Invoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.murex.tbw.domain.book.builders.EducationalBookBuilder.newEducationalBookBuilder;
import static com.murex.tbw.domain.book.builders.NovelBuilder.newNovelBuilder;
import static com.murex.tbw.purchase.PurchasedBookBuilder.newPurchasedBookBuilder;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class BooksBasketTest {

    private Basket booksBasket;
    private Book novelA;
    private Book englishBook;
    private Client clientA;

    @BeforeEach
    public void
    setUp() {
        clientA = new Client("User_A");
        booksBasket = new BooksBasket(clientA);
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
        booksBasket.addBook(novelA, 1);

        assertEquals((Integer) 1, booksBasket.getQuantityOf(novelA));
    }

    @Test
    public void
    AddingMoreQuantityOfExistingBooks_ShouldIncrementTheExistingQuantity() {
        booksBasket.addBook(novelA, 1);
        booksBasket.addBook(englishBook, 3);
        booksBasket.addBook(novelA, 4);

        assertEquals((Integer) 5, booksBasket.getQuantityOf(novelA));
    }

    @Test
    public void
    CallingCheckOut_ShouldGenerateAnInvoiceOfAllBooksInTheBasket() {
        booksBasket.addBook(novelA, 1);
        booksBasket.addBook(englishBook, 3);
        booksBasket.addBook(novelA, 4);

        Invoice invoice = booksBasket.checkOut();
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