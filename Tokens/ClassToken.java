package Tokens;

/**
 * The class token will always start the parse tree, as it is assumed the java file will
 * begin with a class. From here, a new base token is made with the inner code of the
 * java class. Many overarching changes must be made to the input code, both before and
 * after tokenization and conversion.
 * 
 * @author Keenan Leverty
 * @author Peter Matern
 * @author Chris Allender
 */
public class ClassToken extends Token {

    BaseToken middleToken;

    public ClassToken(String input) {
        super(input, 0);

        // preserve string spaces
        input = prepare(input);

        // remove all imports
        input = input.replaceAll("import.*\\n", "");

        // remove whitespace and qualifiers for the class and other variables
        input = input.replaceAll("\\s|public|private|protected|static", "");

        // new base token to begin tokenization
        middleToken = new BaseToken(input.substring(input.indexOf('{') + 1, input.length() - 1), scope);
    }

    /**
     * Simply return the toString of the new base token, replacing the placeholder characters
     * inside of the strings with spaces again.
     */
    @Override
    public String toString() {
        return finalChanges(middleToken.toString()).replaceAll("∆", " ");
    }

    /**
     * Changes the spaces in strings to a different character to preserve them.
     * 
     * @param in string to change
     * @return string with spaces in strings replaced
     */
    private String prepare(String in) {
        String result = "";
        boolean isInString = false;

        for(int i = 0; i < in.length(); i++) {
            if(in.charAt(i) == '\"') {
                isInString = !isInString;
            }

            if(isInString && in.charAt(i) == ' ') {
                result += '∆';
            } else {
                result += in.charAt(i);
            }
        }

        return result;
    }

    /**
     * Makes basic python syntax changes to the given string.
     * @param in
     * @return
     */
    private String finalChanges(String in) {
        // Correct "true" and "false" syntax
        String out = in.replaceAll("true", "True");
        out = out.replaceAll("false", "False");

        // replace all increments to python equivalent
        // ex. i++ -> i += 1
        out = out.replaceAll("([\\w\\d])+(\\W)\\2", "$1 $2= 1");

        return out;
    }
}
