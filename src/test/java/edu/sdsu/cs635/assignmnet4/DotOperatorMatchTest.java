package edu.sdsu.cs635.assignmnet4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DotOperatorMatchTest {
    private Match matcher;

    @Test
    void dotCharacterInBetween() {
        matcher = new Match("a.bc");
        assertEquals(4, matcher.findFirstIn("zaazazbc"));
        assertEquals(3, matcher.findFirstIn("abcabbc"));
        assertEquals(-1, matcher.findFirstIn("cbda"));
    }

    @Test
    void dotCharacterAtStart() {
        matcher = new Match(".abc");
        assertEquals(0, matcher.findFirstIn("zabcxabc"));
        assertEquals(-1, matcher.findFirstIn("abczabc"));
        assertEquals(-1, matcher.findFirstIn("zcbds"));
    }

}