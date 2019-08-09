package com.murex.tbw.finance;

import com.murex.tbw.domain.book.Book;
import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Language;
import org.junit.jupiter.api.Test;

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
    In_Germany_Books_Written_By_German_Authors_Should_Only_Have_Five_Percentage_Taxes() {
        assertAppliedTax(
                newNovelBuilder().setAuthor(
                        newAuthorBuilder().setNationality(
                                newCountryBuilder().setCountryName("Germany").createCountry()
                        ).createAuthor()
                ).createNovel(),
                newCountryBuilder().setCountryName("Germany").createCountry(),
                1.05
        );
    }

    @Test
    public void
    In_China_Taxes_Should_Be_Excluded_On_Language_Books() {
        assertAppliedTax(
                newEducationalBookBuilder()
                        .setLanguage(Language.ENGLISH)
                        .setAuthor(
                                newAuthorBuilder().setNationality(
                                        newCountryBuilder().setCountryName("Germany").createCountry()
                                ).createAuthor()
                        ).createEducationalBook(),
                newCountryBuilder().setCountryName("China").createCountry(),
                1
        );
    }

    @Test
    public void
    In_Spain_Taxes_Should_Be_Excluded_On_Language_Books() {
        assertAppliedTax(
                newEducationalBookBuilder()
                        .setLanguage(Language.ENGLISH)
                        .setAuthor(
                                newAuthorBuilder().setNationality(
                                        newCountryBuilder().setCountryName("Germany").createCountry()
                                ).createAuthor()
                        ).createEducationalBook(),
                newCountryBuilder().setCountryName("Spain").createCountry(),
                1
        );
    }

    private void assertAppliedTax(Book computerBook, Country invoiceCountry, double expectedTax) {
        assertEquals(expectedTax, getApplicableTax(invoiceCountry, computerBook));
    }
}