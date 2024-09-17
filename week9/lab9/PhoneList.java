import java.util.ArrayList;
import java.util.Collections;

public class PhoneList {
    private ArrayList<Phone> phones;

    public PhoneList() {
        this.phones = new ArrayList<>();
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public int size() {
        return phones.size();
    }

    public void sort() {
        Collections.sort(phones);
    }

    public Phone searchPhone(String brand, String model) {
        for (Phone phone : phones) {
            if (phone.getBrand().equals(brand) && phone.getModel().equals(model)) {
                return phone;
            }
        }
        return null;
    }

    public PhoneList getExpensivePhones(int price) {
        PhoneList expensivePhones = new PhoneList();
        for (Phone phone : phones) {
            if (phone.getApprox_price_EUR() > price) {
                expensivePhones.addPhone(phone);
            }
        }
        expensivePhones.sort();
        return expensivePhones;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Phone phone : phones) {
            result.append(phone.toString()).append("\n");
        }
        return result.toString();
    }
}
