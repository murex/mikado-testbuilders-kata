package com.murex.tbw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdGeneratorTest {

    @Test
    public void
    CallingNextId_ShouldIncrementTheValues() {
        assertEquals(new Integer(1), IdGenerator.nextId());
        assertEquals(new Integer(2), IdGenerator.nextId());
    }

}