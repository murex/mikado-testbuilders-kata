import com.google.gson.stream.JsonReader;
import com.murex.tbw.MainRepository;
import com.murex.tbw.domain.book.*;
import com.murex.tbw.domain.country.Country;
import com.murex.tbw.domain.country.Currency;
import com.murex.tbw.domain.country.Language;
import com.murex.tbw.purchase.Invoice;
import com.murex.tbw.purchase.PurchasedBook;
import com.murex.tbw.report.ReportGenerator;
import com.murex.tbw.storage.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        Repository applicationRepository = MainRepository.configuredRepository();

        Application mainApp = new Application();
        File jsonFile = mainApp.getBasketsFile();
        List<Invoice> invoices = new ArrayList<>();

        JsonReader jsonReader = new JsonReader(new FileReader(jsonFile));
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
                invoices.add(invoice);
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Invoice invoice : invoices) {
            applicationRepository.addInvoice(invoice);
        }
        ReportGenerator reportGenerator = new ReportGenerator(applicationRepository);

        System.out.println("****************************************************");
        System.out.println("*****************Application Report*****************");
        System.out.println("****************************************************");
        System.out.println();
        System.out.println("The total number of books sold is: " + reportGenerator.getTotalSoldBooks());
        System.out.println("The total number of issued invoices is: " + reportGenerator.getNumberOfIssuedInvoices());
        System.out.println("The total amount of all invoices in USD is: " + reportGenerator.getTotalAmount());
        System.out.println();
        System.out.println("****************************************************");
        System.out.println("****************************************************");
    }

    private File getBasketsFile() {
        return new File(this.getClass().getClassLoader().getResource("repository.json").getFile());
    }
}
