package com.murex.tbw.report;

import com.murex.tbw.client.BooksOrder;
import com.murex.tbw.client.Client;
import com.murex.tbw.domain.book.*;
import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Currency;
import com.murex.tbw.domain.country.Language;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.murex.tbw.MainRepository.configuredRepository;

public class ReportGeneratorTest {

    @Test
    public void
    ReportGeneratorShouldSumTheTotalOfAllInvoices() {
        Country usa = new Country("USA", Currency.US_DOLLAR, Language.ENGLISH);
        BooksOrder clientABasket = new BooksOrder(new Client("ClientA", usa));
        BooksOrder clientBBasket = new BooksOrder(new Client("ClientB", usa));

        Author authorA = new Author("Author_A", usa);
        Book englishBook = new EducationalBook("English for Beginners", 35.5, authorA, Language.ENGLISH, Category.LANGUAGE);

        Country germany = new Country("Germany", Currency.EURO, Language.GERMAN);
        Author franzKafka = new Author("Franz Kafka", germany);
        Book theTrial = new Novel("The Trial", 15d, franzKafka, Language.ENGLISH, Arrays.asList(Genre.MYSTERY));

        clientABasket.addBook(englishBook, 1);
        clientABasket.addBook(theTrial, 2);
        clientBBasket.addBook(theTrial, 1);

        clientABasket.checkOut();
        clientBBasket.checkOut();

        ReportGenerator reportGenerator = new ReportGenerator(configuredRepository());
        Assertions.assertEquals(80.5d, reportGenerator.getTotalAmount());
    }
}