package com.murex.tbw;

import java.util.UUID;

public final class UUIDGenerator {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(generateId());
        }
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
