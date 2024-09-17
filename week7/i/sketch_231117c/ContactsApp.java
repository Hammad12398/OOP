import java.util.ArrayList;
import java.util.List;

public class ContactsApp {
    private List<Contact> contacts = new ArrayList<>();
    private int currentIndex = 0; // To keep track of the current contact index

    public ContactsApp() {
        // Initialize contacts by reading data from the CSV file using InputReader
        loadContacts("C:\\Users\\hamma\\Downloads\\Contacts.csv");
    }

    private void loadContacts(String filePath) {
        // Use InputReader to read data from the CSV file and populate the contacts ArrayList
        List<String[]> data = InputReader.readCSV(filePath);

        for (String[] contactData : data) {
            Contact contact = new Contact(contactData[0], contactData[1]);
            contact.setEmail(contactData[2]);
            contact.setPhoneNumber(contactData[3]);
            contacts.add(contact);
        }
    }

    public Contact getCurrentContact() {
        // Return the current contact
        return contacts.get(currentIndex);
    }

    public void nextContact() {
        // Move to the next contact
        currentIndex = (currentIndex + 1) % contacts.size();
    }

    public void previousContact() {
        // Move to the previous contact
        currentIndex = (currentIndex - 1 + contacts.size()) % contacts.size();
    }

    public List<Contact> getContacts() {
        // Return the list of contacts
        return contacts;
    }
}
