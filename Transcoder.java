import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 * @author <a href="mailto:keenanleverty@gmail.com">Keenan Leverty</a>, //TODO add authors
 * 
 * 
 */

public class Transcoder {
    ArrayList<Token> tokens = new ArrayList<Token>();
    String input;
    int scope;

    /** 
     * 
     */
    Transcoder() {
        input = "";
        scope = 0;
    }

    /**
     * 
     */
    Transcoder(String input) {
        this.input = input;
        scope = 0;
    }

    public void addInput(String input) {
        this.input += input;
    }

    private void process() {
        // // remove all whitespace
        // input.replaceAll("\\n", "");

        // remove all public/private/static identifiers
        input.replaceAll("[public|static|private]", "");

        //remove all 

        // remove java class declarations from input string
        input.replaceAll("class\\w+{", "");     // remove initialisation
        input.substring(0, input.length() - 1);                                // remove final '}'

        // break up input string into tokens
        Scanner sc = new Scanner(input);
        while (sc.hasNext()) {
            // if(sc.next)
        }
    }

    private void simple(String token) {

    }

    @Override
    public String toString() {
        String output = "";
        for(Token t : tokens) {
            output += t.toString();
        }
        return output;
    }

    /**
     * Run the program. Prompt the user for the file path of the java file to be trascoded.
     * 
     * @param args
     */
    public static void main(String[] args) {
        String inputPath = "";
        String input = "";
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the file path to be trascoded:\n");
        inputPath = in.nextLine();

        in.close();

        try {
            File file = new File(inputPath);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                input += sc.nextLine();
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());         // Could not find the file
        }

        Transcoder tr = new Transcoder(input);

        try {
            String outputPath = inputPath.replaceAll(".java", ".py");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
            writer.write("heyo, she worked!!!!");       //TODO replace with transcoder output string
            // writer.write(tr.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());         // Could not create output file
        }
    }
}