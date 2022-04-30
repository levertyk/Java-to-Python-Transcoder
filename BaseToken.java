public class BaseToken extends Token {

    Token simpOrComp;
    BaseToken nextBase;

    BaseToken(String input, int scope) {
        super(input, scope);
        if(input==""){

        }
       else if (input.startsWith("while")) {
            int tempScope = 0;
            int endOfComplex = 0;
            for (int i = input.indexOf("{"); i < input.length(); i++) {
                if (input.charAt(i) == '{') {
                    tempScope++;
                } else if (input.charAt(i) == '}') {
                    tempScope--;
                }
                if (tempScope == 0) {
                    endOfComplex = i;
                    break;
                }

            }
            simpOrComp = new ComplexToken(input.substring(0, endOfComplex), scope + 1, false);
            nextBase= new BaseToken(input.substring(endOfComplex+1), scope);
        } else if (input.startsWith("if")) {
            int tempScope = 0;
            int endOfComplex = 0;
            for (int i = input.indexOf("{"); i < input.length(); i++) {
                if (input.charAt(i) == '{') {
                    tempScope++;
                } else if (input.charAt(i) == '}') {
                    tempScope--;
                }
                if (tempScope == 0) {
                    endOfComplex = i;
                    break;
                }

            }
            simpOrComp = new ComplexToken(input.substring(0, endOfComplex), scope + 1, false);
            nextBase= new BaseToken(input.substring(endOfComplex+1), scope);
        } else if (input.startsWith("for")) {
            int tempScope = 0;
            int endOfComplex = 0;
            for (int i = input.indexOf("{"); i < input.length(); i++) {
                if (input.charAt(i) == '{') {
                    tempScope++;
                } else if (input.charAt(i) == '}') {
                    tempScope--;
                }
                if (tempScope == 0) {
                    endOfComplex = i;
                    break;
                }

            }
            simpOrComp = new ComplexToken(input.substring(0, endOfComplex), scope + 1, true);
            nextBase= new BaseToken(input.substring(endOfComplex+1), scope);
        } else if (input.indexOf(';') != -1) {
            simpOrComp= new SimpleToken(input.substring(0,input.indexOf(';')), scope);
            nextBase= new BaseToken(input.substring(input.indexOf(';')), scope);
        }

    }

}
