import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class InputReader {

    public static final Scanner getScanner(String file) {
        try {
            return new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        String fileName = "Contacts.csv";
        Scanner scanner = getScanner(fileName);

        if (scanner != null) {
            // Assuming the CSV file has a header, read and print it
            if (scanner.hasNextLine()) {
                String header = scanner.nextLine();
                System.out.println("Header: " + header);
            }

            // Read and print the rest of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line: " + line);
            }

            scanner.close();
        }
    }
}
