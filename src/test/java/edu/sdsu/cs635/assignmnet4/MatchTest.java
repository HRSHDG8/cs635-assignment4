package edu.sdsu.cs635.assignmnet4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatchTest {
    private Match matcher;
    @BeforeEach
    void setUp() {
        matcher = new Match("a.bc");
    }

    @Test
    void findFirstIn() {
        System.out.println(matcher.findFirstIn("zaazazbc"));
    }
}