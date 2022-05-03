package Tokens;

/**
 * Base token handles the tokenization of simple and complex tokens, and nests itself
 * to tokenize the rest of the input string.
 * 
 * @author Peter Matern
 * @author Keenan Leverty
 */
class BaseToken extends Token {

    Token simpOrComp;
    BaseToken nextBase;
    boolean isComplex;

    /**
     * The constructor for the base token determines if the token starts with a complex or simple token
     * then creates the corresponding token. Finally it makes a new base token with the remaining characters.
     * If the input is empty, no tokens are created, and the base token is considered empty, or epsilon.
     * 
     * @param input String containing the input passed to the base token to be tokenized.
     * @param scope The current scope of the base token, used for python formatting.
     */
    BaseToken(String input, int scope) {
        super(input, scope);

        // Checks if the input is a complex token
        isComplex = input.startsWith("while") || input.startsWith("if") || input.startsWith("for") || input.startsWith("voidmain");

        // If the input is nothing, do nothing
        if (input == "" || input == null) {

        } else if (isComplex) {                                                                            // if the input is complex
            addComplexToken();                                                                             // add a complex token
        } else if (input.indexOf(';') > 0) {                                                           // else the input starts with a simple token
            simpOrComp= new SimpleToken(input.substring(0,input.indexOf(';') + 1), scope);       // add a new simple token, ending on the first ';'
            nextBase= new BaseToken(input.substring(input.indexOf(';') + 1), scope);                   // add a new base token with the rest of the input
        }

    }

    /**
     * Private function finds the end of the complex token, based on where the last '}'
     * is, and the sub-scope of the token is the same.
     * 
     * @return int the end index of the complex token in the input string
     */
    private int findEndOfComplex() {
        int tempScope = 0;
        int endOfComplex = 0;

        for (int i = input.indexOf("{"); i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                tempScope++;
            } else if (input.charAt(i) == '}') {
                tempScope--;
            }
            if (tempScope == 0) {
                endOfComplex = i;
                break;
            }
        }

        return endOfComplex + 1;
    }

    /**
     * Adds a new complex token to the parse tree based on where the last '}' was found to be.
     * The entire token is included in the new complex token, meaning it is given the determining
     * keywords of "if" "while"... The complex token will handle the formatting and nested tokens.
     */
    private void addComplexToken(){
        // get the end of the token
        int endOfComplex = findEndOfComplex();

        simpOrComp = new ComplexToken(input.substring(0, endOfComplex), scope);    // add a new complex token, starting at the beginning, to the '}'
        try {
            nextBase= new BaseToken(input.substring(endOfComplex + 1), scope);               // add a new base token, starting after the '}', to the end
        } catch (Exception e) {

        }
    }

    /**
     * Simple toString() returns the toString() of the token created, and the base token under it.
     * If the tokens were not created, it is assumed this token is at the end of the file, or
     * parent token, and the output should just be the empty string; ie: the base case.
     */
    @Override
    public String toString() {
        String output = "";

        if(simpOrComp != null && nextBase != null) {
            output += simpOrComp.toString() + nextBase.toString();
        } else if (simpOrComp != null) {
            output += simpOrComp.toString();
        }

        return output;
        }

}
