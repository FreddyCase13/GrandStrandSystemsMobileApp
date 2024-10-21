import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    void testTaskObjectCreation() {
        // Testing successful Task object creation
        Task task = new Task("123", "Clean Room", "Pick up clothes");
        assertEquals("123", task.getTaskId());
        assertEquals("Clean Room", task.getName());
        assertEquals("Pick up clothes", task.getDescription());
    }

    @Test
    void testTaskIsTooLong() {
        // Test that an exception is thrown if task ID is longer than 10 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Clean Room", "Pick up clothes");
        });
        assertEquals("Task ID must be non-null and no longer than 10 characters.", exception.getMessage());
    }

    @Test
    void testTaskNameTooLong() {
        // Test that an exception is thrown if task name is longer than 20 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "Pick up clothes");
        });
        assertEquals("Task name must be non-null and no longer than 20 characters.", exception.getMessage());
    }

    @Test
    void testTaskDescriptionTooLong() {
        // Test that an exception is thrown if task description is longer than 50 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Clean Room", "AABBCCDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZ.");
        });
        assertEquals("Task description must be non-null and no longer than 50 characters.", exception.getMessage());
    }

    @Test
    void testNullValues() {
        // Test that an exception is thrown if any field (task ID, name, or description) is null
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Clean Room", "Pick up clothes"));
        assertThrows(IllegalArgumentException.class, () -> new Task("123", null, "Pick up clothes"));
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "Clean Room", null));
    }
}
