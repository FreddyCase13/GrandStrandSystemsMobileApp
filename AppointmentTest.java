import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AppointmentTest {

    // Test creating a valid appointment with proper values.
    @Test
    public void testValidAppointment() {
        Appointment appointment = new Appointment("1234567890", new java.util.Date(System.currentTimeMillis() + 100000), "Valid description");
        
        // Group assertions to verify the appointment ID, date, and description are correctly set.
        assertAll("Valid appointment checks",
            () -> assertEquals("1234567890", appointment.getAppointmentId(), "Appointment ID should match"),
            () -> assertNotNull(appointment.getAppointmentDate(), "Appointment date should not be null"),
            () -> assertEquals("Valid description", appointment.getDescription(), "Description should match")
        );
    }

    // Test that invalid appointment IDs (null or too long) throw exceptions.
    @Test
    public void testInvalidAppointmentId() {
        assertAll("Invalid appointment ID checks",
            () -> assertThrows(IllegalArgumentException.class, () -> {
                new Appointment(null, new java.util.Date(System.currentTimeMillis() + 100000), "Description");
            }, "Should throw IllegalArgumentException for null ID"),

            () -> assertThrows(IllegalArgumentException.class, () -> {
                new Appointment("12345678901", new java.util.Date(System.currentTimeMillis() + 100000), "Description");
            }, "Should throw IllegalArgumentException for ID longer than 10 characters")
        );
    }

    // Test that invalid appointment dates (in the past or null) throw exceptions.
    @Test
    public void testInvalidAppointmentDate() {
        assertAll("Invalid appointment date checks",
            () -> assertThrows(IllegalArgumentException.class, () -> {
                new Appointment("1234567890", new java.util.Date(System.currentTimeMillis() - 100000), "Description"); // Past date.
            }, "Should throw IllegalArgumentException for past date"),

            () -> assertThrows(IllegalArgumentException.class, () -> {
                new Appointment("1234567890", null, "Description"); // Null date.
            }, "Should throw IllegalArgumentException for null date")
        );
    }

    // Test that invalid descriptions (null or too long) throw exceptions.
    @Test
    public void testInvalidDescription() {
        assertAll("Invalid description checks",
            () -> assertThrows(IllegalArgumentException.class, () -> {
                new Appointment("1234567890", new java.util.Date(System.currentTimeMillis() + 100000), null); // Null description.
            }, "Should throw IllegalArgumentException for null description"),

            () -> assertThrows(IllegalArgumentException.class, () -> {
                new Appointment("1234567890", new java.util.Date(System.currentTimeMillis() + 100000), "This description is way too long and should throw an exception because it exceeds 50 characters.");
            }, "Should throw IllegalArgumentException for description longer than 50 characters")
        );
    }
}
