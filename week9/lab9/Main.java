import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PhoneList phoneList = readData("C:\\Users\\hamma\\OneDrive\\Documents\\Processing\\week9\\lab9\\phoneData.csv");

        System.out.println("Phone List Size: " + phoneList.size());

        // Print the whole PhoneList
        System.out.println("===== Phone List =====");
        System.out.println(phoneList);

        // Sort the PhoneList
        phoneList.sort();
        System.out.println("===== Sorted Phone List =====");
        System.out.println(phoneList);

        // Search for a phone
        System.out.println("===== Search Result =====");
        Phone searchedPhone = phoneList.searchPhone("Apple", "iPhone 7 Plus");
        if (searchedPhone != null) {
            System.out.println("Found: " + searchedPhone);
        } else {
            System.out.println("Phone not found.");
        }

        // Find and return a new PhoneList of expensive phones
        int priceThreshold = 600;
        PhoneList expensivePhones = phoneList.getExpensivePhones(priceThreshold);
        System.out.println("===== Expensive Phones (> " + priceThreshold + " Euros) =====");
        System.out.println(expensivePhones);
    }

    private static PhoneList readData(String filePath) {
        Scanner scanner = InputReader.getScanner(filePath);
        PhoneList phoneList = new PhoneList();

        if (scanner != null) {
            // Skip the header row
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String[] phoneData = scanner.nextLine().split(",");
                Phone phone = new Phone(phoneData[0]);  // Brand at index 0
                phone.setModel(phoneData[1]);  // Model at index 1
                phone.setAnnounced(phoneData[8]);  // Announced date at index 8
                phone.setWeight_g(Float.parseFloat(phoneData[11]));  // Weight in grams at index 11
                phone.setInternal_memory(phoneData[21]);  // Internal memory at index 21
                phone.setApprox_price_EUR(Integer.parseInt(phoneData[36]));  // Approximate price in Euros at index 36

                phoneList.addPhone(phone);
            }
        }

        return phoneList;
    }
}
