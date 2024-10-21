//This class represents a Task object with an ID, name, and description.
//It ensures that the ID, name, and description adhere to the required constraints.

public class Task {
 // Fields for Task object
 private final String taskId;
 private String name;
 private String description;

 // Constructor that initializes the task object with ID, name, and description
 public Task(String taskId, String name, String description) {
     // Ensure the taskId is not null, not longer than 10 characters
     if (taskId == null || taskId.length() > 10) {
         throw new IllegalArgumentException("Task ID must be non-null and no longer than 10 characters.");
     }
     // Ensure the name is not null, not longer than 20 characters
     if (name == null || name.length() > 20) {
         throw new IllegalArgumentException("Task name must be non-null and no longer than 20 characters.");
     }
     // Ensure the description is not null, not longer than 50 characters
     if (description == null || description.length() > 50) {
         throw new IllegalArgumentException("Task description must be non-null and no longer than 50 characters.");
     }
     
     this.taskId = taskId;
     this.name = name;
     this.description = description;
 }

 // Getter for taskId (no setter because ID is not updatable)
 public String getTaskId() {
     return taskId;
 }

 // Getter and setter for name
 public String getName() {
     return name;
 }

 public void setName(String name) {
     if (name == null || name.length() > 20) {
         throw new IllegalArgumentException("Task name must be non-null and no longer than 20 characters.");
     }
     this.name = name;
 }

 // Getter and setter for description
 public String getDescription() {
     return description;
 }

 public void setDescription(String description) {
     if (description == null || description.length() > 50) {
         throw new IllegalArgumentException("Task description must be non-null and no longer than 50 characters.");
     }
     this.description = description;
 }
}
