import java.util.Scanner;
public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello world!");

        int x = 0;
        String variableName = "corn Starch";
        String userInput = sc.next();
        double wow = 1.0;
        boolean isBad = false;
        char c = 'a';

        if(x==1) {
            x+=1;
        }

        for (int i = 0; i < 10; i +=1) {
            x = i;

            if( i < 3) {
                isBad = true;
                System.out.println("Kill me, please!!!!!");
            }
        }

        while(isBad) {
            wow += 1;
            isBad = false;
        }
    }
}