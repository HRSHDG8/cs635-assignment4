package edu.sdsu.cs635.assignmnet4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WildCardMatchTest {
    private Match matcher;
    @BeforeEach
    void setUp() {
        matcher = new Match("a*bc");
    }

    @Test
    void findFirstIn() {
        assertEquals(1,matcher.findFirstIn("zaazazbc"));
        assertEquals(0,matcher.findFirstIn("abcabbc"));
        assertEquals(-1,matcher.findFirstIn("cbda"));
    }
}