package Tokens;

class ComplexToken extends Token {
    boolean isForLoop;
    BaseToken nextBase;

    ComplexToken(String input, int scope) {
        super(input, scope);
        if (input.startsWith("while")) {
            nextBase = new BaseToken(input.substring(input.indexOf("{"), input.lastIndexOf("}")), scope + 1);

        }
        else if (input.startsWith("for")) {
            nextBase = new BaseToken(input.substring(input.indexOf("{"), input.lastIndexOf("}")), scope + 1);
            
        } else if (input.startsWith("if")) {
            nextBase = new BaseToken(input.substring(input.indexOf("{"), input.lastIndexOf("}")), scope + 1);
            
        }


    }

}
