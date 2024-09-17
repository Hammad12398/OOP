import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Specify the correct path to your CSV file
        String filePath = "C:\\Users\\hamma\\OneDrive\\Documents\\Processing\\week7\\InputReader\\Contacts.csv";

        // Read CSV data using the new CsvInputReader
        ArrayList<String[]> contactsData = CsvInputReader.readCSV(filePath);

        // Print the data (for demonstration purposes)
        for (String[] contact : contactsData) {
            for (String value : contact) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
