public class Token {   
    //
    String javaText="";
    int scope=0;
    String pythonText;
    Token(String textIn, int scopeIn){

        javaText=textIn;
        scope=scopeIn;
       

    }


    @Override
    public String toString() {

        String returnThis="";

        for(int i=0;i<scope;i++){
            returnThis+="\t";
        }
        returnThis+=pythonText;


        return returnThis;
    }
    
}
