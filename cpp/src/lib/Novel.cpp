/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

#include "domain/book/Novel.h"

domain::book::Novel::Novel(const std::string& name, double price, const Author& author, country::Language language,
                           const std::vector<Genre>& genres): name_(name)
                                                              , price_(price)
                                                              , author_(author)
                                                              , language_(language)
                                                              , genres_(genres)
{
}
