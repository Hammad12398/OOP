public class Contact {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact: " + firstName + " " + lastName + "\nEmail: " + email + "\nPhone: " + phoneNumber;
    }
}
