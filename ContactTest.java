import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	// Test case to verify the successful creation of a Contact object
	@Test
	void testContact() {
		Contact contact = new Contact("123", "Freddy", "Case", "1234567890", "2A Marc Dr");
		// Assert that the contact's fields match the expected values
        assertEquals("123", contact.getContactId());
        assertEquals("Freddy", contact.getFirstName());
        assertEquals("Case", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("2A Marc Dr", contact.getAddress());
    }

	// Test case to verify that an exception is thrown for an invalid contact ID
    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Freddy", "Case", "1234567890", "2A Marc Dr");
        });
    }

    // Test case to verify that an exception is thrown for an invalid first name
    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "LongFirstName", "Case", "1234567890", "2A Marc Dr");
        });
    }
    
    // Test case to verify that an exception is thrown for an invalid last name
    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Freddy", "LongLastName", "1234567890", "2A Marc Dr");
        });
    }

    // Test case to verify that an exception is thrown for an invalid phone number
    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Freddy", "Case", "1", "2A Marc Dr");
        });
    }

    // Test case to verify that an exception is thrown for an invalid address
    @Test
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Freddy", "Case", "1234567890", "2A Marc Drive Plymouth MA 02360");
        });
    }

    // Test case to verify the updating of contact fields
    @Test
    void testUpdateContactFields() {
        Contact contact = new Contact("123", "Freddy", "Case", "1234567890", "2A Marc Dr");
        contact.setFirstName("Rob");
        contact.setLastName("Tuft");
        contact.setPhone("0987654321");
        contact.setAddress("101 Main St");

        // Assert that the updated fields match the expected values
        assertEquals("Rob", contact.getFirstName());
        assertEquals("Tuft", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("101 Main St", contact.getAddress());
    }
}
