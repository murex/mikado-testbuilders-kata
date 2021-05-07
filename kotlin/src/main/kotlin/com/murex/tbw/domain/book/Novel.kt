/*******************************************************************************
 *
 * Copyright (c) {2003-2021} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw.domain.book

import com.murex.tbw.domain.country.Language

data class Novel(
    override val name: String,
    override val price: Double,
    override val author: Author,
    override val language: Language,
    val genres: List<Genre> = mutableListOf()

) : Book