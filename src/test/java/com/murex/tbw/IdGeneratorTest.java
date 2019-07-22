package com.murex.tbw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdGeneratorTest {

    @Test
    public void
    CallingNextId_ShouldIncrementTheValues() {
        Integer currentId = IdGenerator.getCurrentId();
        Integer firstExpected = currentId + 1;
        assertEquals(firstExpected, IdGenerator.nextId());
        Integer secondExpected = currentId + 2;
        assertEquals(secondExpected, IdGenerator.nextId());
    }

}