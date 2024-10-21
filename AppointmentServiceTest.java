import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

    // Test adding a valid appointment and verifying it's stored correctly.
    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("1234567890", new java.util.Date(System.currentTimeMillis() + 100000), "Test appointment");
        service.addAppointment(appointment);

        // Group assertions to verify the added appointment can be retrieved by its ID.
        assertAll("Verify added appointment",
            () -> assertEquals(appointment, service.getAppointment("1234567890"), "The retrieved appointment should match the added one.")
        );
    }

    // Test that adding a duplicate appointment (same ID) throws an exception.
    @Test
    public void testAddDuplicateAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("1234567890", new java.util.Date(System.currentTimeMillis() + 100000), "Test appointment");
        service.addAppointment(appointment);

        // Group assertions to check adding a duplicate appointment throws an exception.
        assertAll("Check adding duplicate appointment",
            () -> assertThrows(IllegalArgumentException.class, () -> {
                service.addAppointment(new Appointment("1234567890", new java.util.Date(System.currentTimeMillis() + 100000), "Another appointment"));
            }, "Adding a duplicate appointment should throw IllegalArgumentException.")
        );
    }

    // Test deleting an existing appointment and ensuring it's removed from storage.
    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("1234567890", new java.util.Date(System.currentTimeMillis() + 100000), "Test appointment");
        service.addAppointment(appointment);
        service.deleteAppointment("1234567890");

        // Group assertions to verify the appointment is deleted and can't be retrieved.
        assertAll("Verify appointment deletion",
            () -> assertNull(service.getAppointment("1234567890"), "The appointment should be null after deletion.")
        );
    }

    // Test deleting a non-existent appointment (invalid ID) throws an exception.
    @Test
    public void testDeleteNonExistentAppointment() {
        AppointmentService service = new AppointmentService();

        // Group assertions to check that deleting a non-existent appointment throws an exception.
        assertAll("Check deleting non-existent appointment",
            () -> assertThrows(IllegalArgumentException.class, () -> {
                service.deleteAppointment("nonexistent");
            }, "Deleting a non-existent appointment should throw IllegalArgumentException.")
        );
    }
}
