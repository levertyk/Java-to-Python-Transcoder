package Tokens;

/**
 * Token template class for all other tokens
 * 
 * @author Keenan Leverty
 * @author Peter Matern
 * @author Chris Allender
 */
class Token {
    public String input;
    public int scope;

    /**
     * Simple constructor initializing variables
     * @param input
     * @param scope
     */
    Token(String input, int scope) {
        this.input = input;
        this.scope = scope;
    }

    /**
     * Returns an amount of tabs for the scope of the token.
     * @return String of tab characters
     */
    public String gimmeTabs() {
        String output = "";

        for(int i = 0; i < scope; i++) {
            output += "\t";
        }

        return output;
    }
}
