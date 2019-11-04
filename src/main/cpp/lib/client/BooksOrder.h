/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

#ifndef TESTBUILDERS_WORKSHOP_CLIENT_BOOKS_ORDER_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_CLIENT_BOOKS_ORDER_H_INCLUDED

#include "client/Order.h"
#include <map>
#include "Client.h"

namespace client
{
class BooksOrder : public Order
{
	std::map<std::shared_ptr<domain::book::Book>, int> booksInBasket_;
	const Client client_;

public:

	explicit BooksOrder(const Client& client);

	void addBook(const std::shared_ptr<domain::book::Book>& book, int quantity) override;

	std::shared_ptr<purchase::Invoice> checkOut() override;

	int getQuantityOf(const std::shared_ptr<domain::book::Book>& book) const override;
};
}

#endif // TESTBUILDERS_WORKSHOP_CLIENT_BOOKS_ORDER_H_INCLUDED