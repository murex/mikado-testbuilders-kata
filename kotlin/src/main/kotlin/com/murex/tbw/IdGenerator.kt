/*******************************************************************************
 *
 * Copyright (c) {2003-2021} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

package com.murex.tbw

import java.util.concurrent.atomic.AtomicInteger

object IdGenerator {
    private var idGenerator: IdGenerator? = null
    private var currentId: AtomicInteger = AtomicInteger(0)

    fun nextId(): Int {
        if (idGenerator == null) {
            idGenerator = IdGenerator
        }
        return idGenerator!!.currentId.incrementAndGet()
    }

    fun getCurrentId(): Int = if (idGenerator == null) {
        0
    } else idGenerator!!.currentId.get()
}