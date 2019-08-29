#include "storage/JsonRepository.h"
#include "purchase/Invoice.h"
#include "thirdparty/json.hpp"
#include <fstream>

using namespace purchase;
using namespace nlohmann;
using namespace std;
using namespace domain::country;

namespace storage
{

JsonRepository::JsonRepository()
	: sourceFile_("src/main/resources/repository.json")
{
}

void JsonRepository::addInvoice(const shared_ptr<Invoice>& invoice) {
	invoiceMap_[invoice->getId()] = invoice;
}

map<int, shared_ptr<Invoice>> JsonRepository::getInvoiceMap() const {
	return invoiceMap_;
}


void JsonRepository::loadJsonData()
{
	ifstream fileStream(sourceFile_);
	json repoJson;
	fileStream >> repoJson;

	//FIXME test this!!!
	for (auto element : repoJson)
	{
		std::shared_ptr<Invoice> invoice;
		std::string clientName = element["client"];
		int id = element["id"];
		//Country invoiceCountry();
	}



			//jsonReader.beginObject();
			//while (jsonReader.hasNext()) {
			//	String clientKeyName = jsonReader.nextName();
			//	if (clientKeyName.equals("id")) {
			//		id = jsonReader.nextInt();
			//	}
			//	else if (clientKeyName.equals("client")) {
			//		clientName = jsonReader.nextString();
			//	}
			//	else if (clientKeyName.equals("country")) {
			//		jsonReader.beginObject();
			//		String countryName = "";
			//		Language language = null;
			//		Currency currency = null;
			//		while (jsonReader.hasNext()) {
			//			String countryKeyName = jsonReader.nextName();
			//			if (countryKeyName.equals("name")) {
			//				countryName = jsonReader.nextString();
			//			}
			//			else if (countryKeyName.equals("language")) {
			//				language = Language.valueOf(jsonReader.nextString());
			//			}
			//			else if (countryKeyName.equals("currency")) {
			//				currency = Currency.valueOf(jsonReader.nextString());
			//			}
			//		}
			//		jsonReader.endObject();
			//		invoiceCountry = new Country(countryName, currency, language);
			//		invoice = new Invoice(id, clientName, invoiceCountry);
			//	}
			//	else if (clientKeyName.equals("booksInBasket")) {
			//		jsonReader.beginArray();
			//		while (jsonReader.hasNext()) {
			//			Book book;
			//			String bookName = "";
			//			double price = 0.0d;
			//			Language bookLanguage = null;
			//			Category bookCategory = null;
			//			Author author = null;
			//			int quantity = 0;
			//			List<Genre> genres = new ArrayList<>();

			//			jsonReader.beginObject();
			//			while (jsonReader.hasNext()) {
			//				String bookKeyName = jsonReader.nextName();
			//				if (bookKeyName.equals("name")) {
			//					bookName = jsonReader.nextString();
			//				}
			//				else if (bookKeyName.equals("price")) {
			//					price = jsonReader.nextDouble();
			//				}
			//				else if (bookKeyName.equals("language")) {
			//					bookLanguage = Language.valueOf(jsonReader.nextString());
			//				}
			//				else if (bookKeyName.equals("quantity")) {
			//					quantity = jsonReader.nextInt();
			//				}
			//				else if (bookKeyName.equals("category")) {
			//					bookCategory = Category.valueOf(jsonReader.nextString());
			//				}
			//				else if (bookKeyName.equals("author")) {
			//					jsonReader.beginObject();
			//					while (jsonReader.hasNext()) {
			//						String authorKeyName = jsonReader.nextName();
			//						String authorName = "";
			//						Country authorNationality = null;
			//						if (authorKeyName.equals("name")) {
			//							authorName = jsonReader.nextString();
			//						}
			//						else if (authorKeyName.equals("nationality")) {
			//							jsonReader.beginObject();
			//							String countryName = "";
			//							Language countryLanguage = null;
			//							Currency countryCurrency = null;
			//							while (jsonReader.hasNext()) {
			//								String authorNatKeyName = jsonReader.nextName();
			//								if (authorNatKeyName.equals("name")) {
			//									countryName = jsonReader.nextString();
			//								}
			//								else if (authorNatKeyName.equals("language")) {
			//									countryLanguage = Language.valueOf(jsonReader.nextString());
			//								}
			//								else if (authorNatKeyName.equals("currency")) {
			//									countryCurrency = Currency.valueOf(jsonReader.nextString());
			//								}
			//							}
			//							authorNationality = new Country(countryName, countryCurrency, countryLanguage);
			//							jsonReader.endObject();
			//						}
			//						author = new Author(authorName, authorNationality);
			//					}
			//					jsonReader.endObject();
			//				}
			//				else if (bookKeyName.equals("genre")) {
			//					jsonReader.beginArray();
			//					while (jsonReader.hasNext()) {
			//						genres.add(Genre.valueOf(jsonReader.nextString()));
			//					}
			//					jsonReader.endArray();
			//				}
			//			}
			//			jsonReader.endObject();

			//			if (bookCategory != null) {
			//				book = new EducationalBook(bookName, price, author, bookLanguage, bookCategory);
			//			}
			//			else {
			//				book = new Novel(bookName, price, author, bookLanguage, genres);
			//			}
			//			invoice.addPurchasedBook(new PurchasedBook(book, quantity));
			//		}
			//		jsonReader.endArray();
			//	}
			//}
			//addInvoice(invoice);
			//jsonReader.endObject();
	}

}
