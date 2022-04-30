/**
 * Token template class for all other tokens
 * 
 * @author <a href="mailto:keenanleverty@gmail.com">Keena Leverty</a>
 * @author Peter Matern
 */
public class Token {
    public String input;
    public int scope;

    /**
     * Simple constructor initializing variables
     * @param input
     * @param scope
     */
    Token(String input, int scope) {
        this.input = input;
        this.scope = scope;
    }

    /**
     * Returns an amount of tabs for the scope of the token.
     * @return String of tab characters
     */
    public String gimmeTabs() {
        String output = "";

        for(int i = 0; i < scope; i++) {
            output += "\t";
        }

        return output;
    }
}

// import java.util.ArrayList;

// public class Token {
// String javaText="";
// int scope=0;
// String pythonText;
// ArrayList<Token> tokens=new ArrayList<Token>();

// Token(String textIn, int scopeIn){
// pythonText="";
// javaText=textIn;
// scope=scopeIn;
// this.converter();

// }

// @Override
// public String toString() {

// String returnThis="";

// for(int i=0;i<scope;i++){
// returnThis+="\t";
// }
// returnThis+=pythonText;

// return returnThis;
// }

// public void converter(){
// // String regExp=(mathExp.replaceAll("(\\d+\\.?\\d*|\\.\\d+)", "d"));

// for(int i = javaText.length(); i >=1; i--) {
// if(javaText.charAt(i) == '}') {
// int tempScope = 0;
// int startIndex = -1;
// for(int j = javaText.length(); j >= 1; j--) {
// if(javaText.charAt(j) == '}'){
// tempScope++;
// }
// else if(javaText.charAt(j) == '{' && tempScope > 0) {
// tempScope--;
// } else if(javaText.charAt(j) == '{' && tempScope == 0) {
// startIndex = j;
// }
// }

// for(int j = startIndex; )
// }
// }

// for (int i = 0; i < javaText.length(); i++) {
// if(javaText.substring(i, i+2).equals("if")) {
// int startIndex = javaText.indexOf("{");

// int endIndex = -1;
// int tempScope = 0;
// for(int j = startIndex; j < javaText.length(); j++){
// if(javaText.charAt(j) == '{') scope++;
// else if(javaText.charAt(j) == '}' && scope > 0) scope--;
// else if(javaText.charAt(j) == '}' && scope == 0) {
// endIndex = j;
// break;
// }
// }

// tokens.add(new Token(javaText.substring(startIndex, endIndex)));

// pythonText += addScopes() + "if ";

// int conditionalStartIndex = 0;
// int conditionalEndIndex = 0;
// for(int j = i; j < startIndex; j++){
// if(charAt(j) == '(') conditionalStartIndex = j;
// if(charAt(j) == ')') conditionalEndIndex = j;
// }

// pythonText += javaText.substring(conditionalStartIndex+1,
// conditionalEndIndex) + " :\n";
// pythonText +=
// }
// }

// pythonText=javaText;

// pythonText=(pythonText.replaceAll("int|String|double|boolean|char|;", ""));
// if(pythonText.substring(0, 4).contains("for")){

// }
// if(pythonText.substring(0,6).contains("while")){

// }
// if(pythonText.contains("if")){

// }

// }

// private String addScopes() {
// String output = "";
// for(int i = 0; i < scope; i++) {
// output += "\t";
// }
// return output;
// }
// }
