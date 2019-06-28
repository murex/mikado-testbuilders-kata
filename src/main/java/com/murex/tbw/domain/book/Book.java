package com.murex.tbw.domain.book;

import com.murex.tbw.domain.country.Language;

public interface Book {

    String getName();

    double getPrice();

    Author getAuthor();

    Language getLanguage();
}
