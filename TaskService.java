// TaskService.java
// This class manages Task objects using in-memory storage (without imports).
// It allows adding, updating, and deleting tasks while ensuring unique IDs.

public class TaskService {
    // The maximum number of tasks supported (since we cannot use external collections)
    private final Task[] taskArray = new Task[100];
    private int taskCount = 0;

    // Method to find task index by task ID
    private int findTaskIndex(String taskId) {
        for (int i = 0; i < taskCount; i++) {
            if (taskArray[i].getTaskId().equals(taskId)) {
                return i;
            }
        }
        return -1;
    }

    // Method to add a task if the ID is unique
    public void addTask(Task task) {
        if (findTaskIndex(task.getTaskId()) != -1) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        if (taskCount >= taskArray.length) {
            throw new IllegalArgumentException("Task storage limit reached.");
        }
        taskArray[taskCount++] = task;
    }

    // Method to delete a task by its ID
    public void deleteTask(String taskId) {
        int taskIndex = findTaskIndex(taskId);
        if (taskIndex == -1) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        // Shift tasks to fill the gap
        for (int i = taskIndex; i < taskCount - 1; i++) {
            taskArray[i] = taskArray[i + 1];
        }
        taskArray[--taskCount] = null; // Decrease count and clear the last element
    }

    // Method to update the name of a task by its ID
    public void updateTaskName(String taskId, String newName) {
        int taskIndex = findTaskIndex(taskId);
        if (taskIndex == -1) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        taskArray[taskIndex].setName(newName);
    }

    // Method to update the description of a task by its ID
    public void updateTaskDescription(String taskId, String newDescription) {
        int taskIndex = findTaskIndex(taskId);
        if (taskIndex == -1) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        taskArray[taskIndex].setDescription(newDescription);
    }

    // Method to retrieve a task by its ID
    public Task getTask(String taskId) {
        int taskIndex = findTaskIndex(taskId);
        if (taskIndex == -1) {
            return null;
        }
        return taskArray[taskIndex];
    }
}