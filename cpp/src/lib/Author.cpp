/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

#include <domain/book/Author.h>

domain::book::Author::Author(const std::string& name, const country::Country& nationality): name_(name)
                                                                                            , nationality_(nationality)
{
}
