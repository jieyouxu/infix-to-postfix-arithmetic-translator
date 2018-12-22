import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TerminalTest {
    @Test
    void testEquals() {
        assertTrue(Terminal.ZERO_DIGIT.equals('0'));
        assertTrue(Terminal.ONE_DIGIT.equals('1'));
        assertTrue(Terminal.TWO_DIGIT.equals('2'));
        assertTrue(Terminal.THREE_DIGIT.equals('3'));
        assertTrue(Terminal.FOUR_DIGIT.equals('4'));
        assertTrue(Terminal.FIVE_DIGIT.equals('5'));
        assertTrue(Terminal.SIX_DIGIT.equals('6'));
        assertTrue(Terminal.SEVEN_DIGIT.equals('7'));
        assertTrue(Terminal.EIGHT_DIGIT.equals('8'));
        assertTrue(Terminal.NINE_DIGIT.equals('9'));

        assertTrue(Terminal.PLUS_OPERATOR.equals('+'));
        assertTrue(Terminal.MINUS_OPERATOR.equals('-'));
    }

    @Test
    void testToChar() {
        assertEquals('0', Terminal.ZERO_DIGIT.toChar());
        assertEquals('1', Terminal.ONE_DIGIT.toChar());
        assertEquals('2', Terminal.TWO_DIGIT.toChar());
        assertEquals('3', Terminal.THREE_DIGIT.toChar());
        assertEquals('4', Terminal.FOUR_DIGIT.toChar());
        assertEquals('5', Terminal.FIVE_DIGIT.toChar());
        assertEquals('6', Terminal.SIX_DIGIT.toChar());
        assertEquals('7', Terminal.SEVEN_DIGIT.toChar());
        assertEquals('8', Terminal.EIGHT_DIGIT.toChar());
        assertEquals('9', Terminal.NINE_DIGIT.toChar());

        assertEquals('+', Terminal.PLUS_OPERATOR.toChar());
        assertEquals('-', Terminal.MINUS_OPERATOR.toChar());
    }
}
