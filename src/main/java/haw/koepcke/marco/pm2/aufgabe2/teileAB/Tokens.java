package haw.koepcke.marco.pm2.aufgabe2.teileAB;

import java.util.regex.Pattern;

public enum Tokens {
    NUMBER(Pattern.compile("-*\\d*\\.?\\d+")),
    OPEN(Pattern.compile("\\(")),
    CLOSE(Pattern.compile("\\)")),
    // Einzelne Tokenns für den Rechner:
    PLUS(Pattern.compile("\\+")),
    MINUS(Pattern.compile("-")),
    MULTIPLICATION(Pattern.compile("\\*")),
    DIVISION(Pattern.compile("/"));

    private final Pattern token;
    Tokens(Pattern token) {
        this.token = token;
    }

    /**
     * Returns the token that matches the input or throws an exception
     * @param input Input string that should be matched against
     * @return The token that matches
     * @throws NoTokenMatchException
     *         If no token matches
     */
    public static Tokens getToken(String input) throws NoTokenMatchException {
        for (Tokens token : Tokens.class.getEnumConstants()) {
            if (token.matches(input)) return token;
        }
        throw new NoTokenMatchException("No matching Token found in "+input);
    }

    public boolean matches(String input) {
        return this.token.matcher(input).matches();
    }
}