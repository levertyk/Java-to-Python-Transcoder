import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 * @author <a href="mailto:keenanleverty@gmail.com">Keenan Leverty</a>, //TODO add authors
 * 
 * 
 */

public class Transcoder {
    ClassToken startingToken;

    /**
     * 
     * @param input
     */
    Transcoder(String input) {
        startingToken = new ClassToken(input);
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return startingToken.toString();
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
            writer.write(tr.toString());
            writer.close();
            System.out.println("The file was successfully transcoded");
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());         // Could not create output file
        }
    }
}