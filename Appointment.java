public class Appointment {
    private final String appointmentId;
    private final java.util.Date appointmentDate;
    private final String description;

    // Constructor with validation for the fields
    public Appointment(String appointmentId, java.util.Date appointmentDate, String description) {
        // Validate appointment ID
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }

        // Validate appointment date: It should not be null or in the past
        if (appointmentDate == null || appointmentDate.before(new java.util.Date())) {
            throw new IllegalArgumentException("Invalid appointment date: It cannot be in the past or null");
        }

        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description: Must be non-null and under 50 characters");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public java.util.Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}
