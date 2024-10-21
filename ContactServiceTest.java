import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	// Test case to verify adding a single contact and retrieving it by ID
	@Test
    void testAddSingleContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "Freddy", "Case", "1234567890", "2A Marc Dr");
        contactService.addContact(contact);// Add the contact to the service
        // Assert that the retrieved contact matches the added contact
        assertEquals(contact, contactService.getContact("123"));
    }

	// Test case to verify adding multiple contacts and retrieving them
    @Test
    void testAddMultipleContacts() {
        ContactService contactService = new ContactService();
        Contact contact1 = new Contact("123", "Freddy", "Case", "1234567890", "2A Marc Dr");
        Contact contact2 = new Contact("456", "Rob", "Tuft", "0987654321", "101 Main St");
        contactService.addContact(contact1); // Add the first contact
        contactService.addContact(contact2); // Add the second contact
        // Assert that both contacts can be retrieved correctly
        assertEquals(contact1, contactService.getContact("123"));
        assertEquals(contact2, contactService.getContact("456"));
    }

    // Test case to verify that adding a contact with a duplicate ID throws an error
    @Test
    void testAddDuplicateContactIdThrowsError() {
        ContactService contactService = new ContactService();
        Contact contact1 = new Contact("123", "Freddy", "Case", "1234567890", "2A Marc Dr");
        Contact contact2 = new Contact("123", "Rob", "Tuft", "0987654321", "101 Main St");
        contactService.addContact(contact1); // Add the first contact
        // Assert that adding the second contact with a duplicate ID throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2); // Duplicate ID should throw an error
        });
    }

    // Test case to verify adding a contact and retrieving it back
    @Test
    void testAddAndGetContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("789", "David", "Ortiz", "1122334455", "34 HOF St");
        contactService.addContact(contact); // adds contact to the service
        Contact retrievedContact = contactService.getContact("789"); // retrieve the contact by ID
        // Assert that the retrieved contact matches the added contact
        assertEquals(contact, retrievedContact);
    }

    // Test case to verify updating a contact's fields
    @Test
    void testUpdateContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "Freddy", "Case", "1234567890", "2A Marc Dr");
        contactService.addContact(contact); // Add the contact

        // Update fields of the contact
        contactService.updateContact("123", "Rob", "Tuft", "0987654321", "101 Main St");
        Contact updatedContact = contactService.getContact("123");

        // Assert that the updated fields are correct
        assertEquals("Rob", updatedContact.getFirstName());
        assertEquals("Tuft", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("101 Main St", updatedContact.getAddress());
    }

    // Test case to verify deleting a contact
    @Test
    void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "Freddy", "Case", "1234567890", "2A Marc Dr");
        contactService.addContact(contact); // Add the contact

        // Delete the contact
        contactService.deleteContact("123");

        // Assert that the contact is no longer present
        assertNull(contactService.getContact("123")); // Should return null after deletion
    }
}
