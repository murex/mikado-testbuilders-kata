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
