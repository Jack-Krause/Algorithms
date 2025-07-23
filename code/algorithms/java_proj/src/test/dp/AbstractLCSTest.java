package test.dp;

import core.Algorithm;
import dp.LCSInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractLCSTest {

    protected abstract Algorithm<LCSInput, Integer> alg();

    @Test void basic() {
        var input = new LCSInput("ABCBDAB", "BDCABA");
        int actual = alg().run(input);
        assertEquals(4, actual);
    }

    @Test
    void emptyStrings() {
        assertEquals(0, alg().run(new LCSInput("", "")));
    }

    @Test
    void oneEmpty() {
        assertEquals(0, alg().run(new LCSInput("ABC", "")));
    }

    @Test
    void identicalStrings() {
        assertEquals(5, alg().run(new LCSInput("HELLO", "HELLO")));
    }

    @Test
    void classicExample() {
        // CLRS example: "ABCBDAB" and "BDCABA" -> LCS length 4
        assertEquals(4, alg().run(new LCSInput("ABCBDAB", "BDCABA")));
    }

    @Test
    void noCommonChars() {
        assertEquals(0, alg().run(new LCSInput("ABC", "DEF")));
    }




}
