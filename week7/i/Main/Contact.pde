public class Contact {
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;

    public Contact(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + firstname + " " + lastname + "\nEmail: " + email + "\nPhone: " + phoneNumber;
    }
}
