import java.util.Scanner;
public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bigNumbers = 0;

        System.out.println("Hello world!");

        System.out.println("Please enter a number:");
        int input = sc.nextInt();

        String output = "\n\n";

        for(int i = 0; i < input; i++) {
            output += i + " x 4 = " + i*4 + "\n";

            if(i > 5) {
                bigNumbers += 1;
            }
        }

        System.out.println(output);
        System.out.println("There were " + bigNumbers + " big numbers!");

        sc.close();
    }
}