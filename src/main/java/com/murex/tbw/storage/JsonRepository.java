/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package com.murex.tbw.storage;

import com.google.gson.stream.JsonReader;
import com.murex.tbw.domain.book.*;
import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Currency;
import com.murex.tbw.domain.country.Language;
import com.murex.tbw.purchase.Invoice;
import com.murex.tbw.purchase.PurchasedBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class JsonRepository implements Repository {
    private final File sourceFile;
    private final Map<Integer, Invoice> invoiceMap;

    public JsonRepository() {
        invoiceMap = new HashMap<>();
        sourceFile = new File(this.getClass().getClassLoader().getResource("repository.json").getFile());
        try {
            loadJsonData();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadJsonData() throws FileNotFoundException {
        JsonReader jsonReader = new JsonReader(new FileReader(sourceFile));
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                Invoice invoice = null;
                String clientName = "";
                int id = 0;
                Country invoiceCountry;

                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String clientKeyName = jsonReader.nextName();
                    if (clientKeyName.equals("id")) {
                        id = jsonReader.nextInt();
                    } else if (clientKeyName.equals("client")) {
                        clientName = jsonReader.nextString();
                    } else if (clientKeyName.equals("country")) {
                        jsonReader.beginObject();
                        String countryName = "";
                        Language language = null;
                        Currency currency = null;
                        while (jsonReader.hasNext()) {
                            String countryKeyName = jsonReader.nextName();
                            if (countryKeyName.equals("name")) {
                                countryName = jsonReader.nextString();
                            } else if (countryKeyName.equals("language")) {
                                language = Language.valueOf(jsonReader.nextString());
                            } else if (countryKeyName.equals("currency")) {
                                currency = Currency.valueOf(jsonReader.nextString());
                            }
                        }
                        jsonReader.endObject();
                        invoiceCountry = new Country(countryName, currency, language);
                        invoice = new Invoice(id, clientName, invoiceCountry);
                    } else if (clientKeyName.equals("booksInBasket")) {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            Book book;
                            String bookName = "";
                            double price = 0.0d;
                            Language bookLanguage = null;
                            Category bookCategory = null;
                            Author author = null;
                            int quantity = 0;
                            List<Genre> genres = new ArrayList<>();

                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                String bookKeyName = jsonReader.nextName();
                                if (bookKeyName.equals("name")) {
                                    bookName = jsonReader.nextString();
                                } else if (bookKeyName.equals("price")) {
                                    price = jsonReader.nextDouble();
                                } else if (bookKeyName.equals("language")) {
                                    bookLanguage = Language.valueOf(jsonReader.nextString());
                                } else if (bookKeyName.equals("quantity")) {
                                    quantity = jsonReader.nextInt();
                                } else if (bookKeyName.equals("category")) {
                                    bookCategory = Category.valueOf(jsonReader.nextString());
                                } else if (bookKeyName.equals("author")) {
                                    jsonReader.beginObject();
                                    while (jsonReader.hasNext()) {
                                        String authorKeyName = jsonReader.nextName();
                                        String authorName = "";
                                        Country authorNationality = null;
                                        if (authorKeyName.equals("name")) {
                                            authorName = jsonReader.nextString();
                                        } else if (authorKeyName.equals("nationality")) {
                                            jsonReader.beginObject();
                                            String countryName = "";
                                            Language countryLanguage = null;
                                            Currency countryCurrency = null;
                                            while (jsonReader.hasNext()) {
                                                String authorNatKeyName = jsonReader.nextName();
                                                if (authorNatKeyName.equals("name")) {
                                                    countryName = jsonReader.nextString();
                                                } else if (authorNatKeyName.equals("language")) {
                                                    countryLanguage = Language.valueOf(jsonReader.nextString());
                                                } else if (authorNatKeyName.equals("currency")) {
                                                    countryCurrency = Currency.valueOf(jsonReader.nextString());
                                                }
                                            }
                                            authorNationality = new Country(countryName, countryCurrency, countryLanguage);
                                            jsonReader.endObject();
                                        }
                                        author = new Author(authorName, authorNationality);
                                    }
                                    jsonReader.endObject();
                                } else if (bookKeyName.equals("genre")) {
                                    jsonReader.beginArray();
                                    while (jsonReader.hasNext()) {
                                        genres.add(Genre.valueOf(jsonReader.nextString()));
                                    }
                                    jsonReader.endArray();
                                }
                            }
                            jsonReader.endObject();

                            if (bookCategory != null) {
                                book = new EducationalBook(bookName, price, author, bookLanguage, bookCategory);
                            } else {
                                book = new Novel(bookName, price, author, bookLanguage, genres);
                            }
                            invoice.addPurchasedBook(new PurchasedBook(book, quantity));
                        }
                        jsonReader.endArray();
                    }
                }
                addInvoice(invoice);
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addInvoice(Invoice invoice) {
        invoiceMap.put(invoice.getId(), invoice);
    }

    @Override
    public Map<Integer, Invoice> getInvoiceMap() {
        return invoiceMap;
    }
}
