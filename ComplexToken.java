public class ComplexToken extends Token{
    boolean isForLoop;

    ComplexToken(String input,int scope, boolean isForLoop){
        super(input, scope);
this.isForLoop=isForLoop;



    }

    
}
