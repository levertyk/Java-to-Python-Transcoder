public class ClassToken extends Token{

    BaseToken middleToken;

    ClassToken(String input) {
        super(input, 0);

        BaseToken middleToken = new BaseToken(input.substring(input.indexOf('{') + 1, input.length() - 1), scope);
    }
    
    @Override
    public String toString() {
        return middleToken.toString();
    }
}
