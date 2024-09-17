import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    public static List<String[]> readCSV(String fileName) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            // Handle the exception more appropriately, e.g., log it or throw a custom exception
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }

        return data;
    }
}
