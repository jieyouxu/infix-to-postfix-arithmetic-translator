import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TerminalsTest {
    @Test
    void testEquals() {
        assertTrue(Terminals.ZERO_DIGIT.equals('0'));
        assertTrue(Terminals.ONE_DIGIT.equals('1'));
        assertTrue(Terminals.TWO_DIGIT.equals('2'));
        assertTrue(Terminals.THREE_DIGIT.equals('3'));
        assertTrue(Terminals.FOUR_DIGIT.equals('4'));
        assertTrue(Terminals.FIVE_DIGIT.equals('5'));
        assertTrue(Terminals.SIX_DIGIT.equals('6'));
        assertTrue(Terminals.SEVEN_DIGIT.equals('7'));
        assertTrue(Terminals.EIGHT_DIGIT.equals('8'));
        assertTrue(Terminals.NINE_DIGIT.equals('9'));

        assertTrue(Terminals.PLUS_OPERATOR.equals('+'));
        assertTrue(Terminals.MINUS_OPERATOR.equals('-'));
    }

    @Test
    void testToChar() {
        assertEquals('0', Terminals.ZERO_DIGIT.toChar());
        assertEquals('1', Terminals.ONE_DIGIT.toChar());
        assertEquals('2', Terminals.TWO_DIGIT.toChar());
        assertEquals('3', Terminals.THREE_DIGIT.toChar());
        assertEquals('4', Terminals.FOUR_DIGIT.toChar());
        assertEquals('5', Terminals.FIVE_DIGIT.toChar());
        assertEquals('6', Terminals.SIX_DIGIT.toChar());
        assertEquals('7', Terminals.SEVEN_DIGIT.toChar());
        assertEquals('8', Terminals.EIGHT_DIGIT.toChar());
        assertEquals('9', Terminals.NINE_DIGIT.toChar());

        assertEquals('+', Terminals.PLUS_OPERATOR.toChar());
        assertEquals('-', Terminals.MINUS_OPERATOR.toChar());
    }
}
