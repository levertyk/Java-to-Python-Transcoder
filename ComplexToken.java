public class ComplexToken extends Token{
    boolean isForLoop;
    BaseToken nextBase;
    
    ComplexToken(String input,int scope, boolean isForLoop){
        super(input, scope);
    this.isForLoop=isForLoop;
    if(input.startsWith("while")){
        nextBase=BaseToken(input.substring(input.indexOf("{"),input.lastindexOf("}")), scope+1);
    }





    }

    
}
