import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskServiceTest {

    @Test
    void testAddSingleTask() {
        // Test adding a single task to the task service
        TaskService taskService = new TaskService();
        Task task = new Task("123", "Clean Room", "Pick up clothes");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("123"));
    }

    @Test
    void testAddMultipleTasks() {
        // Test adding multiple tasks to the task service
        TaskService taskService = new TaskService();
        Task task1 = new Task("123", "Clean Room", "Pick up clothes");
        Task task2 = new Task("456", "Do Laundry", "Wash, dry and fold clothes");
        taskService.addTask(task1);
        taskService.addTask(task2);
        assertEquals(task1, taskService.getTask("123"));
        assertEquals(task2, taskService.getTask("456"));
    }

    @Test
    void testAddTaskWithDuplicateID() {
        // Test adding a task with a duplicate ID
        TaskService taskService = new TaskService();
        Task task1 = new Task("123", "Clean Room", "Pick up clothes");
        Task task2 = new Task("123", "Do Laundry", "Wash, dry and fold clothes");
        taskService.addTask(task1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
        assertEquals("Task ID already exists.", exception.getMessage());
    }

    @Test
    void testUpdateTask() {
        // Test updating a task's name and description in the task service
        TaskService taskService = new TaskService();
        Task task = new Task("123", "Clean Room", "Pick up clothes");
        taskService.addTask(task);
        taskService.updateTaskName("123", "Do Laundry");
        taskService.updateTaskDescription("123", "Wash, dry and fold clothes");
        assertEquals("Do Laundry", taskService.getTask("123").getName());
        assertEquals("Wash, dry and fold clothes", taskService.getTask("123").getDescription());
    }

    @Test
    void testDeleteTask() {
        // Test deleting a task from the task service
        TaskService taskService = new TaskService();
        Task task = new Task("123", "Clean Room", "Pick up clothes");
        taskService.addTask(task);
        taskService.deleteTask("123");
        assertNull(taskService.getTask("123"));
    }
}
