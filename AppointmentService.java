public class AppointmentService {
    
    // In-memory storage for appointments, with the appointment ID as the key.
    private final java.util.Map<String, Appointment> appointmentMap;

    // Constructor initializes the appointment map.
    public AppointmentService() {
        this.appointmentMap = new java.util.HashMap<>();  // Fully qualified names to avoid import.
    }

    // Adds an appointment if the ID is unique.
    public void addAppointment(Appointment appointment) {
        if (appointmentMap.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment with this ID already exists");
        }
        appointmentMap.put(appointment.getAppointmentId(), appointment);
    }

    // Deletes an appointment by its ID if it exists.
    public void deleteAppointment(String appointmentId) {
        if (!appointmentMap.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment with this ID does not exist");
        }
        appointmentMap.remove(appointmentId);
    }

    // Retrieves an appointment by its ID.
    public Appointment getAppointment(String appointmentId) {
        return appointmentMap.get(appointmentId);
    }
}
