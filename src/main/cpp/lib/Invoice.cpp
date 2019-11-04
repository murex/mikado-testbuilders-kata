/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

#include "purchase/Invoice.h"
#include "purchase/PurchasedBook.h"
#include "IdGenerator.h"
#include "finance/TaxRule.h"

purchase::Invoice::Invoice(const std::string& clientName, const domain::country::Country& country)
: Invoice(id_generator::nextId(), clientName, country)
{
}

purchase::Invoice::Invoice(int id, const std::string& clientName, const domain::country::Country& country)
	: id_(id)
    , clientName_(clientName)
    , country_(country)
{
}

void purchase::Invoice::addPurchasedBooks(std::vector<std::shared_ptr<const PurchasedBook>> books)
{
	purchasedBooks_.insert(purchasedBooks_.end(), books.begin(), books.end());
}

void purchase::Invoice::addPurchasedBook(const std::shared_ptr<const PurchasedBook>& book)
{
	purchasedBooks_.push_back(book);
}

double purchase::Invoice::computeTotalAmount() const
{
	double sum = 0.0;
	for (const auto purchasedBook : purchasedBooks_)
	{
		double totalPrice = purchasedBook->getTotalPrice() * finance::getApplicableRate(country_, *purchasedBook->getBook());
		sum += totalPrice;
	}
	return sum;
}
