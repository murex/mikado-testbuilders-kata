/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package com.murex.tbw;

import java.util.concurrent.atomic.AtomicInteger;

public final class IdGenerator {
    private static IdGenerator idGenerator = null;
    private AtomicInteger currentId;

    private IdGenerator() {
        currentId = new AtomicInteger(0);
    }

    public static Integer nextId() {
        if (idGenerator == null) {
            idGenerator = new IdGenerator();
        }
        return idGenerator.currentId.incrementAndGet();
    }

    protected static Integer getCurrentId() {
        return idGenerator == null ? 0 : idGenerator.currentId.get();
    }
}
