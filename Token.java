public class Token {   
    //
    String javaText="";
    int scope=0;
    String pythonText;
    Token(String textIn, int scopeIn){

        javaText=textIn;
        scope=scopeIn;
       this.converter();

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

    public void converter(){
       // String regExp=(mathExp.replaceAll("(\\d+\\.?\\d*|\\.\\d+)", "d"));

        pythonText=javaText;

        pythonText=(pythonText.replaceAll("int |String |double |boolean |char ", ""));
        if(pythonText.contains("for")){

        }
        if(pythonText.contains("while")){
        
        }
        if(pythonText.contains("")){

        }

    }

    
}
