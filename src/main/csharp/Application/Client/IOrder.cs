/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

using Application.Domain.Book;
using Application.Purchase;

namespace Application.Client
{
    public interface IOrder
    {
        void AddBook(IBook book, int quantity);

        Invoice CheckOut();

        int GetQuantityOf(IBook book);
    }
}
