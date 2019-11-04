/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

#ifndef TESTBUILDERS_WORKSHOP_CLIENT_ORDER_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_CLIENT_ORDER_H_INCLUDED

#include "domain/book/Book.h"
#include "purchase/Invoice.h"

namespace client
{
	class Order
	{
	public:
		virtual ~Order();

		virtual void addBook(const std::shared_ptr<domain::book::Book>&, int quantity) = 0;

		virtual std::shared_ptr<purchase::Invoice> checkOut() = 0;

		virtual int getQuantityOf(const std::shared_ptr<domain::book::Book>& book) const = 0;
	};

}

#endif // TESTBUILDERS_WORKSHOP_CLIENT_ORDER_H_INCLUDED
