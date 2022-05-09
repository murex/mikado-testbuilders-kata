/*
 * ******************************************************************************
 *  *
 *  * Copyright (c) {2003-2022} Murex S.A.S. and its affiliates.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the MIT License
 *  * which accompanies this distribution, and is available at
 *  * https://opensource.org/licenses/MIT
 *  *
 *  ******************************************************************************
 */

package com.murex.tbw.domain.book

import com.murex.tbw.domain.book.Genres.Genre
import com.murex.tbw.domain.country.Languages.Language

case class Novel(
    name: String,
    price: Double,
    author: Author,
    language: Language,
    genres: List[Genre] = List.empty
) extends Book {}
