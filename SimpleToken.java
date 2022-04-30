public class SimpleToken extends Token {

    SimpleToken(String input, int scope) {
        super(input, scope);
    }

    /**
     * To String method returns the string representation of the token, and the sub-Tokens
     */
    @Override
    public String toString() {
        // New output, filled at the beginning with the correct amount of tabs for the scope
        String output = gimmeTabs();

        // Remove the type if it exists (declarations)
        // Remove the semicolon at the end of the statement
        output += input.replaceAll("int|String|double|boolean|char", "").replaceAll(";", "");

        return output;
    }
}
