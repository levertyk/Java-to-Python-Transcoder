public class ComplexToken extends Token {
    boolean isForLoop;
    BaseToken nextBase;

    ComplexToken(String input, int scope, boolean isForLoop) {
        super(input, scope);
        this.isForLoop = isForLoop;
        if (input.startsWith("while")) {
            nextBase = new BaseToken(input.substring(input.indexOf("{"), input.lastIndexOf("}")), scope + 1);
        }

    }

}
