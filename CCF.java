import java.util.*;

public class CCF {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- City Connection Finder ---");
            System.out.println("1. Add Connection");
            System.out.println("2. Display All Connections");
            System.out.println("3. Check Direct Connection");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter City 1: ");
                    String city1 = scanner.nextLine();
                    System.out.print("Enter City 2: ");
                    String city2 = scanner.nextLine();

                    // Add connection for city1 to city2
                    if (!graph.containsKey(city1)) {
                        graph.put(city1, new ArrayList<String>());
                    }
                    graph.get(city1).add(city2);

                    // Add connection for city2 to city1 (undirected graph)
                    if (!graph.containsKey(city2)) {
                        graph.put(city2, new ArrayList<String>());
                    }
                    graph.get(city2).add(city1);

                    System.out.println("Connection added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- All Connections ---");
                    if (graph.isEmpty()) {
                        System.out.println("No connections available!");
                    } else {
                        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
                            System.out.println("City: " + entry.getKey() + " -> " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter City 1: ");
                    city1 = scanner.nextLine();
                    System.out.print("Enter City 2: ");
                    city2 = scanner.nextLine();

                    if (graph.containsKey(city1) && graph.get(city1).contains(city2)) {
                        System.out.println("Yes, there is a direct connection between " + city1 + " and " + city2 + ".");
                    } else {
                        System.out.println("No, there is no direct connection between " + city1 + " and " + city2 + ".");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the application...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
