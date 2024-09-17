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
        StringBuilder result = new StringBuilder("Name: ").append(firstname).append(" ").append(lastname);
        if (email != null) {
            result.append("\nEmail: ").append(email);
        }
        if (phoneNumber != null) {
            result.append("\nPhone: ").append(phoneNumber);
        }
        return result.toString();
    }
}
