public class BaseToken extends Token {


    Token simpOrComp;
    BaseToken nextBase;
    BaseToken(String input,int scope){
        super(input, scope);


        if(input.substring(0,6).contains("while")){


        }else if(input.substring(0,3).contains("if")){

        }else if(input.substring(0,4).contains("for")){

        }

    }
        

    }

