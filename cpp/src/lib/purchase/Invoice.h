/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

#ifndef TESTBUILDERS_WORKSHOP_PURCHASE_INVOICE_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_PURCHASE_INVOICE_H_INCLUDED

#include <string>
#include <vector>
#include "../domain/country/Country.h"

namespace purchase
{
	class PurchasedBook;

	class Invoice 
{
	const int id_;
	const std::string clientName_;
	std::vector<std::shared_ptr<const PurchasedBook>> purchasedBooks_;
	const domain::country::Country country_;

public:
	Invoice(const std::string& clientName, const domain::country::Country& country);

	Invoice(int id, const std::string& clientName, const domain::country::Country& country);

	int getId() const
	{
		return id_;
	}

	std::string getClientName() const
	{
		return clientName_;
	}

	domain::country::Country getCountry() const
	{
		return country_;
	}

	void addPurchasedBooks(std::vector<std::shared_ptr<const PurchasedBook>> books);

	void addPurchasedBook(const std::shared_ptr <const PurchasedBook>& book);

	double computeTotalAmount() const;

	std::vector<std::shared_ptr<const PurchasedBook>> getPurchasedBooks() const
	{
		return purchasedBooks_;
	}
};
}

#endif // TESTBUILDERS_WORKSHOP_PURCHASE_INVOICE_H_INCLUDED