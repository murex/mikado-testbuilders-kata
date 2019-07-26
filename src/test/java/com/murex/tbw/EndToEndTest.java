package com.murex.tbw;

import com.murex.tbw.client.BooksBasket;
import com.murex.tbw.client.Client;
import com.murex.tbw.domain.book.*;
import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Currency;
import com.murex.tbw.domain.country.Language;
import com.murex.tbw.report.ReportGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.murex.tbw.MainRepository.configuredRepository;

public class EndToEndTest {
    @Test
    public void
    EndToEndTest() {
        Country usa = new Country("USA", Currency.US_DOLLAR, Language.ENGLISH);
        Country germany = new Country("Germany", Currency.EURO, Language.GERMAN);

        Author authorA = new Author("Author_A", "AuthorA@english.com", usa);
        Author franzKafka = new Author("Franz Kafka", "Franz.Kafka@novel.com", germany);

        Book englishBook = new EducationalBook("English for Beginners", 35.5, authorA, Language.ENGLISH, Category.LANGUAGE);
        Book theTrial = new Novel("The Trial", 15d, franzKafka, Language.ENGLISH, Arrays.asList(Genre.MYSTERY));

        BooksBasket usClient = new BooksBasket(new Client("ClientA", usa));
        BooksBasket germanyClient = new BooksBasket(new Client("ClientB", germany));

        usClient.addBook(englishBook, 1);
        usClient.addBook(theTrial, 2);
        germanyClient.addBook(theTrial, 1);

        usClient.checkOut();
        germanyClient.checkOut();

        ReportGenerator reportGenerator = new ReportGenerator(configuredRepository());
        Assertions.assertEquals(83.455d, reportGenerator.getTotalCost());
    }
}
