package Tokens;

/**
 * The class token will always start the parse tree, as it is assumed the java file will
 * begin with a class. From here, a new base token is made with the inner code of the
 * java class.
 * 
 * @author Keenan Leverty
 */
public class ClassToken extends Token {

    BaseToken middleToken;

    public ClassToken(String input) {
        super(input, 0);

        input = input.replaceAll("\\s|public|private|protected|static", "");

        middleToken = new BaseToken(input.substring(input.indexOf('{') + 1, input.length() - 1), scope);
    }

    @Override
    public String toString() {
        return finalChanges(middleToken.toString());
    }

    private String finalChanges(String in) {
        String out = in.replaceAll("true", "True");
        out = out.replaceAll("false", "False");

        return out;
    }
}