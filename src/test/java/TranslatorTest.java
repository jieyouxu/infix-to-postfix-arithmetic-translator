import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {
    private Translator translator;
    private String input;

    @Test
    void testInputCannotBeNull() {
        givenTranslator();
        whenInputIs(null);
        assertThrows(IllegalArgumentException.class, () -> translator.translate(input));
    }

    @Test
    void testEmptyStringShouldBecomeEmptyString() {
        givenTranslator();
        whenInputIs("");
        thenOutputShouldBecome("");
    }

    private void givenTranslator() {
        translator = new Translator();
    }

    private void whenInputIs(String s) {
        input = s;
    }

    private void thenOutputShouldBecome(String expected) {
        try {
            assertEquals(expected, translator.translate(input));
        } catch (SyntaxException e) {
            fail(String.format("Syntax exception: %s", expected), e);
        }
    }

    @Test
    void testSingleDigitShouldNotChange() {
        givenTranslator();
        whenInputIs("0");
        thenOutputShouldBecome("0");
    }

    @Test
    void testSingleBinaryOperatorNoOperandsShouldFail() {
        givenTranslator();
        whenInputIs("+");
        thenTranslatorShouldFail();
    }

    private void thenTranslatorShouldFail() {
        assertThrows(SyntaxException.class, () -> translator.translate(input));
    }

    @Test
    void testSingleBinaryOperatorOneLeftOperandShouldFail() {
        givenTranslator();
        whenInputIs("1+");
        thenTranslatorShouldFail();
    }

    @Test
    void testSingleBinaryOperatorOneRightOperandShouldFail() {
        givenTranslator();
        whenInputIs("-2");
        thenTranslatorShouldFail();
    }

    @Test
    void testSingleBinaryOperatorBothOperationShouldWork() {
        givenTranslator();
        whenInputIs("1+2");
        thenOutputShouldBecome("12+");
    }

    @Test
    void testSinglyNestedValidInputShouldWork() {
        givenTranslator();
        whenInputIs("1+2-3");
        thenOutputShouldBecome("12+3-");
    }

    @Disabled
    @Test
    void testSinglyNestedInvalidInputShouldFail() {
        givenTranslator();
        whenInputIs("3+45-");
        // FIXME: The translator does not throw exception; the translator recognizes 3+4 thn simply discards 5-.
        thenTranslatorShouldFail();
    }

    @Test
    void testComplexValidInputShouldWork() {
        givenTranslator();
        whenInputIs("1+2-3+4-5+6+7");
        thenOutputShouldBecome("12+3-4+5-6+7+");
    }
}
