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

        input = prepare(input);
        input = input.replaceAll("import.*\\n", "");
        input = input.replaceAll("\\s|\\t|\\n|\\r|public|private|protected|static", "");

        middleToken = new BaseToken(input.substring(input.indexOf('{') + 1, input.length() - 1), scope);
    }

    @Override
    public String toString() {
        return finalChanges(middleToken.toString()).replaceAll("∆", " ");
    }

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

    private String finalChanges(String in) {
        String out = in.replaceAll("true", "True");
        out = out.replaceAll("false", "False");

        return out;
    }
}
