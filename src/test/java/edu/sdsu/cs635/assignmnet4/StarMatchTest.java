package edu.sdsu.cs635.assignmnet4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StarMatchTest {
    private Match matcher;

    @Test
    void starInBetween() {
        matcher = new Match("a*bc");
        assertEquals(1,matcher.findFirstIn("zaazazbc"));
        assertEquals(0,matcher.findFirstIn("abcabbc"));
        assertEquals(-1,matcher.findFirstIn("cbda"));
    }

    @Test
    void starAtEnd() {
        matcher = new Match("a.c*");
        assertEquals(3,matcher.findFirstIn("zyxabcayx"));
        assertEquals(0,matcher.findFirstIn("abcabbc"));
        assertEquals(-1,matcher.findFirstIn("cbda"));
    }

    @Test
    void starOnly() {
        matcher = new Match("*a");
        assertEquals(3,matcher.findFirstIn("zyxabcayx"));
        assertEquals(0,matcher.findFirstIn("abcabbc"));
        assertEquals(3,matcher.findFirstIn("cbda"));
    }
}