/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

#include <storage/JsonRepository.h>
#include <purchase/Invoice.h>
#include <thirdparty/json.hpp>
#include <fstream>
#include <domain/book/Author.h>
#include <domain/book/Category.h>
#include <domain/book/Book.h>
#include <domain/book/EducationalBook.h>
#include <domain/book/Genre.h>
#include <domain/book/Novel.h>
#include <purchase/PurchasedBook.h>


using namespace purchase;
using namespace nlohmann;
using namespace std;
using namespace domain::country;
using namespace domain::book;

namespace storage
{

JsonRepository::JsonRepository()
	: sourceFile_(DEFAULT_JSON_PATH)
{
	loadJsonData();
}

void JsonRepository::addInvoice(const shared_ptr<Invoice>& invoice) {
	invoiceMap_[invoice->getId()] = invoice;
}

map<int, shared_ptr<Invoice>> JsonRepository::getInvoiceMap() const {
	return invoiceMap_;
}

namespace
{
	Language languageFrom(const json& json)
	{
		std::string text = json.get<std::string>();

		if (text == "ENGLISH") return ENGLISH;
		if (text == "FRENCH") return FRENCH;
		if (text == "SPANISH") return SPANISH;
		if (text == "JAPANESE") return JAPANESE;
		if (text == "MANDARIN") return MANDARIN;
		if (text == "ARABIC") return ARABIC;
		if (text == "GERMAN") return GERMAN;

		throw runtime_error("unknown language");
	}
	Currency currencyFrom(const json& json)
	{
		std::string text = json.get<std::string>();

		if (text == "US_DOLLAR") return US_DOLLAR;
		if (text == "AUSTRALIAN_DOLLAR") return AUSTRALIAN_DOLLAR;
		if (text == "EURO") return EURO;
		if (text == "POUND_STERLING") return POUND_STERLING;
		if (text == "YEN") return YEN;
		if (text == "RENMINBI") return RENMINBI;

		throw runtime_error("unknown currency");
	}
	Category categoryFrom(const json& json)
	{
		std::string text = json.get<std::string>();

		if (text == "BUSINESS") return BUSINESS;
		if (text == "LANGUAGE") return LANGUAGE;
		if (text == "COMPUTER") return COMPUTER;
		
		throw runtime_error("unknown category");
	}

	Genre genreFrom(const json& json)
	{
		std::string text = json.get<std::string>();

		if (text == "HORROR_FICTION") return HORROR_FICTION;
		if (text == "THRILLER") return THRILLER;
		if (text == "DARK_FANTASY") return DARK_FANTASY;
		if (text == "MYSTERY") return MYSTERY;
		if (text == "ADVENTURE_FICTION") return ADVENTURE_FICTION;
		if (text == "NON_FICTION") return NON_FICTION;
		if (text == "ROMANCE") return ROMANCE;

		throw runtime_error("unknown category");
	}


	Country countryFrom(const json& json)
	{
		return Country(json["name"].get<std::string>(), currencyFrom(json["currency"]), languageFrom(json["language"]));
	}

	Author authorFrom(const json& json)
	{
		return Author(json["name"].get<std::string>(), countryFrom(json["nationality"]));
	}

	std::shared_ptr<Book> bookFrom(const json& json)
	{
		std::shared_ptr<Book> book;

		std::string name = json["name"].get<std::string>();
		double price = json["price"].get<double>();
		Language language = languageFrom(json["language"]);
		Author author = authorFrom(json["author"]);


		if (json.find("category") != json.end())
		{
			// educational book

			Category category = categoryFrom(json["category"]);
			book = std::make_shared<EducationalBook>(name, price, author, language, category);
		}
		else
		{
			// novel

			std::vector<Genre> genres;

			const auto genresElt = json["genre"];
			for (const auto genreElt : genresElt)
			{
				genres.push_back(genreFrom(genreElt));
			}
			book = std::make_shared<Novel>(name, price, author, language, genres);
		}
		return book;
	}

	std::shared_ptr<Invoice> invoiceFrom(const json& json)
	{
		std::string clientName = json["client"].get<std::string>();
		int id = json["id"].get<int>();
		Country country = countryFrom(json["country"]);

		std::shared_ptr<Invoice> invoice = std::make_shared<Invoice>(id, clientName, country);


		const auto booksInBasketElt = json["booksInBasket"];
		for (const auto bookInBasketElt : booksInBasketElt)
		{
			std::shared_ptr<Book> book = bookFrom(bookInBasketElt);
			int quantity = bookInBasketElt["quantity"].get<int>();

			std::shared_ptr<PurchasedBook> purchasedBook = std::make_shared<PurchasedBook>(book, quantity);

			invoice->addPurchasedBook(purchasedBook);
		}

		return invoice;
	}
}


void JsonRepository::loadJsonData()
{
	ifstream fileStream(sourceFile_);
	if (fileStream.fail())
	{
		throw std::invalid_argument("Could not load repository.json data. Make sure to run from the solution folder");
	}
	json repoJson;
	fileStream >> repoJson;

	for (const auto invoiceElt : repoJson)
	{
		std::shared_ptr<Invoice> invoice = invoiceFrom(invoiceElt);

		invoiceMap_[invoice->getId()] = invoice;
	}
}

}
