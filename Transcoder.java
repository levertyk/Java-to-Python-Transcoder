import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 * @author <a href="mailto:keenanleverty@gmail.com">Keenan Leverty</a>, //TODO add authors
 * 
 * 
 */

public class Transcoder {
    // ArrayList<Token> tokens = new ArrayList<Token>(); //TODO implement line object creation
    String input;

    /** 
     * 
     */
    Transcoder() {
        input = "";
    }

    /**
     * 
     */
    Transcoder(String input) {
        this.input = input;
    }

    public void addInput(String input) {
        this.input += input;
    }

    public String toString() {
        return "";
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

        // Transcoder tr = new Transcoder(input.replaceAll("\\s", ""));

        try {
            String outputPath = inputPath.replaceAll(".java", ".py");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
            // writer.write(tr.toString());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());         // Could not create output file
        }
    }
}