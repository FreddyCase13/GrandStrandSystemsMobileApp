class ContactService {
    private Contact[] contacts; //Array to hold Contact objects, with a maximum capacity of 100
    private int contactCount; // Counter to track the number of contacts currently stored

    // Constructor to initialize the ContactService
    public ContactService() {
        contacts = new Contact[100]; // Assume a max of 100 contacts for simplicity.
        contactCount = 0; // Start with zero contacts
    }

    // Method to add a new contact to the service
    public void addContact(Contact contact) {
    	// Checks if the contact array is full
        if (contactCount >= contacts.length) {
            throw new IllegalStateException("Contact list is full");
        }
        // Ensures that the contact ID is unique
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID must be unique");
            }
        }
        // Adds the contact to the array and increment the contact count
        contacts[contactCount] = contact;
        contactCount++;
    }

    // Method to delete a contact by its ID
    public void deleteContact(String contactId) {
        boolean found = false; // Flag to indicate if the contact was found
        // Loops through contacts to find the one to delete
        for (int i = 0; i < contactCount; i++) {
        	// Check if the current contact matches the provided contact ID
            if (contacts[i].getContactId().equals(contactId)) {
            	// Replace the found contact with the last contact in the array
                contacts[i] = contacts[contactCount - 1]; // Replace with the last contact
                contacts[contactCount - 1] = null; // Clear the last contact position
                contactCount--; // Decrease the contact count
                found = true; // Set the found flag to true
                break; // Exit the loop
            }
        }
    	// If the contact was not found, throw an exception
        if (!found) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
    }

 // Method to update an existing contact's details by its ID
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
    	// Loop through the contacts to find the one to update
        for (int i = 0; i < contactCount; i++) {
        	// Check if the current contact matches the provided contact ID
            if (contacts[i].getContactId().equals(contactId)) {
            	// Update the first name if it is valid
                if (firstName != null && firstName.length() <= 10) {
                    contacts[i].setFirstName(firstName);
                }
                // Update the last name if it is valid
                if (lastName != null && lastName.length() <= 10) {
                    contacts[i].setLastName(lastName);
                }
                // Update the phone number if it is valid
                if (phone != null && phone.length() == 10) {
                    contacts[i].setPhone(phone);
                }
                // Update the address if it is valid
                if (address != null && address.length() <= 30) {
                    contacts[i].setAddress(address);
                }
                return; // Exit after updating the contact
            }
        }
        // If the contact was not found, throw an exception
        throw new IllegalArgumentException("Contact ID does not exist");
    }

    // Method to retrieve a contact by its ID
    public Contact getContact(String contactId) {
    	// Loop through the contacts to find the one requested
        for (int i = 0; i < contactCount; i++) {
        	// Check if the current contact matches the provided contact ID
            if (contacts[i].getContactId().equals(contactId)) {
                return contacts[i]; // Return the found contact
            }
        }
        return null; // Return null if no contact was found
    }
}
