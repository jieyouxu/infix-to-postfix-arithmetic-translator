import java.util.*;

class Translator {
    private int lookahead;
    private List<Character> inputCharacters = new ArrayList<>();
    private Iterator<Character> inputIterator;

    private StringBuilder result = new StringBuilder();

    String translate(String input) throws SyntaxException {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        if (input.equals("")) {
            return "";
        }

        initialize(input);
        translateExpression();

        return result.toString();
    }

    private void initialize(String input) {
        for (char c : input.toCharArray()) {
            inputCharacters.add(c);
        }

        inputIterator = inputCharacters.iterator();
        if (inputIterator.hasNext()) {
            lookahead = inputIterator.next();
        }
    }

    private void translateExpression() throws SyntaxException {
        translateTerminals();

        while (true) {
            switch (lookahead) {
                case '+':
                    match('+');
                    translateTerminals();
                    result.append('+');
                    break;
                case '-':
                    match('-');
                    translateTerminals();
                    result.append('-');
                    break;
                default:
                    return;
            }
        }
    }

    private void translateTerminals() throws SyntaxException {
        if (Character.isDigit(lookahead)) {
            result.append((char) lookahead);
            match(lookahead);
        } else {
            throwSyntaxException(lookahead);
        }
    }

    private void match(int terminal) throws SyntaxException {
        if (lookahead == terminal) {
            moveLookaheadToNextPosition();
        } else {
            throwSyntaxException(lookahead);
        }
    }

    private void moveLookaheadToNextPosition() {
        if (inputIterator.hasNext()) {
            lookahead = inputIterator.next();
        }
    }

    private void throwSyntaxException(int lookahead) throws SyntaxException {
        throw new SyntaxException(Character.toString(lookahead));
    }
}
