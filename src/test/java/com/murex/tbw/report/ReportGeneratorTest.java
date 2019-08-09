package com.murex.tbw.report;

import com.murex.tbw.domain.country.Country;
import com.murex.tbw.purchase.Invoice;
import com.murex.tbw.storage.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.murex.tbw.MainRepository.configuredRepository;
import static com.murex.tbw.domain.book.builders.AuthorBuilder.newAuthorBuilder;
import static com.murex.tbw.domain.book.builders.EducationalBookBuilder.newEducationalBookBuilder;
import static com.murex.tbw.domain.country.CountryBuilder.newCountryBuilder;
import static com.murex.tbw.domain.country.Currency.EURO;
import static com.murex.tbw.domain.country.Currency.US_DOLLAR;
import static com.murex.tbw.purchase.InvoiceBuilder.newInvoiceBuilder;
import static com.murex.tbw.purchase.PurchasedBookBuilder.newPurchasedBookBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportGeneratorTest {
    private static final Country GERMANY = newCountryBuilder()
            .setCountryName("Germany")
            .setCurrency(EURO)
            .createCountry();
    private static final Country USA = newCountryBuilder()
            .setCountryName("USA")
            .setCurrency(US_DOLLAR)
            .createCountry();
    private Repository repository;

    @BeforeEach
    public void
    setup() {
        repository = configuredRepository();

        Invoice invoiceUS = newInvoiceBuilder()
                .setCountry(USA)
                .addBook(
                        newPurchasedBookBuilder()
                                .setQuantity(1)
                                .setBook(
                                        newEducationalBookBuilder()
                                                .setPrice(35.5d)
                                                .createEducationalBook()
                                ).createPurchasedBook()
                ).createInvoice();


        Invoice invoiceGermany = newInvoiceBuilder()
                .setCountry(GERMANY)
                .addBook(
                        newPurchasedBookBuilder()
                                .setQuantity(1)
                                .setBook(
                                        newEducationalBookBuilder()
                                                .setPrice(40.0d)
                                                .setAuthor(newAuthorBuilder().setNationality(GERMANY).createAuthor())
                                                .createEducationalBook()
                                ).createPurchasedBook()
                ).createInvoice();
        repository.addInvoice(invoiceUS);
        repository.addInvoice(invoiceGermany);
    }

    @Test
    public void
    The_Report_Should_Convert_The_Total_Amount_To_USD() {
        ReportGenerator reportGenerator = new ReportGenerator(configuredRepository());
        assertEquals(81.1, reportGenerator.getTotalAmount());
    }
}