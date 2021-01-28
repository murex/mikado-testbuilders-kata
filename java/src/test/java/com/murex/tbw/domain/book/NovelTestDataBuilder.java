package com.murex.tbw.domain.book;

import com.google.common.collect.Lists;
import com.murex.tbw.domain.country.Language;

public class NovelTestDataBuilder {
    private double price = 10;

    public static NovelTestDataBuilder aNovel() {
        return new NovelTestDataBuilder();
    }

    public NovelTestDataBuilder costing(double price) {
        this.price = price;
        return this;
    }

    public Novel build() {
        return new Novel("Test Data Builders for Dummies", price, null, Language.ENGLISH, Lists.newArrayList());
    }
}
