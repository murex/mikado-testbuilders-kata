/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

#include "purchase/PurchasedBook.h"
#include "domain/book/Book.h"

purchase::PurchasedBook::PurchasedBook(const std::shared_ptr<const domain::book::Book>& book, int quantity)
	: book_(book), quantity_(quantity)
{
}

std::shared_ptr<const domain::book::Book> purchase::PurchasedBook::getBook() const
{
	return book_;
}

int purchase::PurchasedBook::getQuantity() const
{
	return quantity_;
}

double purchase::PurchasedBook::getTotalPrice() const
{
	return book_->getPrice() * quantity_;
}
