public class baseToken extends Token {


    Token simpOrComp;
    BaseToken nextBase;
    BaseToken(String input,int scope){
        super(input, scope);


        if(input.startsWith("while")){
            int tempScope=0;
            for(int i=input.indexOf("{");i<input.length();i++){
                if(input.charAt(i)=='{'){
                    tempScope++;
                }else if(input.charAt(i)=='}'){
                    
                })

            }

        }else if(input.startsWith("if")){


        }else if(input.startsWith("for")){

        }

    }
        

    }

