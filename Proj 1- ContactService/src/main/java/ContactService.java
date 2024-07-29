package main.java;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>(); // Map to store contacts using their ID as the key

    // Add a contact to the service
    public void addContact(Contact contact) {
        // Validate the contact object and check for duplicate ID
        if (contact == null || contacts.containsKey(contact.getId())) {
            throw new IllegalArgumentException("Contact is null or ID already exists.");
        }
        // Add the contact to the map
        contacts.put(contact.getId(), contact);
    }

    // Delete a contact from the service
    public void deleteContact(String id) {
        // Validate the ID and check if the contact exists
        if (id == null || !contacts.containsKey(id)) {
            throw new IllegalArgumentException("ID is null or does not exist.");
        }
        // Remove the contact from the map
        contacts.remove(id);
    }

    // Update an existing contact with new information
    public void updateContact(String id, String firstName, String lastName, String phone, String address) {
        // Retrieve the contact by ID
        Contact contact = contacts.get(id);
        // Validate that the contact exists
        if (contact == null) {
            throw new IllegalArgumentException("ID does not exist.");
        }
        // Update the contact fields if new values are provided
        if (firstName != null) contact.setFirstName(firstName);
        if (lastName != null) contact.setLastName(lastName);
        if (phone != null) contact.setPhone(phone);
        if (address != null) contact.setAddress(address);
    }

    // Retrieve a contact by ID
    public Contact getContact(String id) {
        // Return the contact if found, otherwise returns null
        return contacts.get(id);
    }
}
