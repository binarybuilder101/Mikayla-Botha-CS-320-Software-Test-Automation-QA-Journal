package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import main.java.Contact;

class ContactTest {

    // Test creating a valid Contact
    @Test
    void testCreateValidContact() {
        // Create a new Contact object with valid parameters
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Elm Street");
        // Verify that the Contact's ID, first name, last name, phone number, and address are correctly set
        assertEquals("1", contact.getId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Elm Street", contact.getAddress());
    }

    // Test creating a Contact with an invalid ID
    @Test
    void testCreateContactWithInvalidId() {
        // Attempt to create a Contact with a null ID and expect an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Elm Street");
        });
        // Verify that the exception message indicates the ID is invalid
        assertEquals("ID cannot be null and must be 10 characters or less.", exception.getMessage());
    }

    // Test creating a Contact with an invalid phone number
    @Test
    void testCreateContactWithInvalidPhone() {
        // Attempt to create a Contact with an invalid phone number (less than 10 digits) and expect an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "12345678", "123 Elm Street");
        });
        // Verify that the exception message indicates the phone number is invalid
        assertEquals("Phone must be exactly 10 digits.", exception.getMessage());
    }

    // Test creating a Contact with a long address
    @Test
    void testCreateContactWithLongAddress() {
        // Attempt to create a Contact with an address longer than 30 characters and expect an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "1234567890", "This address is definitely longer than thirty characters.");
        });
        // Verify that the exception message indicates the address is too long
        assertEquals("Address cannot be null and must be 30 characters or less.", exception.getMessage());
    }
}
