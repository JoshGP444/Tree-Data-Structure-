import java.util.PriorityQueue;
import java.util.Scanner;

public class TDP{
    public static class Task implements Comparable<Task> {
        private String description;
        private int priority;

        public Task(String description, int priority) {
            this.description = description;
            this.priority = priority;
        }

        public String getDescription() {
            return description;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(other.priority, this.priority); 
        }

        @Override
        public String toString() {
            return "[Priority " + priority + "] " + description;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Task> toDoList = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the To-Do List App!");
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:{
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter priority (1 - Lowest, 10 - Highest): ");
                    int priority = scanner.nextInt();
                    toDoList.add(new Task(description, priority));
                    System.out.println("Task added successfully!");
                }
                break;
                case 2 :{
                    if (toDoList.isEmpty()) {
                        System.out.println("Your to-do list is empty.");
                    } else {
                        System.out.println("Your To-Do List:");
                        PriorityQueue<Task> tempQueue = new PriorityQueue<>(toDoList); 
                        while (!tempQueue.isEmpty()) {
                            System.out.println(tempQueue.poll());
                        }
                    }
                }
                break;
                case 3:{
                    if (toDoList.isEmpty()) {
                        System.out.println("No tasks to mark as done.");
                    } else {
                        System.out.println("Marking task as done: " + toDoList.poll());
                    }
                }
                break;
                case 4:{
                    System.out.println("Exiting To-Do List App. Stay productive!");
                    scanner.close();
                    return;
                }
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}