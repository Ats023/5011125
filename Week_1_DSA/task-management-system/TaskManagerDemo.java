class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

class TaskManager {
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskManager() {
        head = null;
    }

    // Add a task to the end of the list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by taskId
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Delete a task by taskId
    public void deleteTask(int taskId) {
        if (head == null) return;

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            System.out.println("Task with ID " + taskId + " deleted.");
            return;
        }

        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Task with ID " + taskId + " deleted.");
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        Node current = head;
        if (current == null) {
            System.out.println("No tasks to display.");
        } else {
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }
    }
}

public class TaskManagerDemo {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task task1 = new Task(1, "Task A", "Pending");
        Task task2 = new Task(2, "Task B", "Completed");
        Task task3 = new Task(3, "Task C", "In Progress");

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        System.out.println("Tasks after adding:");
        taskManager.traverseTasks();

        System.out.println("\nSearching for task with ID 2:");
        Task searchedTask = taskManager.searchTask(2);
        if (searchedTask != null) {
            System.out.println("Found: " + searchedTask);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting task with ID 3:");
        taskManager.deleteTask(3);

        System.out.println("\nTasks after deletion:");
        taskManager.traverseTasks();
    }
}
