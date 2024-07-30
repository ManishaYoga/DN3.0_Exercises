public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        // Add tasks
        taskList.addTask(new Task(1, "Design System", "Pending"));
        taskList.addTask(new Task(2, "Implement Features", "In Progress"));
        taskList.addTask(new Task(3, "Test Application", "Pending"));

        // Traverse tasks
        System.out.println("Task List:");
        taskList.traverseTasks();

        // Search for a task
        System.out.println("Search Result:");
        Task searchResult = taskList.searchTask(2);
        System.out.println(searchResult != null ? searchResult : "Task not found.");

        // Delete a task
        taskList.deleteTask(2);

        // Traverse tasks after deletion
        System.out.println("Task List After Deletion:");
        taskList.traverseTasks();
    }
}
