import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hashtable<String, String> scheduleTracker = new Hashtable<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Schedule Tracker ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks for a Date");
            System.out.println("3. Update Tasks for a Date");
            System.out.println("4. Delete Tasks for a Date");
            System.out.println("5. Display All Schedules");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    if (scheduleTracker.containsKey(date)) {
                        System.out.println("Tasks already exist for this date!");
                    } else {
                        System.out.print("Enter Task(s): ");
                        String tasks = scanner.nextLine();
                        scheduleTracker.put(date, tasks);
                        System.out.println("Tasks added successfully!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    date = scanner.nextLine();
                    if (scheduleTracker.containsKey(date)) {
                        System.out.println("Tasks for " + date + ": " + scheduleTracker.get(date));
                    } else {
                        System.out.println("No tasks found for this date.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    date = scanner.nextLine();
                    if (scheduleTracker.containsKey(date)) {
                        System.out.print("Enter New Task(s): ");
                        String newTasks = scanner.nextLine();
                        scheduleTracker.put(date, newTasks);
                        System.out.println("Tasks updated successfully!");
                    } else {
                        System.out.println("No tasks found for this date.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    date = scanner.nextLine();
                    if (scheduleTracker.remove(date) != null) {
                        System.out.println("Tasks deleted successfully!");
                    } else {
                        System.out.println("No tasks found for this date.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- All Schedules ---");
                    if (scheduleTracker.isEmpty()) {
                        System.out.println("No schedules available!");
                    } else {
                        scheduleTracker.forEach((key, value) -> System.out.println("Date: " + key + ", Tasks: " + value));
                    }
                    break;

                case 6:
                    System.out.println("Exiting the application...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}public