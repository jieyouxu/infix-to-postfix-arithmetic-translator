enum Terminal {
    ZERO_DIGIT('0'),
    ONE_DIGIT('1'),
    TWO_DIGIT('2'),
    THREE_DIGIT('3'),
    FOUR_DIGIT('4'),
    FIVE_DIGIT('5'),
    SIX_DIGIT('6'),
    SEVEN_DIGIT('7'),
    EIGHT_DIGIT('8'),
    NINE_DIGIT('9'),
    PLUS_OPERATOR('+'),
    MINUS_OPERATOR('-');

    Terminal(char terminal) {
        this.terminal = terminal;
    }

    boolean equals(char character) {
        return terminal() == character;
    }

    char toChar() {
        return terminal();
    }

    private final char terminal;

    private char terminal() {
        return terminal;
    }
}
