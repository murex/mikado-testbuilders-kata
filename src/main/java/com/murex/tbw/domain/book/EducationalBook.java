/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package com.murex.tbw.domain.book;

import com.murex.tbw.domain.country.Language;

import java.util.Objects;

public final class EducationalBook implements Book {

    private final String name;
    private final double price;
    private final Author author;
    private final Language language;
    private final Category category;

    public EducationalBook(String name, double price, Author author, Language language, Category category) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.language = language;
        this.category = category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Author getAuthor() {
        return author;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "EducationalBook{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author=" + author +
                ", language=" + language +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationalBook that = (EducationalBook) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(author, that.author) &&
                language == that.language &&
                category == that.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, author, language, category);
    }
}
