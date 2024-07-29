package main.java;

public class Contact {
    private final String id;           // Unique contact ID, cannot be changed once set
    private String firstName;           // First name of the contact (up to 10 characters)
    private String lastName;            // Last name of the contact (up to 10 characters)
    private String phone;               // Phone number of the contact (exactly 10 digits)
    private String address;             // Address of the contact (up to 30 characters)

    // Constructor to initialize a new Contact object
    public Contact(String id, String firstName, String lastName, String phone, String address) {
        // Validate the ID
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("ID cannot be null and must be 10 characters or less.");
        }
        // Validate the first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null and must be 10 characters or less.");
        }
        // Validate the last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null and must be 10 characters or less.");
        }
        // Validate the phone number
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits.");
        }
        // Validate the address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null and must be 30 characters or less.");
        }

        // Initialize fields
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter for ID
    public String getId() {
        return id;
    }

    // Getter for first name
    public String getFirstName() {
        return firstName;
    }

    // Setter for first name
    public void setFirstName(String firstName) {
        // Validate the new first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null and must be 10 characters or less.");
        }
        this.firstName = firstName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Setter for last name
    public void setLastName(String lastName) {
        // Validate the new last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null and must be 10 characters or less.");
        }
        this.lastName = lastName;
    }

    // Getter for phone number
    public String getPhone() {
        return phone;
    }

    // Setter for phone number
    public void setPhone(String phone) {
        // Validate the new phone number
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        // Validate the new address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null and must be 30 characters or less.");
        }
        this.address = address;
    }
}
