package edu.sdsu.cs635.assignmnet4;

import edu.sdsu.cs635.assignmnet4.pattern.Match;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlphabetMatchTest {

    private Match matcher;

    @Test
    void dotCharacterInBetween() {
        matcher = new Match("abc");
        assertEquals(4, matcher.findFirstIn("zaczabc"));
        assertEquals(0, matcher.findFirstIn("abcabbc"));
        assertEquals(-1, matcher.findFirstIn("cbda"));
    }

    @Test
    void dotCharacterAtStart() {
        matcher = new Match("cac");
        assertEquals(5, matcher.findFirstIn("aaabacac"));
        assertEquals(-1, matcher.findFirstIn("abczabc"));
        assertEquals(-1, matcher.findFirstIn("cbc"));
    }
}
