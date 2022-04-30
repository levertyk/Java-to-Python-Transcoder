public class ClassToken extends Token{

    Token simpORcomplex;
    BaseToken nextBase;

    ClassToken(String input) {
        super(input, 0);

        if(input.startsWith("if") || input.startsWith("while") || input.startsWith("for")) {
            //TODO make lil string tokenizer
        } else {
            simpORcomplex = new SimpToken(input.substring(0, input.indexOf(';')));
            nextBase = new BaseToken(input.substring(input.indexOf(';') + 1));
        }
    }
    
}
