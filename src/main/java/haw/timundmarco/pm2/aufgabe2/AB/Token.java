package haw.timundmarco.pm2.aufgabe2.AB;

import java.util.regex.Pattern;

public enum Token {
    NUMBER(Pattern.compile("-?\\d*\\.?\\d+")),
    OPEN(Pattern.compile("\\(")),
    CLOSE(Pattern.compile("\\)")),
    // Einzelne Tokenns für den Rechner:
    PLUS(Pattern.compile("\\+")),
    MINUS(Pattern.compile("-")),
    MULTIPLICATION(Pattern.compile("\\*")),
    DIVISION(Pattern.compile("/"));

    private final Pattern pattern;
    Token(Pattern pattern) {
        this.pattern = pattern;
    }

    /**
     * Returns the pattern that matches the input or throws an exception
     * @param input Input string that should be matched against
     * @return The pattern that matches
     * @throws NoTokenMatchException
     *         If no pattern matches
     */
    public static Token getToken(String input) throws NoTokenMatchException {
        for (Token token : Token.class.getEnumConstants()) {
            if (token.matches(input)) return token;
        }
        throw new NoTokenMatchException("No matching Token found in "+input);
    }

    public boolean matches(String input) {
        return this.pattern.matcher(input).matches();
    }
}