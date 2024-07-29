package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.Contact;
import main.java.ContactService;

class ContactServiceTest {

    private ContactService contactService;

    // Set up method to initialize ContactService before each test
    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    // Test adding a new contact
    @Test
    void testAddContact() {
        // Create a new Contact object
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Elm Street");
        // Add the Contact to the ContactService
        contactService.addContact(contact);
        // Retrieve the Contact from the ContactService and verify it matches the added Contact
        assertEquals(contact, contactService.getContact("1"));
    }

    // Test deleting an existing contact
    @Test
    void testDeleteContact() {
        // Create and add a Contact to the ContactService
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Elm Street");
        contactService.addContact(contact);
        // Delete the Contact from the ContactService
        contactService.deleteContact("1");
        // Verify that the Contact no longer exists in the ContactService
        assertNull(contactService.getContact("1"));
    }

    // Test updating an existing contact
    @Test
    void testUpdateContact() {
        // Create and add a Contact to the ContactService
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Elm Street");
        contactService.addContact(contact);
        // Update the Contact's first name and address
        contactService.updateContact("1", "Jane", null, null, "456 Oak Street");
        // Retrieve the updated Contact from the ContactService
        Contact updatedContact = contactService.getContact("1");
        // Verify that the Contact's first name and address have been updated correctly
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("456 Oak Street", updatedContact.getAddress());
    }

    // Test adding a duplicate contact (same ID)
    @Test
    void testAddDuplicateContact() {
        // Create and add a Contact with ID "1"
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Elm Street");
        contactService.addContact(contact);
        // Attempt to add another Contact with the same ID and expect an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(new Contact("1", "Jane", "Doe", "0987654321", "456 Oak Street"));
        });
        // Verify that the exception message is correct
        assertEquals("Contact is null or ID already exists.", exception.getMessage());
    }
}
