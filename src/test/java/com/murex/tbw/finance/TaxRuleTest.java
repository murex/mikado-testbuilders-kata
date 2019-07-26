package com.murex.tbw.finance;

import com.murex.tbw.domain.book.*;
import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Currency;
import com.murex.tbw.domain.country.Language;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TaxRuleTest {

    @Test
    public void
    WhenNoTaxRulesApply_ThePriceShouldBeMultiplyPriceByTheTax() {
        Country usa = new Country("USA", Currency.US_DOLLAR, Language.ENGLISH);
        Author authorA = new Author("Author_A", "AuthorA@Computer.com", usa);
        Book computerBook = new EducationalBook("Computer for Beginners", 35.5, authorA, Language.ENGLISH, Category.COMPUTER);

        Country invoiceCountry = new Country("France", Currency.EURO, Language.FRENCH);

        TaxRule taxRule = new TaxRule();
        Assertions.assertEquals(44.375, taxRule.computePriceAfterTax(invoiceCountry, computerBook));
    }

    @Test
    public void
    InTheUS_TheTotalCostOfNovelsIsReducedBy2Percent() {
        Country germany = new Country("Germany", Currency.EURO, Language.GERMAN);
        Author franzKafka = new Author("Franz Kafka", "Franz.Kafka@novel.com", germany);
        Book theTrial = new Novel("The Trial", 15d, franzKafka, Language.ENGLISH, Arrays.asList(Genre.MYSTERY));

        Country invoiceCountry = new Country("USA", Currency.US_DOLLAR, Language.ENGLISH);

        TaxRule taxRule = new TaxRule();
        Assertions.assertEquals(16.905, taxRule.computePriceAfterTax(invoiceCountry, theTrial));
    }

    @Test
    public void
    InTheUK_TheTotalCostOfNovelsIsReducedBy7Percent() {
        Country germany = new Country("Germany", Currency.EURO, Language.GERMAN);
        Author franzKafka = new Author("Franz Kafka", "Franz.Kafka@novel.com", germany);
        Book theTrial = new Novel("The Trial", 20d, franzKafka, Language.ENGLISH, Arrays.asList(Genre.MYSTERY));

        Country invoiceCountry = new Country("UK", Currency.POUND_STERLING, Language.ENGLISH);

        TaxRule taxRule = new TaxRule();
        Assertions.assertEquals(22.32, taxRule.computePriceAfterTax(invoiceCountry, theTrial));
    }

    @Test
    public void
    InGermanyThePriceWrittenByGermanAuthors_ShouldHaveFivePercentageTaxes() {
        Country germany = new Country("Germany", Currency.EURO, Language.GERMAN);
        Author franzKafka = new Author("Franz Kafka", "Franz.Kafka@novel.com", germany);
        Book theTrial = new Novel("The Trial", 15d, franzKafka, Language.ENGLISH, Arrays.asList(Genre.MYSTERY));

        Country invoiceCountry = new Country("Germany", Currency.EURO, Language.GERMAN);

        TaxRule taxRule = new TaxRule();
        Assertions.assertEquals(15.75, taxRule.computePriceAfterTax(invoiceCountry, theTrial));
    }

    @Test
    public void
    TaxesShouldBeExcludedOnLanguageBooks_IfTheCountryIsChina() {
        Country usa = new Country("USA", Currency.US_DOLLAR, Language.ENGLISH);
        Author authorA = new Author("Author_A", "AuthorA@english.com", usa);
        Book englishBook = new EducationalBook("English for Beginners", 35.5, authorA, Language.ENGLISH, Category.LANGUAGE);

        Country invoiceCountry = new Country("China", Currency.RENMINBI, Language.MANDARIN);

        TaxRule taxRule = new TaxRule();
        Assertions.assertEquals(35.5, taxRule.computePriceAfterTax(invoiceCountry, englishBook));
    }

    @Test
    public void
    TaxesShouldBeExcludedOnLanguageBooks_IfTheCountryIsSpain() {
        Country usa = new Country("USA", Currency.US_DOLLAR, Language.ENGLISH);
        Author authorA = new Author("Author_A", "AuthorA@english.com", usa);
        Book englishBook = new EducationalBook("English for Beginners", 30.5, authorA, Language.ENGLISH, Category.LANGUAGE);

        Country invoiceCountry = new Country("Spain", Currency.EURO, Language.SPANISH);

        TaxRule taxRule = new TaxRule();
        Assertions.assertEquals(30.5, taxRule.computePriceAfterTax(invoiceCountry, englishBook));
    }

}