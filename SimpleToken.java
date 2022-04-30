public class SimpleToken extends Token {

    SimpleToken(String input, int scope) {
        super(input, scope);
    }

    @Override
    public String toString() {
        String output = "";

        // Remove the type if it exists (declarations)
        // Remove the semicolon at the end of the statement
        output += input.replaceAll("int|String|double|boolean|char", "").replaceAll(";", "");

        return output;
    }
}
