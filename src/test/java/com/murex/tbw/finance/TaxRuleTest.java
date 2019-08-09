package com.murex.tbw.finance;

import com.murex.tbw.domain.book.*;
import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Currency;
import com.murex.tbw.domain.country.Language;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.murex.tbw.domain.book.builders.AuthorBuilder.newAuthorBuilder;
import static com.murex.tbw.domain.book.builders.EducationalBookBuilder.newEducationalBookBuilder;
import static com.murex.tbw.domain.book.builders.NovelBuilder.newNovelBuilder;
import static com.murex.tbw.domain.country.CountryBuilder.newCountryBuilder;
import static com.murex.tbw.finance.TaxRule.getApplicableTax;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxRuleTest {

    @Test
    public void
    When_No_Tax_Rules_Apply_The_Tax_To_Be_Applied_Should_Be_The_Default() {
        assertAppliedTax(
                newEducationalBookBuilder().createEducationalBook(),
                newCountryBuilder().setCountryName("France").createCountry(),
                1.25);
    }

    @Test
    public void
    In_The_UK_The_Cost_Of_Novel_Is_Reduced_By_Additional_7_Percent_Over_Initial_Tax() {
        assertAppliedTax(
                newNovelBuilder().setAuthor(
                        newAuthorBuilder().setNationality(
                                newCountryBuilder().setCountryName("Germany").createCountry()
                        ).createAuthor()
                ).createNovel(),
                newCountryBuilder().setCountryName("UK").createCountry(),
                1.116);
    }

    @Test
    public void
    In_The_UK_Tax_Is_Not_Modified_For_Non_Novel_Books() {
        assertAppliedTax(
                newEducationalBookBuilder().setAuthor(
                        newAuthorBuilder().setNationality(
                                newCountryBuilder().setCountryName("Germany").createCountry()
                        ).createAuthor()
                ).createEducationalBook(),
                newCountryBuilder().setCountryName("UK").createCountry(),
                1.2);
    }

    @Test
    public void
    In_The_US_The_Cost_Of_Novel_Is_Reduced_By_Additional_2_Percent_Over_Initial_Tax() {
        assertAppliedTax(
                newNovelBuilder().setAuthor(
                        newAuthorBuilder().setNationality(
                                newCountryBuilder().setCountryName("Germany").createCountry()
                        ).createAuthor()
                ).createNovel(),
                newCountryBuilder().setCountryName("USA").createCountry(),
                1.127);
    }

    @Test
    public void
    In_The_US_Tax_Is_Not_Modified_For_Non_Novel_Books() {
        assertAppliedTax(
                newEducationalBookBuilder().setAuthor(
                        newAuthorBuilder().setNationality(
                                newCountryBuilder().setCountryName("Germany").createCountry()
                        ).createAuthor()
                ).createEducationalBook(),
                newCountryBuilder().setCountryName("USA").createCountry(),
                1.15);
    }

    @Test
    public void
    InGermanyThePriceWrittenByGermanAuthors_ShouldHaveFivePercentageTaxes() {
        Country germany = new Country("Germany", Currency.EURO, Language.GERMAN);
        Author franzKafka = new Author("Franz Kafka", germany);
        Book theTrial = new Novel("The Trial", 15d, franzKafka, Language.ENGLISH, Arrays.asList(Genre.MYSTERY));

        Country invoiceCountry = new Country("Germany", Currency.EURO, Language.GERMAN);

        assertAppliedTax(theTrial, invoiceCountry, 1.05);
    }

    @Test
    public void
    TaxesShouldBeExcludedOnLanguageBooks_IfTheCountryIsChina() {
        Country usa = new Country("USA", Currency.US_DOLLAR, Language.ENGLISH);
        Author authorA = new Author("Author_A", usa);
        Book englishBook = new EducationalBook("English for Beginners", 35.5, authorA, Language.ENGLISH, Category.LANGUAGE);

        Country invoiceCountry = new Country("China", Currency.RENMINBI, Language.MANDARIN);

        assertAppliedTax(englishBook, invoiceCountry, 1);
    }

    @Test
    public void
    TaxesShouldBeExcludedOnLanguageBooks_IfTheCountryIsSpain() {
        Country usa = new Country("USA", Currency.US_DOLLAR, Language.ENGLISH);
        Author authorA = new Author("Author_A", usa);
        Book englishBook = new EducationalBook("English for Beginners", 30.5, authorA, Language.ENGLISH, Category.LANGUAGE);

        Country invoiceCountry = new Country("Spain", Currency.EURO, Language.SPANISH);

        assertAppliedTax(englishBook, invoiceCountry, 1);
    }

    private void assertAppliedTax(Book computerBook, Country invoiceCountry, double expectedTax) {
        assertEquals(expectedTax, getApplicableTax(invoiceCountry, computerBook));
    }
}