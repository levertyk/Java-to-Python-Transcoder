package Tokens;

/**
 * ComplexToken breaks a token into complex types, loops and scoped functions. It then
 * creates another base toekn inside of the scoped fuction.
 * 
 * @author Keenan Leverty
 * @author Peter Matern
 * @author Chris Allender
 */
class ComplexToken extends Token {
    BaseToken nextBase;
    SimpleToken forToken;
    int type = -1;

    /**
     * Determines what type of complex token the token is. Makes a new base token with the rest of the input.
     * @param input String to be tokenized
     * @param scope The scope of the token itself, used to tab in for formatting
     */
    ComplexToken(String input, int scope) {
        super(input, scope);
        if (input.startsWith("while")) {
            nextBase = new BaseToken(input.substring(input.indexOf("{") + 1, input.lastIndexOf("}") + 1), scope + 1);
            type = 0;
        }
        else if (input.startsWith("for")) {
            forToken = new SimpleToken(input.substring(input.indexOf("(") + 1, input.indexOf(";") + 1), scope);
            nextBase = new BaseToken(input.substring(input.indexOf("{") + 1, input.lastIndexOf("}") + 1), scope + 1);
            type = 1;
        } else if (input.startsWith("if")) {
            nextBase = new BaseToken(input.substring(input.indexOf("{") + 1, input.lastIndexOf("}") + 1), scope + 1);
            type = 2;
        } else if (input.startsWith("voidmain")) {
            nextBase = new BaseToken(input.substring(input.indexOf("{") + 1, input.lastIndexOf("}") + 1), scope);
            type = 3;
        }


    }

    /**
     * Formats the token based on the type given.
     * 
     * @return the token as a python string
     */
    @Override
    public String toString() {
        String output = "";
        
        switch (type) {
            case 0: {
                output += gimmeTabs();
                output += "while ";
                output += input.substring(input.indexOf("(") + 1, input.indexOf(")")) + " :\n";
                output += nextBase.toString();
                break;
            } case 1: { // Forloop broken into a while loop, uses the tokens from the inside to change the output in python
                output += gimmeTabs() + forToken.toString();
                output += gimmeTabs() + "while " + input.substring(input.indexOf(";") + 1, input.indexOf(";", input.indexOf(";") + 1)) + " :\n";
                output += nextBase.toString();
                output += nextBase.gimmeTabs() + input.substring(input.indexOf(";", input.indexOf(";") + 1) + 1, input.indexOf(")")) + "\n";
                break;
            } case 2: {
                output += gimmeTabs();
                output += "if ";
                output += input.substring(input.indexOf("(") + 1, input.indexOf(")")) + " :\n";
                output += nextBase.toString();
                break;
            } case 3: {
                output += "\n" + nextBase.toString();
                break;
            }
        }

        return output;
    }

}
